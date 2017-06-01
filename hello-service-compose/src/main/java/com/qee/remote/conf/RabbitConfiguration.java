package com.qee.remote.conf;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hzzhuqi1 on 2017/5/25.
 */
@Configuration
public class RabbitConfiguration {
    @Bean
    public Queue getHelloQueue(){
        return new Queue("hello_queue");
    }
}
