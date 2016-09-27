/*************************************************************/
/* Copyright (C) 2016, PERRINN Limited.  All Rights Reserved */
/*                                                           */
/* This software is distributed under the Apache 2.0 license */
/* For usage rights, please contact contact@perrinn.com      */
/*                                                           */
/*************************************************************/
package com.perrinn.appservice.beans;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class Keys {
	private String keyData;
	private SecureRandom r;
	
	public Keys() {
		try {
			this.r = SecureRandom.getInstance("SHA1PRNG");
			this.keyData = String.valueOf(this.r.nextLong());
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
		}
	}
	
	public String getKeyData() {
		this.keyData = String.valueOf(this.r.nextLong());
		return this.makeHash(this.keyData);
	}
	
	private String makeHash(String in) {
		String hash = null;
		try {
			MessageDigest m = MessageDigest.getInstance("SHA-1");
			m.reset();
			m.update(in.getBytes());
			byte[] digest = m.digest();
			BigInteger bi = new BigInteger(1, digest);
			hash = bi.toString(16);
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
		}
		finally {
			while(hash.length() < 32) {
				hash = "0" + hash;
			}
		}
		
		return hash;
	}
}
