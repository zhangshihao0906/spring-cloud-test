package com.zsh.springcloud.controller;

import com.zsh.springcloud.entities.CommonResult;
import com.zsh.springcloud.entities.Payment;
import com.zsh.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public ResponseEntity<CommonResult<Payment>> create(@RequestBody Payment payment) {
        log.info("****post server info:{}", serverPort);
        int result = paymentService.create(payment);

        if (result > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(new CommonResult<>(Integer.valueOf(serverPort), "success", payment));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResult<>(500, "failure", null));
        }
    }

    @GetMapping(value = "/payment/{id}")
    public ResponseEntity<CommonResult<Payment>> getPaymentById(@PathVariable(value = "id") Long id) {
        log.info("****get server info:{}", serverPort);
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new CommonResult<>(Integer.valueOf(serverPort), "success", payment));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CommonResult<>(404, "failure", null));
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        for (String service : list) {
            log.info("***service: " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("***instance: " + instance.getInstanceId() + instance.getHost() + ":" + instance.getPort() + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/timeout")
    public String paymentTimeout() throws InterruptedException {
        log.info("****sleep 3s");
        //Thread.sleep(3000);
        return serverPort;
    }
}
