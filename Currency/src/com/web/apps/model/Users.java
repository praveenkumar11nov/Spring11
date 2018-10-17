package com.web.apps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="users.getAlluser",query="select u from Users u")
})

@Table(name="USERS")
public class Users {

	@Id
	@SequenceGenerator(name="USERS_SEQ",sequenceName="USERS_SEQ")
	@GeneratedValue(generator="USERS_SEQ")
	@Column(name="ID")
	private int ID;
	
	@Column(name="USERNAME")
	private String USERNAME;
	
	@Column(name="PASSWORD")
	private String PASSWORD;
	
	@Column(name="ENABLED")
	private String ENABLED;
	
	@Column(name="CREATEDDATE")
	private Date CREATEDDATE;
	
	@Column(name="CREATEDBY")
	private String CREATEDBY;
	
	@Column(name="EMAIL")
	private String EMAIL;

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

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getENABLED() {
		return ENABLED;
	}

	public void setENABLED(String eNABLED) {
		ENABLED = eNABLED;
	}

	public Date getCREATEDDATE() {
		return CREATEDDATE;
	}

	public void setCREATEDDATE(Date cREATEDDATE) {
		CREATEDDATE = cREATEDDATE;
	}

	public String getCREATEDBY() {
		return CREATEDBY;
	}

	public void setCREATEDBY(String cREATEDBY) {
		CREATEDBY = cREATEDBY;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	@Override
	public String toString() {
		return "Users [ID=" + ID + ", USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + ", ENABLED=" + ENABLED
				+ ", CREATEDDATE=" + CREATEDDATE + ", CREATEDBY=" + CREATEDBY + ", EMAIL=" + EMAIL + "]";
	}
	
}
