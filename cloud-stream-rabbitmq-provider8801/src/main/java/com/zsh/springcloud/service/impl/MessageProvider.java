package com.zsh.springcloud.service.impl;

import com.zsh.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProvider implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public void send() {

        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("*****uuid" +uuid);
    }
}
