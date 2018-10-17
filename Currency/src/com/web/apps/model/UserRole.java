package com.web.apps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLES")
public class UserRole {

	@Id
	@SequenceGenerator(name="ROLE_SEQ",sequenceName="ROLE_SEQ")
	@GeneratedValue(generator="ROLE_SEQ")
	@Column(name="ID")
	private int ID;
	
	@Column(name="USERNAME")
	private String USERNAME;
	
	@Column(name="ROLE")
	private String ROLE;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getROLE() {
		return ROLE;
	}

	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}

	@Override
	public String toString() {
		return "UserRole [ID=" + ID + ", USERNAME=" + USERNAME + ", ROLE=" + ROLE + "]";
	}
	
}
