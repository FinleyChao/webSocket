package com.folish.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	
	final static String message = "topic.one";  
    final static String messages = "topic.two";  
  
    @Bean  
    public Queue queueMessage() {  
        return new Queue(message);  
    }  
  
    @Bean  
    public Queue queueMessages() {  
        return new Queue(messages);  
    }  
  
    @Bean  
    TopicExchange exchange() {  
        return new TopicExchange("exchange");  
    }  
  
    @Bean  
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {  
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");  
    }  
  
    @Bean  
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {  
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");  
    }  
}
