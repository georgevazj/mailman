package com.bbva.mailman.services.orders;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bbva.mailman.config.common.ConstantsRepository;
import com.bbva.mailman.models.Order;

@Service("orderSender")
public class OrderSender {
	
	private static final Logger LOG = Logger.getLogger(OrderSender.class);
	
	@Autowired
	@Qualifier("constantsRepository")
	private ConstantsRepository constantsRepository;
	
	private final RabbitTemplate rabbitTemplate;
	
	public OrderSender(final RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendOrder(Order order){
		LOG.info("Sending holidays order -> " + order);
		rabbitTemplate.convertAndSend(constantsRepository.EXCHANGE_NAME, constantsRepository.ROUTING_KEY_ORDERS, order);
	}

}
