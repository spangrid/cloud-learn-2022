package com.shou.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/test/{id}")
    public String test(@PathVariable("id") Long id) {
        return "testOk访问成功，请求id位" + id + "\n端口：" + serverPort + "\n线程池：" + Thread.currentThread().getName();
    }

    @GetMapping("payment/test/longtime/{id}")
    public String testLongtime(@PathVariable("id") Long id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testTimeout访问成功，请求id位" + id + "\n端口：" + serverPort + "\n线程池：" + Thread.currentThread().getName();
    }
}
