package com.perrinn.appservice.geo;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class CountryTest {
	@Test
	public void testId() {
		Country c = new Country("XXX");
		Assert.assertEquals("XXX", c.getCountryCode());
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
		Country c = new Country("XXX");
		Assert.assertEquals("XXX", c.getCountryCode());
		c.setCountryCode("YYY");
		Assert.assertEquals("YYY", c.getCountryCode());
	}

	@Test
	public void testName() {
		Country c = new Country("XXX");
		Assert.assertEquals("XXX", c.getCountryCode());
		c.setCountryName("SeaLand");
		Assert.assertEquals("SeaLand", c.getCountryName());
	}

	@Test
	public void testDivision() {
		Country c = new Country("XXX");
		Assert.assertEquals("XXX", c.getCountryCode());
		c.setHasDivision(true);
		Assert.assertEquals(true, c.getHasDivision());
		c.setHasDivision(false);
		Assert.assertEquals(false, c.getHasDivision());
	}

	@Test
	public void testDivisionName() {
		Country c = new Country("XXX");
		Assert.assertEquals("XXX", c.getCountryCode());
		c.setDivisionName("Sand Island");
		Assert.assertEquals("Sand Island", c.getDivisionName());
	}
}
