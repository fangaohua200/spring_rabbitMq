package com.lemon.springboot.entity;

import java.io.Serializable;

public class Order implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4321984044119983249L;
	
	
	private String id;
	private String name;
	private String messageId; //message id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Order(String id, String name, String messageId) {
		super();
		this.id = id;
		this.name = name;
		this.messageId = messageId;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}
