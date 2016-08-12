/*************************************************************/
/* Copyright (C) 2016, PERRINN Limited.  All Rights Reserved */
/*                                                           */
/* This software is distributed under the Apache 2.0 license */
/* For usage rights, please contact contact@perrinn.com      */
/*                                                           */
/*************************************************************/
/* This module developed by Christopher Moran                */
/*************************************************************/

package com.perrinn.appservice.util;

import java.util.List;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class MessageQueue {
	private String qName;
	private String qUrl;
	private AmazonSQSClient sqsClient;
	
	public String getQueueName() {
		return this.qName;
	}
	
	public String getQueueUrl() {
		return this.qUrl;
	}
	
	private void initLocals() {
		Config conf = new Config();
		this.qName = conf.getQueueName();
		this.qUrl = null;
		this.sqsClient = new AmazonSQSClient(new DefaultAWSCredentialsProviderChain());
		// Establish an endpoint in the desired region
	}
	
	public MessageQueue() {
		this.initLocals();
	}
	
	public boolean createQueue() {
		boolean ret = false;
		
		
		try {
			CreateQueueRequest cqr = new CreateQueueRequest().withQueueName(this.qName);
			this.qUrl = sqsClient.createQueue(cqr).getQueueUrl();
			if(this.qUrl == null)
				ret = true;
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
			ret = true;
		}
		
		return ret;
	}
	
	public boolean sendToQueue(String message) {
		boolean ret = false;
		
		try {
			this.sqsClient.sendMessage(new SendMessageRequest()
					.withQueueUrl(this.qUrl)
					.withMessageBody(message));
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
			ret = true;
		}
		
		return ret;
	}

	public List<Message> getMessagesFromQueue() {
		ReceiveMessageRequest rmr = null;
		List<Message> msgs = null;
		
		rmr = new ReceiveMessageRequest(this.qUrl);
		msgs = this.sqsClient.receiveMessage(rmr).getMessages();
		
		return msgs;
	}
	
	public boolean deleteMessageFromQueue(String handle) {
		boolean ret = false;
		
		try {
		this.sqsClient.deleteMessage(new DeleteMessageRequest()
				.withQueueUrl(this.qUrl)
				.withReceiptHandle(handle));
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
			ret = true;
		}
		return ret;
	}
}
