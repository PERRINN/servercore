package com.perrinn.appservice.member;

import java.util.Random;

import com.perrinn.appservice.beans.Member;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;
import java.sql.*;
import com.perrinn.appservice.util.Config;

public class MemberTest {

	@Test
	public void aaInit() {
		Connection conn = null;
		Statement stmt = null;
		String sql;
		try {
			Config conf = new Config();
			Class.forName(conf.getDatabaseDriver());
			conn = DriverManager.getConnection(conf.getDatabaseString(), conf.getDatabaseUser(), conf.getDatabasePassword());
			stmt = conn.createStatement();
			sql = "CREATE TABLE member ("
				+ "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "user_name VARCHAR(255) NOT NULL,"
				+ "password VARCHAR(255),"
				+ "create_date TIMESTAMP,"
				+ "pw_change DATETIME)";
			stmt.execute(sql);
			stmt.close();
			stmt = conn.createStatement();
			sql = "CREATE TABLE profile("
				+ "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "user INTEGER NOT NULL,"
				+ "country INTEGER,"
				+ "region INTEGER,"
				+ "city INTEGER,"
				+ "dob DATE,"
				+ "description BLOB,"
				+ "photo VARCHAR(255))";
			stmt.execute(sql);
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			try {
				stmt.close();
				conn.close();
			}
			catch(Exception ex1) {
				System.err.println(ex1.getMessage());
			}
		}
	}

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

	@Ignore
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

	@Test
	public void testUserAdd() {
		Member m = new Member();
		Assert.assertEquals(false, m.signUp("TestUser", "TestPassword"));
		Assert.assertNotEquals(0, m.getId());
	}

	@Ignore
	public void testLogin() {
		Member m = new Member();
		Assert.assertEquals(false, m.logIn("TestUser", "TestPassword"));
	}
}
