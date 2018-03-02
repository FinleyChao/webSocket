package com.folish.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Bean
	Queue queue(){
		return new Queue("queue_socket");
	}
	
	
}
