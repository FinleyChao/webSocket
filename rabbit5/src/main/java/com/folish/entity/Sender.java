package com.folish.entity;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void sendMessage(String message){
		rabbitTemplate.convertAndSend("queue_socket",message);
	}
}
