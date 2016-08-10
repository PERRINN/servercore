package com.perrinn.appservice.member;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import java.util.Date;

public class MemberTest {
	@Test
	public void testId() {
		Member m = new Member();
		Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			long l = r.nextLong();
			m.setId(l);
			Assert.assertEquals(l, m.getId());
		}
	}

	@Test
	public void testUserName() {
		Member m = new Member();
		Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			long l = r.nextLong();
			m.setUserName(String.valueOf(l));
			Assert.assertEquals(String.valueOf(l), m.getUserName());
		}
	}

	@Test
	public void testPassword() {
		Member m = new Member();
		Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			long l = r.nextLong();
			m.setPassword(String.valueOf(l));
			Assert.assertEquals(String.valueOf(l), m.getPassword());
		}
	}

	@Test
	public void testCreateDate() {
		Member m = new Member();
		for(int i = 0; i < 1000; i++) {
			Date d = new Date();
			m.setCreateDate(d);
			Assert.assertEquals(d, m.getCreateDate());
		}
	}

	@Test
	public void testPwChangeDate() {
		Member m = new Member();
		for(int i = 0; i < 1000; i++) {
			Date d = new Date();
			m.setPwChangeDate(d);
			Assert.assertEquals(d, m.getPwChangeDate());
		}
	}

	@Test
	public void testProfileId() {
		Member m = new Member();
		Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			long l = r.nextLong();
			m.setProfileId(l);
			Assert.assertEquals(l, m.getProfileId());
		}
	}

	@Test
	public void testProfileCountry() {
		Member m = new Member();
		Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			long l = r.nextLong();
			m.setProfileCountry(l);
			Assert.assertEquals(l, m.getProfileCountry());
		}
	}

	@Test
	public void testProfileRegion() {
		Member m = new Member();
		Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			long l = r.nextLong();
			m.setProfileRegion(l);
			Assert.assertEquals(l, m.getProfileRegion());
		}
	}

	@Test
	public void testProfileCity() {
		Member m = new Member();
		Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			long l = r.nextLong();
			m.setProfileCity(l);
			Assert.assertEquals(l, m.getProfileCity());
		}
	}

	@Test
	public void testProfileDescription() {
		Member m = new Member();
		Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			long l = r.nextLong();
			m.setProfileDescription(String.valueOf(l));
			Assert.assertEquals(String.valueOf(l), m.getProfileDescription());
		}
	}

	@Test
	public void testProfilePhoto() {
		Member m = new Member();
		Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			long l = r.nextLong();
			m.setProfilePhoto(String.valueOf(l));
			Assert.assertEquals(String.valueOf(l), m.getProfilePhoto());
		}
	}
}