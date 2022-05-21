package com.shou.controller;

import com.shou.entities.CommonResult;
import com.shou.entities.Payment;
import com.shou.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Resource
    DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<?> createPayment(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult<>(100, serverPort + "成功创建订单");
        } else {
            return new CommonResult<>(1000, serverPort + "创建订单失败");
        }
    }

    @GetMapping("payment/get/{id}")
    public CommonResult<?> getPaymentById(@PathVariable("id") Long id) {
//        List<String> services = discoveryClient.getServices();
//        System.out.println("服务发现: "+services);
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        System.out.println(instances);
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            return new CommonResult<>(1001, serverPort + "查询订单失败" + id);
        } else {
            return new CommonResult<>(100, serverPort + "查询成功", payment);
        }
    }

    @GetMapping("payment/timeout")
    public String timeoutTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "feignTimeoutTest pass";
    }
}
