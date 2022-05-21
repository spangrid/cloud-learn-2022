package com.shou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignOrderMain.class, args);
    }
}
