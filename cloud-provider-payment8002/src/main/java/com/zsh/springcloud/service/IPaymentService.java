package com.zsh.springcloud.service;

import com.zsh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface IPaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
