package com.folish.entity;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue_socket")
public class RabbitConsumor{

	@RabbitHandler
	public void onMessage(String message){
		System.out.println("consumor:" + message.toString());  
        for(WebSocketServer webSocketServer :WebSocketServer.webSocketSet){  
            try {  
                webSocketServer.sendMessage(message.toString());
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
	}
	

}
