package com.stagex.bean;

import java.util.Date;

import com.stagex.annotation.Column;
import com.stagex.annotation.Entity;
import com.stagex.annotation.Id;

@Entity("apply")
public class Apply {
	@Id("applyId")
	private int applyId;

	@Column("studentId")
	private int studentId;

	@Column("applyAddress")
	private String applyAddress;

	@Column("applyTelphone")
	private String applyTelphone;

	@Column("chargePersonContact")
	private String chargePersonContact;

	@Column("decription")
	private String decription;

	// new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2007-01-01").getTime())
	@Column("startDate")
	private Date startDate;

	@Column("endDate")
	private Date endDate;

	@Column("salary")
	private int salary;

	@Column("benefit")
	private int benefit;

	@Column("healthInsurance")
	private int healthInsurance;

	@Column("workTrip")
	private int workTrip;

	@Column("bossFirstName")
	private String bossFirstName;

	@Column("bossLastName")
	private String bossLastName;

	@Column("bossJob")
	private String bossJob;

	@Column("bossEmail")
	private String bossEmail;

	@Column("bossTelphone")
	private String bossTelphone;

	@Column("bossFax")
	private String bossFax;

	@Column("wayFindApply")
	private String wayFindApply;

	@Column("companyPrestation")
	private String companyPrestation;

	@Column("companyContast")
	private String companyContast;

	@Column("applyGoal")
	private String applyGoal;

	@Column("pricipleSteps")
	private String pricipleSteps;

	@Column("applyRequirement")
	private String applyRequirement;
	
	@Column("validate")
	private boolean validate;
	
	
	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Column("companyId")
	private int companyId;
	

	public int getApplyId() {
		return applyId;
	}

	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getApplyAddress() {
		return applyAddress;
	}

	public void setApplyAddress(String applyAddress) {
		this.applyAddress = applyAddress;
	}

	public String getApplyTelphone() {
		return applyTelphone;
	}

	public void setApplyTelphone(String applyTelphone) {
		this.applyTelphone = applyTelphone;
	}

	public String getChargePersonContact() {
		return chargePersonContact;
	}

	public void setChargePersonContact(String chargePersonContact) {
		this.chargePersonContact = chargePersonContact;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBenefit() {
		return benefit;
	}

	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}

	public int getHealthInsurance() {
		return healthInsurance;
	}

	public void setHealthInsurance(int healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	public int getWorkTrip() {
		return workTrip;
	}

	public void setWorkTrip(int workTrip) {
		this.workTrip = workTrip;
	}

	public String getBossFirstName() {
		return bossFirstName;
	}

	public void setBossFirstName(String bossFirstName) {
		this.bossFirstName = bossFirstName;
	}

	public String getBossLastName() {
		return bossLastName;
	}

	public void setBossLastName(String bossLastName) {
		this.bossLastName = bossLastName;
	}

	public String getBossJob() {
		return bossJob;
	}

	public void setBossJob(String bossJob) {
		this.bossJob = bossJob;
	}

	public String getBossEmail() {
		return bossEmail;
	}

	public void setBossEmail(String bossEmail) {
		this.bossEmail = bossEmail;
	}

	public String getBossTelphone() {
		return bossTelphone;
	}

	public void setBossTelphone(String bossTelphone) {
		this.bossTelphone = bossTelphone;
	}

	public String getBossFax() {
		return bossFax;
	}

	public void setBossFax(String bossFax) {
		this.bossFax = bossFax;
	}

	public String getWayFindApply() {
		return wayFindApply;
	}

	public void setWayFindApply(String wayFindApply) {
		this.wayFindApply = wayFindApply;
	}

	public String getCompanyPrestation() {
		return companyPrestation;
	}

	public void setCompanyPrestation(String companyPrestation) {
		this.companyPrestation = companyPrestation;
	}

	public String getCompanyContast() {
		return companyContast;
	}

	public void setCompanyContast(String companyContast) {
		this.companyContast = companyContast;
	}

	public String getApplyGoal() {
		return applyGoal;
	}

	public void setApplyGoal(String applyGoal) {
		this.applyGoal = applyGoal;
	}

	public String getPricipleSteps() {
		return pricipleSteps;
	}

	public void setPricipleSteps(String pricipleSteps) {
		this.pricipleSteps = pricipleSteps;
	}

	public String getApplyRequirement() {
		return applyRequirement;
	}

	public void setApplyRequirement(String applyRequirement) {
		this.applyRequirement = applyRequirement;
	}
	
	

}
