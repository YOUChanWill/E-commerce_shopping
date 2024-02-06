package com.chanwill.ecommerce_shopping.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

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

    /**fanout,广播模式**/
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutMQ1(String msg) throws InterruptedException{
        System.out.println("消费者1接收到fanout队列消息[" + msg + "].....");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutMQ2(String msg) throws InterruptedException{
        System.out.println("消费者2接收到fanout队列消息[" + msg + "].....");
    }

    /**direct,直连模式**/
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1",durable = "true"),
            exchange = @Exchange(name = "shop.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}
    ))
    public void listenDirectMQ1(String msg) throws InterruptedException{
        System.out.println("消费者1接收到direct队列消息[" + msg + "].....");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2",durable = "true"),
            exchange = @Exchange(name = "shop.direct",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}
    ))
    public void listenDirectMQ2(String msg) throws InterruptedException{
        System.out.println("消费者2接收到direct队列消息[" + msg + "].....");
    }

    /**topic,匹配模式**/
    @RabbitListener(queues = "topic.queue1")
    public void listenTopicMQ1(String msg) throws InterruptedException{
        System.out.println("消费者1接收到topic队列消息[" + msg + "].....");
    }

    @RabbitListener(queues = "topic.queue2")
    public void listenTopicMQ2(String msg) throws InterruptedException{
        System.out.println("消费者2接收到topic队列消息[" + msg + "].....");
    }

    @RabbitListener(queues = "Object.queue")
    public void listenObjectMQ(Map<String, Object> msg) throws InterruptedException{
        System.out.println("接收到队列消息[" + msg + "].....");
    }





}
