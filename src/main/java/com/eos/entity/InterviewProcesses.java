package com.eos.entity;

import java.util.Date;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewProcesses {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false )
	@JoinColumn(name = "employee_id" , nullable = false)
	private EmployeeEntity employee;
	
	@OneToMany(mappedBy = "interviewProcess", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<StatusHistory> statusHistories;
	
	@Column(name = "process_name")
	private String processName;
	
	@Column(name = "interview_date")
	private Date interviewDate;
	
	@Column(name = "interview_time")
	private String interviewTime;
	
	@Column(name = "status")
	private String status;
	
//	@ManyToOne(fetch = FetchType.LAZY , optional = true)
//	@JoinColumn(name = "managerDetails_id")
//	private ManagerDetails managerDetails;
}
