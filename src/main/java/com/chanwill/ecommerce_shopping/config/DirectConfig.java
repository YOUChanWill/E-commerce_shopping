package com.chanwill.ecommerce_shopping.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    // 声明交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("shop.direct");
    }

    // 声明队列
    @Bean
    public Queue directQueue1(){
        return new Queue("direct.queue1");
    }

    @Bean
    public Queue directQueue2(){
        return new Queue("direct.queue2");
    }
}
