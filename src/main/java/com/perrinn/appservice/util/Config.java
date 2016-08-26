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
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Properties;
import com.google.firebase.FirebaseOptions;

public class Config {

	private String dbSource;
	private String dbName;
	private String dbUser;
	private String dbPassword;
	private String s3Bucket;
	private String firebasePath;
	private String firebaseUrl;
	private String queueName;
	private String dbDriver;

	public String getDatabaseString() {
		if(this.dbDriver.equals("com.mysql.jdbc.Driver"))
			return "jdbc:mysql://" + this.dbSource + "/" + this.dbName;

		if(this.dbDriver.equals("org.h2.Driver"))
			return "jdbc:h2:mem:" + this.dbName + ";DB_CLOSE_DELAY=-1"; 

		if(this.dbDriver.equals("oracle.jdbc.driver.OracleDriver"))
			return "jdbc:oracle:thin:" + this.dbUser + "/" + this.dbName + "@" + this.dbName;
		
		return null;
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

	public String getBucketName() {
		return this.s3Bucket;
	}

	public String getFirebasePath() {
		return this.firebasePath;
	}

	public String getFirebaseUrl() {
		return this.firebaseUrl;
	}

	public String getQueueName() {
		return this.queueName;
	}

	public String getDatabaseDriver() {
		return this.dbDriver;
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

	public void setBucketName(String val) {
		this.s3Bucket = val;
	}

	public void setQueueName(String val) {
		this.queueName = val;
	}

	public void setDatabaseDriver(String val) {
		this.dbDriver = val;
	}

	private void initLocals() {
		this.dbSource = "localhost";
		this.dbName = "perrapp";
		this.dbUser = "user";
		this.dbPassword = "password";
		this.s3Bucket = "bucket-name";
		this.firebasePath = "perrinn-creds.json";
		this.firebaseUrl = "https://perrinn-pilot.firebaseio.com/";
		this.queueName = "messagequeue";
		this.dbDriver = "com.mysql.jdbc.Driver";
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
			this.firebasePath = props.getProperty("firebase_json");
			this.firebaseUrl = props.getProperty("firebase_url");
			this.queueName = props.getProperty("message_queue");
			this.dbDriver = props.getProperty("database_driver");
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
			props.setProperty("database_driver", this.dbDriver);
			props.setProperty("s3_bucket", this.s3Bucket);
			props.setProperty("firebase_json", this.firebasePath);
			props.setProperty("firebase_url", this.firebaseUrl);
			props.setProperty("message_queue", this.queueName);

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