package com.zsh.springcloud.service.impl;

import com.zsh.springcloud.entities.Payment;
import com.zsh.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private com.zsh.springcloud.dao.IPaymentService paymentService;

    @Override
    public int create(Payment payment) {
        return paymentService.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentService.getPaymentById(id);
    }
}
