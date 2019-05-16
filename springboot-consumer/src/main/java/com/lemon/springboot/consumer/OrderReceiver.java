package com.lemon.springboot.consumer;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.lemon.springboot.entity.Order;
import com.rabbitmq.client.Channel;

@Component
public class OrderReceiver {
	// @RabbitHandler 标识如果有消息过来，消费者调用此方法消费

	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "order-queue", durable = "true"), exchange = @Exchange(name = "order-exchange", durable = "true", type = "topic"), key = "order.*"))
	@RabbitHandler
	public void onOrderMessage(@Payload Order order, @Headers Map<String, Object> headers, Channel channel)
			throws Exception {
		// 消费者操作
		System.out.println("-----收到消息，开始操作----");
		System.out.println("Order ID：" + order.getId());

		Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
		// ACK 手动签收，需要手工确认签收 (消费者收到消息后主动响应Mq,告诉MQ已经处理完了,让MQ确认一下)
		channel.basicAck(deliveryTag, false);//// false 不支持批量签收
	}
}
