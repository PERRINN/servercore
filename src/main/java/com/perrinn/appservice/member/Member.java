package com.perrinn.appservice.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
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
	private Date create_date;
	private Date dateOfBirth;
	private Date pwChangeDate;

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

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public Date getPwChangeDate() {
		return this.pwChangeDate;
	}

	public Date getCreateDate() {
		return this.create_date;
	}

	public void setId(long value) {
		this.id = value;
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

	private void InitLocals() {
		this.id = 0;
		this.user_name = null;
		this.password = null;
		this.dateOfBirth = new Date();
		this.pwChangeDate = new Date();
		this.create_date = new Date();

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

				this.dateOfBirth = rs.getDate("create_date");
				this.pwChangeDate = rs.getDate("pw_change");
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

	public boolean logIn(String userName, String password) {
		boolean fRet = false;
		Statement stmt = null;
		String sql = null;

		try {
			stmt = this.conn.createStatement();
			// We don't actually need to know the result, just make sure we can get one.
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

		return fRet;
	}
}
