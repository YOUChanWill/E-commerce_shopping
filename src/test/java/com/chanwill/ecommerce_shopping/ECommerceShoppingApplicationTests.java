package com.chanwill.ecommerce_shopping;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class ECommerceShoppingApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testshopMQ() {
        String queueName = "shop";
        String msg = "Hello,AMQP";
        rabbitTemplate.convertAndSend(queueName,msg);
    }

    @Test
    void tesworkMQ() {
        String queueName = "work";
        for (int i = 0; i < 50; i++) {
            String msg = "the work " + i;
            rabbitTemplate.convertAndSend(queueName,msg);
        }
    }

    @Test
    void tesSendFanout() {
        String exchangeName = "fanout";
        String msg = "Hello,Fanout";
        rabbitTemplate.convertAndSend(exchangeName,null,msg);
    }


    @Test
    void tesSendDirect1() {
        String exchangeName = "direct";
        String msg = "Hello,Red";
        rabbitTemplate.convertAndSend(exchangeName,"red",msg);
    }

    @Test
    void tesSendDirect2() {
        String exchangeName = "direct";
        String msg = "Hello,Blue";
        rabbitTemplate.convertAndSend(exchangeName,"blue",msg);
    }

    @Test
    void tesSendTopic1() {
        String exchangeName = "topic";
        String msg = "Hello,news";
        rabbitTemplate.convertAndSend(exchangeName,"janpan.news",msg);
    }

    @Test
    void tesSendTopic2() {
        String exchangeName = "topic";
        String msg = "Hello,chinanews";
        rabbitTemplate.convertAndSend(exchangeName,"china.news",msg);
    }

    @Test
    void testSendObject(){
        HashMap<String, Object> msg = new HashMap<>(2);
        msg.put("name","you");
        msg.put("age","23");
        rabbitTemplate.convertAndSend("Object.queue",msg);
    }

}
