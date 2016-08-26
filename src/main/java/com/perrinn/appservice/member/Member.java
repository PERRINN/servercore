/*************************************************************/
/* Copyright (C) 2016, PERRINN Limited.  All Rights Reserved */
/*                                                           */
/* This software is distributed under the Apache 2.0 license */
/* For usage rights, please contact contact@perrinn.com      */
/*                                                           */
/*************************************************************/
/* This module developed by Christopher Moran                */
/*************************************************************/

package com.perrinn.appservice.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;
import java.sql.*;
import com.perrinn.appservice.util.Config;
import java.io.FileInputStream;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

@Entity
@Table(name="member")
public class Member {
	private boolean needSave;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String user_name;
	private String password; 
	private Date create_date;
	private Date pwChangeDate;

	/*
	 * Profile data
	*/
	private long profileId;
	private long profileUser;
	private long profileCountry;
	private long profileRegion;
	private long profileCity;
	private Date dateOfBirth;
	private String profileDescription;
	private String profilePhoto;

	private Connection conn;
	private String dbUrl;
	private String dbUser;
	private String dbPass;
	private String firebasePath;
	private String firebaseUrl;
	private String customToken;

	public long getId() {
		return this.id;
	}

	public String getUserName() {
		return this.user_name;
	}

	public String getPassword() {
		return this.password;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public Date getPwChangeDate() {
		return this.pwChangeDate;
	}

	public Date getCreateDate() {
		return this.create_date;
	}

	public long getProfileId() {
		return this.profileId;
	}

	public long getProfileCountry() {
		return this.profileCountry;
	}

	public String getProfileCountryName() {
		String country = null;
		Statement stmt = null;
		String sql = null;
		ResultSet rs = null;

		try {
			if(this.conn != null) {
				stmt = this.conn.createStatement();
				sql = "SELECT country_name from country WHERE id=" + this.profileCountry;
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					country = rs.getString("country_name");
				}
			}
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
			country = null;
		}
		finally {
			try {
				if(rs != null)
					rs.close();
			}
			catch(Exception ex) {
				System.err.println();
			}
		}

		return country;
	}

	public long getProfileRegion() {
		return this.profileRegion;
	}

	public String getProfileRegionName() {
		String region = null;
		Statement stmt = null;
		String sql = null;
		ResultSet rs = null;

		try {
			if(this.conn != null) {
				stmt = this.conn.createStatement();
				sql = "SELECT region_name from region WHERE id=" + this.profileRegion;
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					region = rs.getString("region_name");
				}
			}
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
			region = null;
		}
		finally {
			try {
				if(rs != null)
					rs.close();
			}
			catch(Exception ex) {
				System.err.println();
			}
		}

