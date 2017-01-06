package com.stagex.bean;

import com.stagex.annotation.Column;
import com.stagex.annotation.Entity;
import com.stagex.annotation.Id;

@Entity("experience")
public class Experience {
	@Id("experienceId")
	private int experienceId;
	
	@Column("jobType")
	private String jobType;
	
	@Column("jobName")
	private String jobName;
	
	@Column("salary")
	private String salary;
	
	@Column("companyName")
	private String companyName;
	
	@Column("loction")
	private String loction;

	public int getExperienceId() {
		return experienceId;
	}

	public void setExperienceId(int experienceId) {
		this.experienceId = experienceId;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLoction() {
		return loction;
	}

	public void setLoction(String loction) {
		this.loction = loction;
	}	
	
}
