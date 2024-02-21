package com.study.jvm.List_筛选_取交集;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 取交集
 * @Author : Williams
 * Date : 2023/3/7 21:42
 */
public class demo {
    public static void main (String[]args){
        List<CustomerDetailDTO> customers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CustomerDetailDTO customerDetailDTO = new CustomerDetailDTO();
            customerDetailDTO.setCorpId(Long.valueOf(i));
            customerDetailDTO.setName(i + "");
            customerDetailDTO.setPhone(i + "");
            customerDetailDTO.setId(Long.valueOf(i));
            customers.add(customerDetailDTO);
        }
        System.out.println(customers);

        List<String> phones = new ArrayList<>();
        phones.add("1");
        phones.add("2");
        phones.add("3");


        List<String> phones2 = new ArrayList<>();
        phones2.add("4");
        customers.removeIf(customer -> phones.stream().anyMatch(phone -> phone.equals(customer.getPhone())));
        System.out.println(customers);
        customers = customers.stream().filter(c -> phones2.stream().anyMatch(h -> h.equals(c.getPhone()))).collect(Collectors.toList());
        System.out.println(customers);

    }


    public static class CustomerDetailDTO  {
        private Long id;
        private Long corpId;
        private String name;
        private String phone;
        CustomerDetailDTO(){

        }
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getCorpId() {
            return corpId;
        }

        public void setCorpId(Long corpId) {
            this.corpId = corpId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
