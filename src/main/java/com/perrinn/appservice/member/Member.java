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

	public long getProfileRegion() {
		return this.profileRegion;
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
		this.user_name = value;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public void setDateOfBirth(Date value) {
		this.dateOfBirth = value;
	}

	public void setPwChangeDate(Date value) {
		this.pwChangeDate = value;
	}

	public void setCreateDate(Date value) {
		this.create_date = value;
	}

	public void setProfileId(long value) {
		this.profileId = value;
	}

	public void setProfileCountry(long value) {
		this.profileCountry = value;
	}

	public void setProfileRegion(long value) {
		this.profileRegion = value;
	}

	public void setProfileCity(long value) {
		this.profileCity = value;
	}

	public void setProfileDescription(String value) {
		this.profileDescription = value;
	}

	public void setProfilePhoto(String value) {
		this.profilePhoto = value;
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

		Config conf = new Config();
		if(conf.getDatabaseName() != null) {
			this.conn = null;
			this.dbUrl = conf.getDatabaseString();
			this.dbUser = conf.getDatabaseUser();
			this.dbPass = conf.getDatabasePassword();
			this.firebasePath = conf.getFirebasePath();
			this.firebaseUrl = conf.getFirebaseUrl();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				this.conn = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPass);
			}
			catch(Exception ex) {
//				System.err.println(ex.toString());
			}
		}
	}

	private boolean FindByName() {
		boolean fRet = false;
		Statement stmt = null;
		String sql = null;
		ResultSet rs = null;

		if(this.conn != null) {
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
				rs.close();
				stmt.close();
			}
			catch(Exception ex) {
//				System.err.println(ex.toString());
				fRet = true;
			}
		}
		else {
			System.err.println("Member.FindByName(): No database connection.  Quitting!");
			fRet = true;
		}
		return fRet;
	}

	public Member() {
		this.InitLocals();

	}

	public Member(String memberName) {
		this.InitLocals();
		this.user_name = memberName;
		this.FindByName();
	}

	public boolean save() {
		boolean fRet = false;

		Statement stmt = null;
		String sql = null;

		if(this.conn != null) {
			try {
				stmt = this.conn.createStatement();
				sql = "UPDATE MEMBER SET user_name=\'" + this.user_name + "\',password=\'" + this.password + "\' where id=" + this.id;
				stmt.executeUpdate(sql);
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

		if(this.conn != null) {
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