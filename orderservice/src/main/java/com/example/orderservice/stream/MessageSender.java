package com.example.orderservice.stream;

/*
 *@create yubenling
 *@date  2019/8/24
 *@desc  */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;

public class MessageSender {



    @Autowired
    private  StreamClient streamClient;


    //发送消息
    public void  MessageSender(Object message){
        boolean 要发送的消息 = streamClient.output().send(MessageBuilder.withPayload("要发送的消息").build());
    }
}
