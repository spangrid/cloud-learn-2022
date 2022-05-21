package com.shou.controller;

import com.shou.entities.CommonResult;
import com.shou.entities.Payment;
import com.shou.feign.FeignPaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private FeignPaymentService feignPaymentService;

    @PostMapping("/consumer/payment/create")
    public CommonResult<?> createPayment(@RequestBody Payment payment) {
        return feignPaymentService.createPayment(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<?> getPaymentById(@PathVariable("id") Long id) {
        return feignPaymentService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String timeoutTest() {
        return feignPaymentService.timeoutTest();
//        return null;
    }
}
