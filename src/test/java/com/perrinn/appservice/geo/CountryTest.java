package com.perrinn.appservice.geo;

import java.util.Random;
import org.junit.Test;
import org.junit.Assert;

public class CountryTest {
	@Test
	public void testId() {
		Country c = new Country();
		Random r = new Random();
		int p = 0;
		while (p < 1000) {
			long l = r.nextLong();
			c.setId(l);
			Assert.assertEquals(l, c.getId());
			p++;
		}
	}

	@Test
	public void testCode() {
		Country c = new Country();
		c.setCountryCode("XXX");
		Assert.assertEquals("XXX", c.getCountryCode());
	}

	@Test
	public void testName() {
		Country c = new Country();
		c.setCountryName("Nowhere");
		Assert.assertEquals("Nowhere", c.getCountryName());
	}

	@Test
	public void testHasDiv() {
		Country c = new Country();
		c.setHasDivision(true);
		Assert.assertEquals(true, c.getHasDivision());
		c.setHasDivision(false);
		Assert.assertEquals(false, c.getHasDivision());
	}

	@Test
	public void testDivName() {
		Country c = new Country();
		c.setDivisionName("Division");
		Assert.assertEquals("Division", c.getDivisionName());
	}
}
