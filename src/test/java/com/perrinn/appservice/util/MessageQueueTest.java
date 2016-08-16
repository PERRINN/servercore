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

import java.util.Random;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import com.amazonaws.services.sqs.model.Message;
import org.junit.Assert;


public class MessageQueueTest {
	private static boolean runLiveTest = false;
	@Ignore
	public void testCreateQueue() {
		MessageQueue m = new MessageQueue();
		if(runLiveTest == true) {
			Assert.assertEquals(false, m.createQueue());
			// Assume that we are using the default message queue
			Assert.assertEquals("msgqueue", m.getQueueName());
		}
	}
	
	@Ignore
	public void testUseQueue() {
		if(runLiveTest == true) {
			MessageQueue m = new MessageQueue();
			Assert.assertEquals(false, m.createQueue());
			Random r = new Random();
			for(int i = 0; i < 10; i++) {
				long l = r.nextLong();
				m.sendToQueue(String.valueOf(l));
				List<Message>msgs = m.getMessagesFromQueue();
				for(Message msg : msgs) {
					Assert.assertEquals(msg.getBody(), String.valueOf(l));
					m.deleteMessageFromQueue(msg.getReceiptHandle());
				}
			}
		}
	}
}
