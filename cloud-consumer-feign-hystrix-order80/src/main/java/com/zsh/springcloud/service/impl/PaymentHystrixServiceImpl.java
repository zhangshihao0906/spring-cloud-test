package com.zsh.springcloud.service.impl;

import com.zsh.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "Implements paymentInfo_OK fallback";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "Implements paymentInfo_Timeout fallback";
    }
}
