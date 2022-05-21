package com.shou;

import com.lb.LoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = {LoadBalanceConfig.class})
public class ConsumerOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain.class, args);
    }
}
