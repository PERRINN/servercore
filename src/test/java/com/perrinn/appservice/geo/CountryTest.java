package com.perrinn.appservice.geo;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

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
		Random r = new Random();
		int p = 0;
		while (p < 1000) {
			long l = r.nextLong();
			c.setCountryCode(String.valueOf(l));
			Assert.assertEquals(String.valueOf(l), c.getCountryCode());
			p++;
		}
	}

	@Test
	public void testName() {
		Country c = new Country();
		Random r = new Random();
		int p = 0;
		while (p < 1000) {
			long l = r.nextLong();
			c.setCountryName(String.valueOf(l));
			Assert.assertEquals(String.valueOf(l), c.getCountryName());
			p++;
		}
	}

	@Test
	public void testDivision() {
		Country c = new Country();
		c.setHasDivision(true);
		Assert.assertEquals(true, c.getHasDivision());
		c.setHasDivision(false);
		Assert.assertEquals(false, c.getHasDivision());
	}

	@Test
	public void testDivisionName() {
		Country c = new Country();
		Random r = new Random();
		int p = 0;
		while (p < 1000) {
			long l = r.nextLong();
			c.setDivisionName(String.valueOf(l));
			Assert.assertEquals(String.valueOf(l), c.getDivisionName());
			p++;
		}
	}
}
