package com.example.orderservice.message;

/*
 *@create yubenling
 *@date  2019/8/24
 *@desc  */

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageSender {

    //注入amqpTemplate
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 使用amqpTemplate发送消息
     * @param message
     */
    public void messageSender(String message){
        amqpTemplate.convertAndSend("springbootqueue","发送的消息");
    }


    //同一个队列通过交换机将消息分类
    //消息都往交换机里放，交换机通过通过key来决定放在哪个队列里
    //rabbitmq中会出现两个队列
    public void exchageMessageSender(String message){
        amqpTemplate.convertAndSend("exchage","computer","要发送的消息");
    }
}
