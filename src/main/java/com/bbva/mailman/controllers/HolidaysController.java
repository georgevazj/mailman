package com.bbva.mailman.controllers;


import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.bbva.mailman.models.Order;

@Controller
public class HolidaysController {
	
	private static final Logger LOG = Logger.getLogger(HolidaysController.class);
	
	@MessageMapping("/neworder")
	private void newOrder(Order order){
		
	}
	
	

}
