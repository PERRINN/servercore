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

		//SELECT * FROM MEMBER WHERE USER_NAME=$this.user_name;
		return fRet;
	}

	public Member() {
		this.InitLocals();

	}

	public Member(String memberName) {
		this.InitLocals();
		this.user_name = memberName;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long value) {
		this.id = value;
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
