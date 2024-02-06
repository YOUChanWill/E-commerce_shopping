package com.chanwill.ecommerce_shopping.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    // 声明交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("shop.fanout");
    }

    // 声明队列
    @Bean
    public Queue fanoutQueue3(){
        return new Queue("fanout.queue3");
    }

    @Bean
    public Queue fanoutQueue4(){
        return new Queue("fanout.queue4");
    }

    // 绑定队列
    @Bean
    public Binding bindingQueue1(Queue fanoutQueue3,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange);
    }

    @Bean
    public Binding bindingQueue4(){
        return BindingBuilder.bind(fanoutQueue4()).to(fanoutExchange());
    }

}
