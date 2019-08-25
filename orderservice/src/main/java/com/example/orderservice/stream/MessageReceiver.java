package com.example.orderservice.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/*
 *@create yubenling
 *@date  2019/8/24
 *@desc  */
@Component
@EnableBinding
@Slf4j
public class MessageReceiver {

    @StreamListener("Mymessage")
    public void MessageReceiver(Object message){
        log.info("stream传递的消息为{}",message);
    }
}
