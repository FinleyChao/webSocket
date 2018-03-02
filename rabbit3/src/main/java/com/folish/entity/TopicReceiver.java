package com.folish.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {

	protected static Logger logger=LoggerFactory.getLogger(TopicReceiver.class);   
    
    @RabbitHandler  
    public void process(String message) {  
        logger.debug("Topic Receiver1  : " + message);  
        System.out.println("Topic Receiver1  : " + message);
    }  
}
