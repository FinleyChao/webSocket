package com.folish.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.folish.entity.TopicSender;

@RestController
public class IndexController {

	
	 @Autowired  
	    private TopicSender topicSender;  
	      
	    @RequestMapping("/send1")  
	    public String send1() {  
	        topicSender.send1();  
	        return "send1 ok";  
	    }  
	      
	    @RequestMapping("/send2")  
	    public String send2() {  
	        topicSender.send2();  
	        return "send2 ok";  
	    }  
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello World!";
	}
}
