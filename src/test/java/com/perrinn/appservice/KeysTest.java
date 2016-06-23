package com.perrinn.appservice;

import static org.junit.Assert.*;

import org.junit.Test;

public class KeysTest {

	@Test
	public void testKeys() {
		Keys k = new Keys(System.currentTimeMillis());
		String s1 = k.getKeyData();
		String s2 = k.getKeyData();
		
		assertNotEquals(s1, s2);
	}

}