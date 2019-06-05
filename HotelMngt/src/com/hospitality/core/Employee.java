package com.hospitality.core;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
//@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Employee extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="employee_id")
	private String employeeId;

	@Column(name="audhar_card_no")
	private String audharCardNo;

	@Column(name="correspondence_address")
	private String correspondenceAddress;

	@Column(name="cur_city")
	private String curCity;

	@Column(name="cur_state")
	private String curState;

	@Column(name="cur_street")
	private String curStreet;

	@Column(name="driving_licence_no")
	private String drivingLicenceNo;

	@Column(name="email_id")
	private String emailId;

	@Column(name="employee_name")
	private String employeeName;

	@Column(name="father_name")
	private String fatherName;

	@Column(name="gender")
	private String gender;

	@Column(name="image")
	private String image;

	@Column(name="marital_status")
	private Boolean maritalStatus;

	@Column(name="pan_number")
	private String panNumber;

	@Column(name="passport_no")
	private String passportNo;

	@Column(name="permanent_address")
	private String permanentAddress;

	@Column(name="permnt_city")
	private String permntCity;

	@Column(name="permnt_state")
	private String permntState;

	@Column(name="permnt_street")
	private String permntStreet;

	@Column(name="prefix")
	private String prefix;

	@Column(name="qualification")
	private String qualification;

	@Column(name="religion")
	private String religion;

	@Column(name="voter_id")
	private String voterId;
	
	//bi-directional many-to-one association to Hotel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	public Employee() {
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getAudharCardNo() {
		return this.audharCardNo;
	}

	public void setAudharCardNo(String audharCardNo) {
		this.audharCardNo = audharCardNo;
	}

	public String getCorrespondenceAddress() {
		return this.correspondenceAddress;
	}

	public void setCorrespondenceAddress(String correspondenceAddress) {
		this.correspondenceAddress = correspondenceAddress;
	}

	public String getCurCity() {
		return this.curCity;
	}

	public void setCurCity(String curCity) {
		this.curCity = curCity;
	}

	public String getCurState() {
		return this.curState;
	}

	public void setCurState(String curState) {
		this.curState = curState;
	}

	public String getCurStreet() {
		return this.curStreet;
	}

	public void setCurStreet(String curStreet) {
		this.curStreet = curStreet;
	}

	public String getDrivingLicenceNo() {
		return this.drivingLicenceNo;
	}

	public void setDrivingLicenceNo(String drivingLicenceNo) {
		this.drivingLicenceNo = drivingLicenceNo;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(Boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPanNumber() {
		return this.panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPermanentAddress() {
		return this.permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPermntCity() {
		return this.permntCity;
	}

	public void setPermntCity(String permntCity) {
		this.permntCity = permntCity;
	}

	public String getPermntState() {
		return this.permntState;
	}

	public void setPermntState(String permntState) {
		this.permntState = permntState;
	}

	public String getPermntStreet() {
		return this.permntStreet;
	}

	public void setPermntStreet(String permntStreet) {
		this.permntStreet = permntStreet;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getVoterId() {
		return this.voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

}