package com.perrinn.appservice;

import static org.junit.Assert.*;

import com.perrinn.appservice.beans.Keys;
import org.junit.Test;

public class KeysTest {

	@Test
	public void testKeys() {
		Keys k = new Keys();
		String s1 = k.getKeyData();
		String s2 = k.getKeyData();
		
		assertNotEquals(s1, s2);
	}

}