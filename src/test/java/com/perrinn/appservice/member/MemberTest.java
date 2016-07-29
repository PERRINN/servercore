package com.perrinn.appservice.member;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import java.util.Calendar;

public class MemberTest {
	@Test
	public void testId() {
		Member m = new Member();
		Random r = new Random();
		long l = r.nextLong();
		m.setId(l);
		Assert.assertEquals(l, m.getId());
	}

}