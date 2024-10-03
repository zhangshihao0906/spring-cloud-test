package com.zsh.springcloud.controller;

import com.zsh.springcloud.entities.CommonResult;
import com.zsh.springcloud.entities.Payment;
import com.zsh.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/{id}")
    public ResponseEntity<CommonResult<Payment>> getPaymentById(@PathVariable(value = "id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @PostMapping("/consumer/payment/create")
    public ResponseEntity<CommonResult<Payment>> create(@RequestBody Payment payment) {
        return paymentFeignService.create(payment);
    }

    @GetMapping("/consumer/payment/timeout")
    public String timeout() throws InterruptedException {
        return paymentFeignService.paymentTimeout();
    }
}
