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
		PreparedStatement ps = null;

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

// Bulk load of data
			this.conn.setAutoCommit(false);
			sql = "INSERT INTO country(country_name, country_code, has_division, division_name) VALUES(?,?,?,?)";
			ps = this.conn.prepareStatement(sql);

			ps.setString(1, "Afghanistan");
			ps.setString(2, "AFG");
			ps.setInt(3, 1);
			ps.setString(4, "Province");
			ps.addBatch();

			ps.setString(1, "Aland Islands");
			ps.setString(2, "ALA");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Albania");
			ps.setString(2, "ALB");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Algeria");
			ps.setString(2, "DZA");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "American Samoa");
			ps.setString(2, "ASM");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Andorra");
			ps.setString(2, "AND");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Angola");
			ps.setString(2, "AGO");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Anguilla");
			ps.setString(2, "AIA");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Antarctica");
			ps.setString(2, "ATA");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Antigua and Barbuda");
			ps.setString(2, "ATG");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Argentina");
			ps.setString(2, "ARG");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Armenia");
			ps.setString(2, "ARM");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Aruba");
			ps.setString(2, "ABW");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Australia");
			ps.setString(2, "AUS");
			ps.setInt(3, 1);
			ps.setString(4, "State");
			ps.addBatch();

			ps.setString(1, "Austria");
			ps.setString(2, "AUT");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Azerbaijan");
			ps.setString(2, "AZE");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Bahamas");
			ps.setString(2, "BHS");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Bahrain");
			ps.setString(2, "BHR");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Bangladesh");
			ps.setString(2, "BGD");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Barbados");
			ps.setString(2, "BRB");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Belarus");
			ps.setString(2, "BLR");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.setString(1, "Belgium");
			ps.setString(2, "BEL");
			ps.setInt(3, 0);
			ps.setString(4, null);
			ps.addBatch();

			ps.executeBatch();

			this.conn.commit();

			ret = false;
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
			try {
				this.conn.rollback();
			}
			catch(Exception ex1) {
				System.err.println(ex1.getMessage());
			}
			ret = true;
		}
		finally {
			try {
				this.conn.setAutoCommit(true);
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