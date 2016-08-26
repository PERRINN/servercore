package com.perrinn.appservice.geo;

import java.sql.*;
import com.perrinn.appservice.util.Config;

public class CountryInit {
	private Connection conn;

	private void initVars() {
		this.conn = null;
	}

	public CountryInit() {
		this.initVars();
	}

	public boolean go() {
		boolean ret = false;
		String sql;
		Statement stmt = null;

		Config conf = new Config();
		try {
			Class.forName(conf.getDatabaseDriver());
			this.conn = DriverManager.getConnection(conf.getDatabaseString(), conf.getDatabaseUser(), conf.getDatabasePassword());
			sql = "CREATE TABLE country ("
				+ " id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ " country_code CHAR(5) NOT NULL,"
				+ " country_name VARCHAR(255) NOT NULL,"
				+ " has_division SMALLINT NOT NULL,"
				+ " division_name VARCHAR(255)"
				+ ")";
			stmt = this.conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			ret = false;
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
			ret = true;
		}
		finally {
			try {
				this.conn.close();
			}
			catch(Exception ex) {
				System.err.println(ex.getMessage());
				ret = true;
			}
		}

		return ret;
	}


}