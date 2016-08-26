package com.perrinn.appservice.geo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.*;
import com.perrinn.appservice.util.Config;

@Entity
@Table(name="country")
public class Country {
	private Connection conn;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String countryCode;
	private String countryName;
	private boolean hasDivision;
	private String divisionName;
	private boolean needSave;

	private void initLocals() {
		this.conn = null;
		this.id = 0;
		this.countryCode = null;
		this.countryName = null;
		this.hasDivision = false;
		this.divisionName = null;
		this.needSave = false;
	}

	// Getters
	public long getId() {
		return this.id;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public boolean getHasDivision() {
		return this.hasDivision;
	}

	public String getDivisionName() {
		return this.divisionName;
	}

	public void setHasDivision(boolean value) {
		this.hasDivision = value;
	}

	// Setters
	public void setId(long value) {
		this.id = value;
		this.needSave = true;
	}

	public void setCountryCode(String value) {
		this.countryCode = value;
		this.needSave = true;
	}

	public void setCountryName(String value) {
		this.countryName = value;
		this.needSave = true;
	}

	@Override
	public String toString() {
		return "id=" + String.valueOf(this.id) + ", countryCode=" + this.countryCode + ", countryName=" + this.countryName + ", hasDivision=" + String.valueOf(this.hasDivision) + ", divisionName" + this.divisionName;
	}

	public void setDivisionName(String value) {
		this.divisionName = value;
		this.needSave = true;
	}

	public Country() {
		this.initLocals();
	}

	public Country(String code) {
		this.initLocals();
		this.countryCode = code;
		this.loadByCode();
	}

	public Country(long id) {
		this.initLocals();
		this.id = id;
		this.loadById();
	}

	private boolean open() {
		boolean ret = false;

		Config conf = new Config();
		try {
			Class.forName(conf.getDatabaseDriver());
			this.conn = DriverManager.getConnection(conf.getDatabaseString(), conf.getDatabaseUser(), conf.getDatabasePassword());
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
			ret = true;
		}

		return ret;
	}

	public boolean close() {
    	boolean ret = false;
    	
    	try {
    		if(this.conn.isClosed() == false) {
    			this.conn.close();
    		}
    	}
    	catch(Exception ex) {
    		System.err.println(ex.toString());
    	}
    	
    	return ret;
	}

	long loadById() {
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet rs = null;

		if(this.open() == false) {
			// Connection is initialised.
			try {
				sql = "select * from country where id= ?";
				stmt = this.conn.prepareStatement(sql);
				stmt.setLong(1, this.id);
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					this.countryCode = rs.getString("country_code");
					this.countryName = rs.getString("country_name");
					this.hasDivision = rs.getBoolean("has_division");
					this.divisionName = rs.getString("division_name");
				}
			}
			catch(Exception ex) {
				System.err.println(ex.toString());
				this.id = 0; // The entry is not available.
			} 
			finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(stmt != null) {
						stmt.close();
					}
					this.close();
				}
				catch(Exception ex) {
					System.err.println(ex.toString());
				}
			}
		}
		else {
			this.id = 0;	// Database not open.  Didn't get anything
		}

		return this.id;
	}

	long loadByCode() {
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet rs = null;

		if(this.open() == false) {
			// Connection is initialised.
			try {
				sql = "select * from country where country_name= ?";
				stmt = this.conn.prepareStatement(sql);
				stmt.setString(1, this.countryCode);
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					this.countryCode = rs.getString("country_code");
					this.countryName = rs.getString("country_name");
					this.hasDivision = rs.getBoolean("has_division");
					this.divisionName = rs.getString("division_name");
				}
			}
			catch(Exception ex) {
				System.err.println(ex.toString());
				this.id = 0; // The entry is not available.
			} 
			finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(stmt != null) {
						stmt.close();
					}
					this.close();
				}
				catch(Exception ex) {
					System.err.println(ex.toString());
				}
			}
		}
		else {
			this.id = 0;	// Database not open.  Didn't get anything
		}

		return this.id;
	}

	public boolean save() {
		boolean ret = false;
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet rs = null;

		if(this.open() == false) {
			// Connection is initialised.
			try {
				sql = "update country set country_code=?, country_name=?, has_division=?, division_name=? where id= ?";
				stmt = this.conn.prepareStatement(sql);
				stmt.setString(1, this.countryCode);
				stmt.setString(2, this.countryName);
				stmt.setBoolean(3, this.hasDivision);
				stmt.setString(4, this.divisionName);
				stmt.setLong(5, this.id);
			}
			catch(Exception ex) {
				System.err.println(ex.toString());
				this.id = 0; // The entry is not available.
			} 
			finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(stmt != null) {
						stmt.close();
					}
					this.close();
				}
				catch(Exception ex) {
					System.err.println(ex.toString());
					ret = true;
				}
			}
		}
		else {
			ret = true;	// Database not open.  Didn't get anything
		}

		return ret;
	}

	public boolean add() {
		boolean ret = false;
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet rs = null;

		if(this.open() == false) {
			// Connection is initialised.
			try {
				sql = "insert into country (country_code,country_name,has_division,division_name) values(?,?,?,?)";
				stmt = this.conn.prepareStatement(sql);
				stmt.setString(1, this.countryCode);
				stmt.setString(2, this.countryName);
				stmt.setBoolean(3, this.hasDivision);
				stmt.setString(4, this.divisionName);
			}
			catch(Exception ex) {
				System.err.println(ex.toString());
				this.id = 0; // The entry is not available.
			} 
			finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(stmt != null) {
						stmt.close();
					}
					this.close();
				}
				catch(Exception ex) {
					System.err.println(ex.toString());
					ret = true;
				}
			}
		}
		else {
			ret = true;	// Database not open.  Didn't get anything
		}

		return ret;
	}
}
