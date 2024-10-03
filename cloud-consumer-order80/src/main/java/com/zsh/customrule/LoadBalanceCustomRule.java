package com.zsh.customrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalanceCustomRule {

    @Bean
    public IRule getRandomRule() {
        return new RandomRule();
    }
}
