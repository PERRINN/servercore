package com.perrinn.appservice.geo;

import java.sql.*;
import com.perrinn.appservice.util.Config;

public class CityInit {
	private Connection conn;

	private void initVars() {
		this.conn = null;
	}

	public CityInit() {
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
			sql = "CREATE TABLE city ("
				+ " id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ " country INTEGER	NOT NULL,"
				+ " region INTEGER	NOT NULL,"
				+ " city_name VARCHAR(255)"
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