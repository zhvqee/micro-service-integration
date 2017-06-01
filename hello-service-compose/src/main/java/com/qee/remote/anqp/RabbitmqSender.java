package com.qee.remote.anqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by hzzhuqi1 on 2017/5/25.
 */
@Component
public class RabbitmqSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public  void send(String info){
        String content="hello,"+info+"  " + new Date();
        rabbitTemplate.convertAndSend("hello_queue",content);
    }
}
