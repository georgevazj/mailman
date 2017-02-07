package com.bbva.mailman.services.common;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bbva.mailman.config.common.ConstantsRepository;
import com.bbva.mailman.models.Greeting;
import com.bbva.mailman.models.Message;

@Component
public class MessageListener {
	
	private static final Logger LOG = Logger.getLogger(MessageListener.class);
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@RabbitListener(queues = ConstantsRepository.QUEUE_GENERIC_NAME)
	public void receiveMessage(final Message message) throws Exception {
		LOG.info("Received message as generic: " + message.toString());
		Greeting greeting = new Greeting();
		greeting.setContent(message.getBody());
		this.template.convertAndSend("/topic/greetings", greeting);
	}
}
