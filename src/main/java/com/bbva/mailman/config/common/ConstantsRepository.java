package com.bbva.mailman.config.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("constantsRepository")
public class ConstantsRepository {
	
	public static final String EXCHANGE_NAME = "appNexus";
	
	//GENERIC CONSTANTS
	public static final String QUEUE_GENERIC_NAME = "appGenericQueue";
	public static final String QUEUE_SPECIFIC_NAME = "appSpecificQueue";
	public static final String ROUTING_KEY_GENERIC = "generic.key";
	public static final String ROUTING_KEY_SPECIFIC = "specific.key";
	
	//ORDERS CONSTANTS
	public static final String QUEUE_ORDERS_REQUEST = "FRONT.ORDER.REQUEST";
	public static final String QUEUE_ORDERS_RESPOND = "FRONT.ORDER.RESPOND";
	public static final String ROUTING_KEY_ORDERS = "orders.key";

}
