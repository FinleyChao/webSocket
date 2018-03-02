package com.folish.rabbit;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	 protected static Logger logger=LoggerFactory.getLogger(Sender.class); 
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public String sendMessage(String msg){
		String context = "hi, fanout msg: "+msg;  
        logger.debug("Sender : " + context);  
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
        return context;
	}
}
