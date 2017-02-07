package com.bbva.mailman.services.common;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bbva.mailman.config.common.ConstantsRepository;
import com.bbva.mailman.models.Message;

@Service("messageSender")
public class MessageSender {
	
	private static final Logger LOG = Logger.getLogger(MessageSender.class);
	
	@Autowired
	@Qualifier("constantsRepository")
	private ConstantsRepository constantsRepository;
	
	private final RabbitTemplate rabbitTemplate;
	
	public MessageSender(final RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessage(Message message){
		LOG.info("Sending message --> " + message);
		rabbitTemplate.convertAndSend(constantsRepository.EXCHANGE_NAME, constantsRepository.ROUTING_KEY_GENERIC, message);
	}

}
