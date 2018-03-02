package com.folish.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener ( queues = "kitty.A")
public class ReceiverA {

	protected static Logger logger=LoggerFactory.getLogger(ReceiverA.class); 
	
	@RabbitHandler
	public void receiveMessage(String msg){
		System.out.println("fanout Receiver A  : " + msg);
	}
}
