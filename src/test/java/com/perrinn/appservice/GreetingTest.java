/**
 * 
 */
package com.perrinn.appservice;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author christophermoran
 *
 */
public class GreetingTest {

	/**
	 * Test method for {@link com.perrinn.appservice.Greeting#Greeting(long, java.lang.String)}.
	 */
	@Ignore
	public void testGreeting() {
		assertFalse(false);
	}

	/**
	 * Test method for {@link com.perrinn.appservice.Greeting#getId()}.
	 */
	@Ignore
	public void testGetId() {
		Greeting g = new Greeting(0, "Hello");
		assertEquals(0, g.getId());
	}

	/**
	 * Test method for {@link com.perrinn.appservice.Greeting#getContent()}.
	 */
	@Ignore
	public void testGetContent() {
		Greeting g = new Greeting(0, "Hello");
		assertEquals("Hello", g.getContent());
	}

}
