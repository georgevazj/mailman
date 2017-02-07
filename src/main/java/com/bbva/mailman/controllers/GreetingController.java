package com.bbva.mailman.controllers;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.bbva.mailman.models.Greeting;
import com.bbva.mailman.models.HelloMessage;
import com.bbva.mailman.models.Message;
import com.bbva.mailman.services.common.MessageListener;
import com.bbva.mailman.services.common.MessageSender;

@Controller
public class GreetingController {
	
	private static final Logger LOG = Logger.getLogger(GreetingController.class);
	
	@Autowired
	@Qualifier("messageSender")
	private MessageSender messageSender;
	
	@Autowired
	@Qualifier("messageListener")
	private MessageListener messageListener;
	
	
	@MessageMapping("/hello")
	public void greeting(HelloMessage helloMessage) throws Exception {
		LOG.info("Received --> " + helloMessage);
		Thread.sleep(1000);
		Message message = new Message();
		message.setBody("Hello " + helloMessage.getName() + "!");
		message.setPriority(new Random().nextInt(50));
		message.setSecret(false);
		messageSender.sendMessage(message);
	}

}
