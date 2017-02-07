package com.bbva.mailman.config.rabbitmq;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import com.bbva.mailman.config.common.ConstantsRepository;

@Configuration
@EnableRabbit
public class RabbitMQConfiguration implements RabbitListenerConfigurer {
	
	@Autowired
	@Qualifier("constantsRepository")
	private ConstantsRepository constantsRepository;
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(constantsRepository.EXCHANGE_NAME);
	}
	
	//GENERIC QUEUES
	@Bean
	public Queue queueGeneric() {
		return new Queue(constantsRepository.QUEUE_GENERIC_NAME);
	}
	
	@Bean
	public Queue queueSpecific() {
		return new Queue(constantsRepository.QUEUE_SPECIFIC_NAME);
	}
	
	@Bean
	public Binding declareBindingGeneric() {
		return BindingBuilder.bind(queueGeneric()).to(topicExchange()).with(constantsRepository.ROUTING_KEY_GENERIC);
	}
	
	@Bean
	public Binding declareBindingSpecific() {
		return BindingBuilder.bind(queueSpecific()).to(topicExchange()).with(constantsRepository.ROUTING_KEY_SPECIFIC);
	}
	
	//ORDERS QUEUES
	@Bean
	public Queue queueOrdersRequest(){
		return new Queue(constantsRepository.QUEUE_ORDERS_REQUEST);
	}
	
	@Bean
	public Queue queueOrdersRespond(){
		return new Queue(constantsRepository.QUEUE_ORDERS_RESPOND);
	}
	
	@Bean
	public Binding declareBindingOrdersRequest() {
		return BindingBuilder.bind(queueOrdersRequest()).to(topicExchange()).with(constantsRepository.ROUTING_KEY_ORDERS);
	}
	
	
	//CONVERTERS
	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory){
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}
	
	@Bean
	public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(consumerJackson2MessageConverter());
		return factory;
	}
	
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
		rabbitListenerEndpointRegistrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	}

}
