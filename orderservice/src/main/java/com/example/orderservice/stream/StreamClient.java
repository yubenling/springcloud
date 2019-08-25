package com.example.orderservice.stream;

/*
 *@create yubenling
 *@date  2019/8/24
 *@desc
 *
 *  */

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 定义一个接口
 */
public interface StreamClient {

    @Input(value = "Mymessage")
    SubscribableChannel input();

    @Output(value = "Mymessage")
    MessageChannel output();
}
