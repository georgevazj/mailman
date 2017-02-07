package com.bbva.mailman.config.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import com.bbva.mailman.config.common.ConstantsRepository;

@Configuration
@EnableRabbit
public class OrdersMQConfiguration implements RabbitListenerConfigurer {
	
	@Autowired
	@Qualifier("constantsRepository")
	private ConstantsRepository constantsRepository;

	public void configureRabbitListeners(RabbitListenerEndpointRegistrar arg0) {
		// TODO Auto-generated method stub
		
	}

}
