package com.eos.entity;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "full_name"  ,nullable = false)
	private String fullName;
	
	@Column(name = "email",nullable = false,unique = true)
	private String email;
	
	@Column(name = "job_profile")
	private String jobProfile;
	
	@Column(name = "Qualification", nullable = false)
	private String Qualification;
	
	@Column(name = "mobile_no", nullable = false)
	private Long mobileNo;
	
	@Column(name = "permanent_address", nullable = false)
	private String permanentAddress;
	
	@Column(name = "current_address", nullable = false)
	private String currentAddress;
	
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@Column(name = "previous_Organisation", nullable = false)
	private String previousOrganisation;
	
	@Column(name = "work_Exp",nullable = false)
	private String workExp;
	
	@Column(name = "dob", nullable = false)
	private Date dob;
	
	@Column(name = "marital_status", nullable = false)
	private String maritalStatus;
	
	@Column(name = "refferal" ,nullable = false)
	private String refferal;
	
	@Column(name = "aadhaar_number",nullable = false, unique = true)
	private String aadhaarNumber;
	
	@Column(name = "languages", nullable = false)
	private String languages;
	
	@Column(name ="experience", nullable = false)
	private Float experience;
	
	@Column(name = "source", nullable = false)
	private String source;
	
	@Column(name = "sub_source", nullable = false)
	private String subSource;
	
	@Column(name = "initial_status")
	private String initialStatus;
	
	@Column(name = "processes_status")
	private String processesStatus;
	
	@Column(name = "hr_status")
	private String hrStatus;
	
	@Column(name = "manager_status")
	private String managerStatus;
	
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<StatusHistory> statusHistories;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<InterviewProcesses> interviewProcesses;
	@Column(name = "aadhar_filename")
	private String aadharFilename;
     
	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "last_Interview_Assin")
	private String lastInterviewAssin;
	
	@PrePersist
	protected void onCreate() {
	    creationDate = new Date();
	}

	
}
