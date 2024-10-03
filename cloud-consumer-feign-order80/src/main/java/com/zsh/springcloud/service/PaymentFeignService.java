package com.zsh.springcloud.service;

import com.zsh.springcloud.entities.CommonResult;
import com.zsh.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/{id}")
    ResponseEntity<CommonResult<Payment>> getPaymentById(@PathVariable(value = "id") Long id);

    @PostMapping(value = "/payment/create")
    ResponseEntity<CommonResult<Payment>> create(@RequestBody Payment payment);

    @GetMapping(value = "/payment/timeout")
    String paymentTimeout() throws InterruptedException;

}
