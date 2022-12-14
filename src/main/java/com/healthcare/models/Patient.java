package com.healthcare.models;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int patientId;
	private String name;
	private String phoneNo;
	@Column(unique = true)
	private String emailId;
	private int age;
	private String gender;
	@OneToMany
	private Set<Appointment> appointments = Collections.emptySet();
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Set<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}


	@Override
	public String toString() {
		return "Patient{" +
				"patientId=" + patientId +
				", name='" + name + '\'' +
				", phoneNo='" + phoneNo + '\'' +
				", emailId='" + emailId + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				", appointments=" + appointments +
				'}';
	}
}
