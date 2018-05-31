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
	@NamedQuery(name="users.getAlluser",query="select u from Users")
})

@Table(name="USERS")
public class Users {

	@Id
	@SequenceGenerator(name="USERS_SEQ",sequenceName="USERS_SEQ")
	@GeneratedValue(generator="USERS_SEQ")
	@Column(name="ID")
	private int ID;
	
	@Column(name="NAME")
	private String NAME;
	
	@Column(name="PASSWORD")
	private String PASSWORD;
	
	@Column(name="STATUS")
	private String STATUS;
	
	@Column(name="CREATEDDATE")
	private Date CREATEDDATE;
	
	@Column(name="CREATEDBY")
	private String CREATEDBY;
	

	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getNAME() {
		return NAME;
	}


	public void setNAME(String nAME) {
		NAME = nAME;
	}


	public String getPASSWORD() {
		return PASSWORD;
	}


	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}


	public String getSTATUS() {
		return STATUS;
	}


	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
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


	@Override
	public String toString() {
		return "Users [ID=" + ID + ", NAME=" + NAME + ", PASSWORD=" + PASSWORD
				+ ", STATUS=" + STATUS + ", CREATEDDATE=" + CREATEDDATE
				+ ", CREATEDBY=" + CREATEDBY + "]";
	}
	
}
