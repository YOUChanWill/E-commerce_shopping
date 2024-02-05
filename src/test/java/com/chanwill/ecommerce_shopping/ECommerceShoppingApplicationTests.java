package com.chanwill.ecommerce_shopping;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
