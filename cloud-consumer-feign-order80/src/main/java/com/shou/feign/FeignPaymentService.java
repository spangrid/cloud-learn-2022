package com.shou.feign;

import com.shou.entities.CommonResult;
import com.shou.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface FeignPaymentService {

    @PostMapping("/payment/create")
    CommonResult<?> createPayment(@RequestBody Payment payment);

    @GetMapping("payment/get/{id}")
    CommonResult<?> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("payment/timeout")
    String timeoutTest();
}
