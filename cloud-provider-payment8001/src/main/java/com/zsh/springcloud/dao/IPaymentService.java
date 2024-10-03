package com.zsh.springcloud.dao;

import com.zsh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IPaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
