package com.folish.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private Sender sender;
	
	@RequestMapping("/hello/{msg}")
	public String helloSender(@PathVariable("msg") String msg){
		return sender.sendMessage(msg);
	}
}
