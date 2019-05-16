package com.lemon.springboot;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lemon.springboot.entity.Order;
import com.lemon.springboot.producer.OrderSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProductApplicationTests {

	@Test
	public void contextLoads() {
		
	}
	@Autowired
	OrderSender o;
	@Test
	public void testsender1() throws Exception {
		Order order=new Order("201800000001","test order",System.currentTimeMillis()+"$"+UUID.randomUUID().toString());
		o.sendOrder(order);
		
	}

}
