package com.stagex.bean;

import com.stagex.annotation.Column;
import com.stagex.annotation.Entity;
import com.stagex.annotation.Id;

@Entity("comapny")
public class Company {
	@Id("companyId")
	private int companyId;
	
	@Column("companyName")
	private String companyName;
	
	@Column("siretNumber")
	private String   siretNumber;
	
	@Column("codeApe")
	private String codeApe;
	
	@Column("companyAddress")
	private String companyAddress;
	
	@Column("receptionName")
	private String receptionName;
	
	@Column("telphone")
	private String telphone;
	
	@Column("fax")
	private String fax;
	
	@Column("email")
	private String email;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSiretNumber() {
		return siretNumber;
	}

	public void setSiretNumber(String siretNumber) {
		this.siretNumber = siretNumber;
	}

	public String getCodeApe() {
		return codeApe;
	}

	public void setCodeApe(String codeApe) {
		this.codeApe = codeApe;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getReceptionName() {
		return receptionName;
	}

	public void setReceptionName(String receptionName) {
		this.receptionName = receptionName;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
	  
	  
	
}
