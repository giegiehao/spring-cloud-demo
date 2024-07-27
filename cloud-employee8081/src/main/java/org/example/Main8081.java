package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("org.example.dao")
@EnableDiscoveryClient
public class Main8081 {
    public static void main(String[] args) {
        SpringApplication.run(Main8081.class, args);
    }
}