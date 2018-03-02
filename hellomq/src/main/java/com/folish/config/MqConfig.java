package com.folish.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MqConfig {

	@Bean
	public Queue kittyQueueA(){
		return new Queue("kitty.A");
	}
	@Bean
	public Queue kittyQueueB(){
		return new Queue("kitty.B");
	}
	@Bean
	public Queue kittyQueueC(){
		return new Queue("kitty.C");
	}
	
	@Bean 
	public Exchange fanoutExchange(){
		return new FanoutExchange("fanoutExchange");
	}
	
	@Bean
	Binding bindingExchangeA(Queue kittyQueueA,FanoutExchange fanoutExchange) {  
        return BindingBuilder.bind(kittyQueueA).to(fanoutExchange);  
    }  
	
	@Bean
	Binding bindingExchangeB(Queue kittyQueueB,FanoutExchange fanoutExchange) {  
        return BindingBuilder.bind(kittyQueueB).to(fanoutExchange);  
    }  
	
	@Bean
	Binding bindingExchangeC(Queue kittyQueueC,FanoutExchange fanoutExchange) {  
        return BindingBuilder.bind(kittyQueueC).to(fanoutExchange);  
    }  
	
}
