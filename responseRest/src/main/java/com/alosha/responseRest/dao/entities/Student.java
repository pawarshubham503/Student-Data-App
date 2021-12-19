package com.alosha.responseRest.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private long studentId;
	@Column(unique=true)
	private long regNo;
	private String studentName;
	private String studentAge;
	
	public Student() {
		
	}
	public Student(long studentId, long regNo, String studentName, String studentAge) {
		super();
		this.studentId = studentId;
		this.regNo = regNo;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}
	@Override
	public String toString() {
		return String.format("Student [studentId=%s, regNo=%s, studentName=%s, studentAge=%s]", studentId, regNo,
				studentName, studentAge);
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public long getRegNo() {
		return regNo;
	}
	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
}
