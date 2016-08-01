package com.perrinn.appservice.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Config {

	private String dbSource;
	private String dbName;
	private String dbUser;
	private String dbPassword;

	public String getDatabaseString() {
		return "jdbc:mysql://" + this.dbSource + "/" + this.dbName;
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

	public void setDatabaseName(String val) {
		this.dbName = val;
	}

	public void setDatabaseUser(String val) {
		this.dbUser = val;
	}

	public void setDatabasePassword(String val) {
		this.dbPassword = val;
	}

	public Config() {
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