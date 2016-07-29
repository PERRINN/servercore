package com.perrinn.appservice.geo;

import java.util.Random;
import org.junit.Test;
import org.junit.Assert;

public class RegionTest {
	@Test
	public void testId() {
		Region r = new Region();
		Random n = new Random();
		int p = 0;
		while (p < 1000) {
			long l = n.nextLong();
			r.setId(l);
			Assert.assertEquals(l, r.getId());
			p++;
		}
	}

	@Test
	public void testName() {
		Region r = new Region();
		r.setRegionName("Nowhere");
		Assert.assertEquals("Nowhere", r.getRegionName());
	}

	@Test
	public void testCountryId() {
		Region r = new Region();
		Random n = new Random();
		int p = 0;
		while (p < 1000) {
			long l = n.nextLong();
			r.setCountryId(l);
			Assert.assertEquals(l, r.getCountryId());
			p++;
		}
	}
}
