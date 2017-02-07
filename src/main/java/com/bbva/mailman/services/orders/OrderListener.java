package com.bbva.mailman.services.orders;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bbva.mailman.config.common.ConstantsRepository;
import com.bbva.mailman.models.Order;

@Component
public class OrderListener {
	
	private static final Logger LOG = Logger.getLogger(OrderListener.class);
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@RabbitListener(queues = ConstantsRepository.QUEUE_ORDERS_RESPOND)
	public void receiveOrderRespond(final Order order){
		LOG.info("Received respond from " + ConstantsRepository.QUEUE_ORDERS_RESPOND + ": " + order);
		this.template.convertAndSend("/topic/holidays", order);
	}

}