		return region;
	}

	public String getProfileCityName() {
		String city = null;
		Statement stmt = null;
		String sql = null;
		ResultSet rs = null;

		try {
			if(this.conn != null) {
				stmt = this.conn.createStatement();
				sql = "SELECT city_name from city WHERE id=" + this.profileCity;
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					city = rs.getString("city_name");
				}
			}
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
			city = null;
		}
		finally {
			try {
				if(rs != null)
					rs.close();
			}
			catch(Exception ex) {
				System.err.println();
			}
		}

		return city;
	}

	public long getProfileCity() {
		return this.profileCity;
	}

	public String getProfileDescription() {
		return this.profileDescription;
	}

	public String getProfilePhoto() {
		return this.profilePhoto;
	}

	public void setId(long value) {
		if(this.id != value) {
			this.id = value;
			this.needSave = true;
		}
	}

	public void setUserName(String value) {
		if(this.user_name != value) {
			this.user_name = value;
			this.needSave = true;
		}
	}

	public void setPassword(String value) {
		if(this.password != value) {
			this.password = value;
			this.needSave = true;
		}
	}

	public void setDateOfBirth(Date value) {
		if(this.dateOfBirth != value) {
			this.dateOfBirth = value;
			this.needSave = true;
		}
	}

	public void setPwChangeDate(Date value) {
		if(this.pwChangeDate != value) {
			this.pwChangeDate = value;
			this.needSave = true;
		}
	}

	public void setCreateDate(Date value) {
		if(this.create_date != value) {
			this.create_date = value;
			this.needSave = true;
		}
	}

	public void setProfileId(long value) {
		if(this.profileId != value) {
			this.profileId = value;
			this.needSave = true;
		}
	}

	public void setProfileCountry(long value) {
		if(this.profileCountry != value) {
			this.profileCountry = value;
			this.needSave = true;
		}
	}

	public void setProfileRegion(long value) {
		if(this.profileRegion != value) {
			this.profileRegion = value;
			this.needSave = true;
		}
	}

	public void setProfileCity(long value) {
		if(this.profileCity != value) {
			this.profileCity = value;
			this.needSave = true;
		}
	}

	public void setProfileDescription(String value) {
		if(this.profileDescription != value) {
			this.profileDescription = value;
			this.needSave = true;
		}
	}

	public void setProfilePhoto(String value) {
		if(this.profilePhoto != value) {
			this.profilePhoto = value;
			this.needSave = true;
		}
	}

	private void InitLocals() {
		this.needSave = false;
		this.id = 0;
		this.user_name = null;
		this.password = null;
		this.dateOfBirth = new Date();
		this.pwChangeDate = new Date();
		this.create_date = new Date();
		this.profileId = 0;
		this.profileUser = 0;
		this.profileCountry = 0;
		this.profileRegion = 0;
		this.profileCity = 0;
		this.profileDescription = null;
		this.profilePhoto = null;
		this.customToken = null;
		this.conn = null;
	}

	private boolean FindByName() {
		boolean ret = false;
		Statement stmt = null;
		String sql = null;
		ResultSet rs = null;

		if(this.open() == false) {
			//SELECT * FROM MEMBER WHERE USER_NAME=$this.user_name;
			try {
				stmt = this.conn.createStatement();
				sql = "SELECT m.*, p.* FROM member AS m, profile AS p WHERE m.user_name=\'" + this.user_name + "\' and p.user = m.id";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					this.id = rs.getInt("m.id");
					this.user_name = rs.getString("m.user_name");
					this.password = rs.getString("m.password");

					this.create_date = rs.getDate("m.create_date");
					this.pwChangeDate = rs.getDate("m.pw_change");

					this.profileId = rs.getInt("p.id");
					this.profileUser = rs.getInt("p.user");
					this.profileCountry = rs.getInt("p.country");
					this.profileRegion = rs.getInt("p.region");
					this.profileCity = rs.getInt("p.city");
					this.profileDescription = rs.getString("p.description");
					this.profilePhoto = rs.getString("p.photo");
				}
			}
			catch(Exception ex) {
//				System.err.println(ex.toString());
				ret = true;
			}
			finally {
				try {
					rs.close();
					stmt.close();
					this.close();
				}
				catch(Exception ex) {
					System.err.println(ex.getMessage());
					ret = true;
				}
			}
		}
		else {
			System.err.println("Member.FindByName(): No database connection.  Quitting!");
			ret = true;
		}
		return ret;
	}

	public Member() {
		this.InitLocals();

	}

	public Member(String memberName) {
		this.InitLocals();
		this.user_name = memberName;
		this.FindByName();
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

	public boolean save() {
		boolean fRet = false;

		PreparedStatement stmt = null;
		String sql = null;

		if(this.open() == false) {
			try {
				sql = "UPDATE MEMBER SET user_name=?,password=? where id=";
				stmt = this.conn.prepareStatement(sql);
				stmt.setString(1, this.user_name);
				stmt.setString(2, this.password);
				stmt.setLong(3, this.id);
				stmt.executeUpdate();
				stmt.close();
				sql = "UPDATE PROFILE SET country=?,region=?,city=,description=?,photo=?";
				stmt = this.conn.prepareStatement(sql);
				stmt.setLong(1, this.profileCountry);
				stmt.setLong(2, this.profileRegion);
				stmt.setLong(3, this.profileCity);
				stmt.setString(4, this.profileDescription);
				stmt.setString(5, this.profilePhoto);
				stmt.executeUpdate();
				stmt.close();
			}
			catch(Exception ex) {
				System.err.println(ex.toString());
				fRet = true;
			}
		}
		else {
			System.err.println("Member.save(): No database connection.  Quitting!");
			fRet = true;
		}
		return fRet;
	}

	public void close() {
		if(this.conn != null) {
			try {
				this.conn.close();
			}
			catch(Exception ex) {
				System.err.println(ex.toString());
			}
		}
	}

	public boolean logIn(String userName, String password) {
		boolean fRet = false;
		String uuid = null;
/*
		Statement stmt = null;
		String sql = null;

		if(this.conn != null) {
			try {
				stmt = this.conn.createStatement();
				// We don't actually need to know the result, just make sure we can get one.
				// BUGBUG - We do need the ID so we can pass it back to the client.
				sql = "SELECT * FROM member WHERE (user_name=\'" + userName + "\' AND password=\'" + password + "\'";
				if(stmt.execute(sql) == true)
					fRet = false;
				else
					fRet = true;

			}
			catch(Exception ex) {
				System.err.println(ex.toString());
				fRet = true;
			}
			finally {
				try {
					if(stmt != null)
						stmt.close();
				}
				catch(Exception ex) {
					System.err.println(ex.toString());
				}
			}
		}
		else {
			System.err.println("Member.logIn(): No database connection.  Quitting!");
			fRet = true;
		}
*/
		// Change to Firebase Authentication
		try {
			FirebaseOptions options = new FirebaseOptions.Builder()
				.setServiceAccount(new FileInputStream(this.firebasePath))
				.setDatabaseUrl(this.firebaseUrl)
				.build();
			FirebaseApp.initializeApp(options);
			uuid = UUID.randomUUID().toString();
			System.out.println("DEBUG: uuid: " + uuid);
			this.customToken = FirebaseAuth.getInstance().createCustomToken(uuid);
			System.out.println("Custom Token: " + this.customToken);
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
			fRet = true;
		}

		return fRet;
	}

	public boolean signUp(String userName, String password) {
		boolean fRet = false;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;

		if(this.open() == false) {
			try {
				stmt = this.conn.createStatement();
				//BUGBUG: Add the create_date value at this point, because it won't change
				sql = "INSERT INTO member (user_name, password) VALUES(\'" + userName + "\',\'" + password + "\')";
				if(stmt.execute(sql) == true) {	
					sql = "SELECT id FROM member WHERE user_name = \'" + userName + "\' AND password = \'" + password + "\'"; 
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						this.id = rs.getInt("id");
						this.user_name = userName;
					}

					fRet = false;
				}
			}
			catch(Exception ex) {
					System.err.println(ex.toString());
					fRet = true;
			}
			finally {
				try {
					if(rs != null)
						rs.close();
					if(stmt != null)
						stmt.close();
					this.close();
				}
				catch(Exception ex) {
					System.err.println(ex.toString());
				}
			}
		}
		else {
			System.err.println("Member.signUp(): No database connection.  Quitting!");
			fRet = true;
		}
		return fRet;
	}
}
