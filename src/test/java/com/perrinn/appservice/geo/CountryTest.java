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
		long l = r.nextLong();
		c.setId(l);
		Assert.assertEquals(l, c.getId());
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
	public void testRegion() {
		Country c = new Country("XXX");
		Assert.assertEquals("XXX", c.getCountryCode());
		c.setHasRegion(true);
		Assert.assertEquals(true, c.getHasRegion());
		c.setHasRegion(false);
		Assert.assertEquals(false, c.getHasRegion());
	}

	@Test
	public void testRegionName() {
		Country c = new Country("XXX");
		Assert.assertEquals("XXX", c.getCountryCode());
		c.setRegionName("Sand Island");
		Assert.assertEquals("Sand Island", c.getRegionName());
	}
}