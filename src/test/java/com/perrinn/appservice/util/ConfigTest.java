package com.perrinn.appservice.util;

import java.util.Random;
import org.junit.Test;
import org.junit.Assert;

public class ConfigTest {
	@Test
	public void testServer() {
		Config c = new Config();
		Random r = new Random();
		int p = 0;
		while (p < 10) {
			long l = r.nextLong();
			c.setDatabaseServer(String.valueOf(l));
			c.save();
			c.read();
			Assert.assertEquals(String.valueOf(l), c.getDatabaseServer());
			p++;
		}
		c.setDatabaseServer("localhost");
		c.save();
	}
}
