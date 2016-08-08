/*************************************************************/
/* Copyright (C) 2016, PERRINN Limited.  All Rights Reserved */
/*                                                           */
/* This software is distributed under the Apache 2.0 license */
/* For usage rights, please contact contact@perrinn.com      */
/*                                                           */
/*************************************************************/
/* This module developed by Christopher Moran                */
/*************************************************************/

package com.perrinn.appservice.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Config {

	private String dbSource;
	private String dbName;
	private String dbUser;
	private String dbPassword;
	private String s3Bucket;

	public String getDatabaseString() {
		return "jdbc:mysql://" + this.dbSource + "/" + this.dbName;
	}

	public String getDatabaseServer() {
		return this.dbSource;
	}

	public String getDatabaseName() {
		return this.dbName;
	}

	public String getDatabaseUser() {
		return this.dbUser;
	}

	public String getDatabasePassword() {
		return this.dbPassword;
	}

	public void setDatabaseServer(String val) {
		this.dbSource = val;
	}

	public void setDatabaseName(String val) {
		this.dbName = val;
	}

	public void setDatabaseUser(String val) {
		this.dbUser = val;
	}

	public void setDatabasePassword(String val) {
		this.dbPassword = val;
	}

	private void initLocals() {
		this.dbSource = "localhost";
		this.dbName = "perrapp";
		this.dbUser = "user";
		this.dbPassword = "password";
		this.s3Bucket = "bucket-name";
	}

	public Config() {
		this.initLocals();
		this.read();
	}

	public void read() {
		InputStream in = null;
		Properties props = new Properties();

		try {
			in = new FileInputStream("config.properties");

			// Load properties
			props.load(in);
			this.dbSource = props.getProperty("data_source");
			this.dbName = props.getProperty("database");
			this.dbUser = props.getProperty("database_user");
			this.dbPassword = props.getProperty("database_password");
			this.s3Bucket = props.getProperty("s3_bucket");
		}
		catch(FileNotFoundException ex) {
			System.err.println("No config found.  Applying defaults");
			this.save();
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
		}
		finally {
			try {
				if(in != null) {
					in.close();
				}
			}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}
		}
	}

	public void save() {
		OutputStream out = null;
		Properties props = new Properties();

		try {
			out = new FileOutputStream("config.properties");

			// Set the props values
			props.setProperty("data_source", this.dbSource);
			props.setProperty("database", this.dbName);
			props.setProperty("database_user", this.dbUser);
			props.setProperty("database_password", this.dbPassword);
			props.setProperty("s3_bucket", this.s3Bucket);

			// and save them
			props.store(out, null);
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
		}
		finally {
			if(out != null) {
				try {
					out.close();
				}
				catch(Exception ex) {
					System.err.println(ex.toString());
				}
			}
		}
	}
}