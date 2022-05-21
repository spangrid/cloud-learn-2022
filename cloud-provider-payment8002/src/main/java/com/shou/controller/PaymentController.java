package com.shou.controller;

import com.shou.entities.CommonResult;
import com.shou.entities.Payment;
import com.shou.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    PaymentService paymentService;

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
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            return new CommonResult<>(1001, serverPort + "查询订单失败" + id);
        } else {
            return new CommonResult<>(100, serverPort + "查询成功", payment);
        }
    }
}
