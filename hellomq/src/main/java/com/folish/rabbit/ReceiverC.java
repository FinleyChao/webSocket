package com.folish.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener ( queues = "kitty.C")
public class ReceiverC {

	protected static Logger logger=LoggerFactory.getLogger(ReceiverC.class);
	
	@RabbitHandler
	public void receiveMessage(String msg){
		System.out.println("fanout Receiver C : " + msg);
	}
}
