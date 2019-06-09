package com.vinspier.rabbitmq.receiver;

import com.vinspier.rabbitmq.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receiveMsg(String msg){
        System.out.println("==============================================================");
        System.out.println("Receiver: " + msg);
        System.out.println("==============================================================");
    }

}
