package com.lemon.springboot.producer;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lemon.springboot.entity.Order;

@Component
public class OrderSender {
	@Autowired
	RabbitTemplate rebbitTemplate;

	public void sendOrder(Order order) {
		CorrelationData correlationData = new CorrelationData();
		correlationData.setId(order.getMessageId());

		rebbitTemplate.convertAndSend("order-exchange", // exchange,
				"order.abcd", // routingKey,
				order, // object
				correlationData// correlationData 消息唯一ID
		);
	}

}
