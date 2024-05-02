package com.study.线程;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisHashTagCalculator {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public int calculateHashSlot(String key) {
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        if (connectionFactory != null && connectionFactory.getClusterConnection() != null) {
            RedisClusterConnection clusterConnection = connectionFactory.getClusterConnection();
            return clusterConnection.clusterGetSlotForKey(key.getBytes());
        } else {
            throw new IllegalStateException("The Redis connection factory is not configured or not a cluster connection.");
        }
    }

    public int calculateShard(int hashSlot, int shardCount) {
        return hashSlot % shardCount;
    }

    public static void main(String[] args) {
        RedisHashTagCalculator redisHashTagCalculator = new RedisHashTagCalculator();
        int hashSlot = redisHashTagCalculator.calculateHashSlot("my_key");
        int shard = redisHashTagCalculator.calculateShard(hashSlot, 4); // 假设有 4 个集群分片
        System.out.println("The key 'my_key' hits shard: " + shard);

    }
}
