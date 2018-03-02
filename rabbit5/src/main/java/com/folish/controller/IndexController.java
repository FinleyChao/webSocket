package com.folish.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.folish.entity.Sender;

@RestController
public class IndexController {

	@Autowired
	private Sender sender;
	
	@RequestMapping("/sendMsg")
	public void sendMsg(@RequestParam("msg") String msg,HttpServletRequest request){  
		System.out.println("--send Message:"+msg);
		System.out.println("Request Session="+request.getSession());
		sender.sendMessage(msg);  
	   }  
}
