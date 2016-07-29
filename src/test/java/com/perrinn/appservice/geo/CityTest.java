package com.perrinn.appservice.geo;

import java.util.Random;
import org.junit.Test;
import org.junit.Assert;

public class CityTest {
	@Test
	public void testId() {
		City c = new City();
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
	public void testCountryId() {
		City c = new City();
		Random r = new Random();
		int p = 0;
		while (p < 1000) {
			long l = r.nextLong();
			c.setCountryId(l);
			Assert.assertEquals(l, c.getCountryId());
			p++;
		}
	}

	@Test
	public void testRegionId() {
		City c = new City();
		Random r = new Random();
		int p = 0;
		while (p < 1000) {
			long l = r.nextLong();
			c.setRegionId(l);
			Assert.assertEquals(l, c.getRegionId());
			p++;
		}
	}

	@Test
	public void testCityName() {
		City c = new City();
		c.setCityName("Sydney");
		Assert.assertEquals("Sydney", c.getCityName());
	}
}
