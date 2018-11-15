package com.zg.apex.clientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientdemoApplication.class, args);
    }
}
