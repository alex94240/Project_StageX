package com.stagex.bean;

import com.stagex.annotation.Column;
import com.stagex.annotation.Entity;
import com.stagex.annotation.Id;

@Entity("offer")
public class Offer {
	@Id("offerId")
	private int offerId;

	@Column("companyId")
	private int companyId;

	@Column("contactFirstName")
	private String contactFirstName;

	@Column("contactLastName")
	private String contactLastName;

	@Column("email")
	private String email;

	@Column("job")
	private String job;

	@Column("title")
	private String title;

	@Column("description")
	private String description;

	@Column("profileRequirement")
	private String profileRequirement;

	@Column("abilityRequirement")
	private String abilityRequirement;

	@Column("loction")
	private String loction;

	@Column("salary")
	private String salary;

	@Column("duration")
	private String duration;
	
	@Column("validate")
	private boolean validate;
	
	

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProfileRequirement() {
		return profileRequirement;
	}

	public void setProfileRequirement(String profileRequirement) {
		this.profileRequirement = profileRequirement;
	}

	public String getAbilityRequirement() {
		return abilityRequirement;
	}

	public void setAbilityRequirement(String abilityRequirement) {
		this.abilityRequirement = abilityRequirement;
	}

	public String getLoction() {
		return loction;
	}

	public void setLoction(String loction) {
		this.loction = loction;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	
}
