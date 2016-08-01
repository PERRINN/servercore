package com.perrinn.appservice.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.sql.*;
import com.perrinn.appservice.util.Config;

@Entity
@Table(name="country")
public class Member {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String user_name;
	private String password; 
	private Calendar dateOfBirth;
	private Calendar pwChangeDate;

	private Connection conn;
	private String dbUrl;
	private String dbUser;
	private String dbPass;

	public long getId() {
		return this.id;
	}

	public String getUserName() {
		return this.user_name;
	}

	public String getPassword() {
		return this.password;
	}

	public Calendar getDateOfBirth() {
		return this.dateOfBirth;
	}

	public Calendar getPwChangeDate() {
		return this.pwChangeDate;
	}

	public void setId(long value) {
		this.id = value;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public void setDateOfBirth(Calendar value) {
		this.dateOfBirth = value;
	}

	public void setPwChangeDate(Calendar value) {
		this.pwChangeDate = value;
	}

	private void InitLocals() {
		this.id = 0;
		this.user_name = null;
		this.password = null;
		this.dateOfBirth = Calendar.getInstance();
		this.pwChangeDate = Calendar.getInstance();

		Config conf = new Config();
		if(conf.getDatabaseName() != null) {
			this.conn = null;
			this.dbUrl = conf.getDatabaseString();
			this.dbUser = conf.getDatabaseUser();
			this.dbPass = conf.getDatabasePassword();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				this.conn = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPass);
			}
			catch(Exception ex) {
				System.err.println(ex.toString());
			}
		}
	}

	private boolean FindByName() {
		boolean fRet = false;
		Statement stmt = null;
		String sql = null;
		ResultSet rs = null;

		//SELECT * FROM MEMBER WHERE USER_NAME=$this.user_name;
		try {
			stmt = this.conn.createStatement();
			sql = "SELECT * FROM MEMBER WHERE USER_NAME=\'" + this.user_name + "\'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				this.user_name = rs.getString("user_name");
				this.password = rs.getString("password");
/*
				this.dateOfBirth = rs.get
				this.pwChangeDate = rs.get
*/
			}
			rs.close();
			stmt.close();
		}
		catch(Exception ex) {
			System.err.println(ex.toString());
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
}
