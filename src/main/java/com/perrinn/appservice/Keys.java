package com.perrinn.appservice;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

public class Keys {
	private String keyData;
	private Random r;
	
	public Keys(long seed) {
		this.r = new Random();
		this.r.setSeed(seed);
		this.keyData = String.valueOf(this.r.nextLong());
	}
	
	public String getKeyData() {
		this.keyData = String.valueOf(this.r.nextLong());
		return this.makeHash(this.keyData);
	}
	
	private String makeHash(String in) {
		String hash = null;
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
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
