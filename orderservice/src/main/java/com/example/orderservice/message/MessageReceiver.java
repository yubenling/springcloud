package com.example.orderservice.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/*
 *@create yubenling
 *@date  2019/8/24
 *@desc  */
@Slf4j
public class MessageReceiver {


    /**
     * 定义接收rabbit中队列名为springbootqueue中的消息
     */
    @RabbitListener(queues = "springbootqueue")  //这种方式必须在rabbitmq中创建队列
    @RabbitListener(queuesToDeclare = @Queue("springbootqueue"))  //这种方式当rabbitmq中没有队列时，自动bindings = @QueueBinding
    //这种方式也会自动创建队列，exchange是rabbit的一个交换机
    @RabbitListener(bindings = @QueueBinding(
           value =@Queue("springbootqueue"),
            exchange = @Exchange("springbootExchage")
    ))
    public void ReceiverMessage(String message){
       log.info("接收到到的消息为{}",message);
    }

    /**
     * 接收电脑的订单小
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value =@Queue("computerQueue"),
            key = "computer",
            exchange = @Exchange("exchage")
    ))
    public void ReceiverComputerMessage(String message){
        log.info("接收到到的消息为{}",message);
    }

    /**
     * 接收水果的订单消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value =@Queue("fruitQueue"),
            key = "fruit",
            exchange = @Exchange("exchage")
    ))
    public void ReceiverFruitMessage(String message){
        log.info("接收到到的消息为{}",message);
    }

}
