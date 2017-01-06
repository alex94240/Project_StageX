package com.stagex.bean;

import java.util.Date;

import com.stagex.annotation.Column;
import com.stagex.annotation.Entity;
import com.stagex.annotation.Id;

@Entity("studentexperience")
public class StudentExperience {

	@Id("studentId")
	private int studentId;

	@Id("experienceId")
	private int experienceId;

	@Column("startDate")
	private Date startDate;

	@Column("endDate")
	private Date endDate;

	@Column("description")
	private String description;

	@Column("StudentExperiencecol")
	private String StudentExperiencecol;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getExperienceId() {
		return experienceId;
	}

	public void setExperienceId(int experienceId) {
		this.experienceId = experienceId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStudentExperiencecol() {
		return StudentExperiencecol;
	}

	public void setStudentExperiencecol(String studentExperiencecol) {
		StudentExperiencecol = studentExperiencecol;
	}
	
	
}
