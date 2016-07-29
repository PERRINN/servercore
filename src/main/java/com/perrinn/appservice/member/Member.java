package com.perrinn.appservice.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

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

	private void InitLocals() {
		this.id = 0;
		this.user_name = null;
		this.password = null;
		this.dateOfBirth = Calendar.getInstance();
		this.pwChangeDate = Calendar.getInstance();
	}

	public Member() {
		this.InitLocals();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long value) {
		this.id = value;
	}
}
