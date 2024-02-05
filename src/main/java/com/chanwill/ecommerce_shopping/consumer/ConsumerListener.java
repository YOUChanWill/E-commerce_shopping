package com.chanwill.ecommerce_shopping.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerListener {

    @RabbitListener(queues = "shop")
    public void listenSimpleMQ(String msg) throws InterruptedException{
        System.out.println("消费者接收到消息[" + msg + "] ");
        System.out.println("消息处理完成！");
    }


    @RabbitListener(queues = "work")
    public void listenWorkMQ1(String msg) throws InterruptedException{
        System.out.println("消费者1接收到work队列消息[" + msg + "] ");
        Thread.sleep(20);

    }

    @RabbitListener(queues = "work")
    public void listenWorkMQ2(String msg) throws InterruptedException{
        System.out.println("消费者2接收到work队列消息[" + msg + "].....");
        Thread.sleep(20);
    }
}
