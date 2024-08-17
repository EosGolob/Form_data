package com.eos.dto;

import java.util.Date;
import java.util.List;

import com.eos.entity.InterviewProcesses;
import com.eos.entity.StatusHistory;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	
	private Long id;
	
	@NotNull(message = "Full Name Cannot be Null")
	private String fullName;
	
	@NotNull(message = "Email Cannot be Null")
	private String email;
	
	@NotNull(message = "Job Profile Cannot be Null")
	private String jobProfile;
	
	@NotNull(message = "Qualification Cannot be Null")
	private String Qualification;
	
	@NotNull(message = "Mobile No Cannot be Null")
	private Long mobileNo;
	
	@NotNull(message = "Permanent Address Cannot be Null")
	private String permanentAddress;
	
	@NotNull(message = "Current Address Cannot be Null")
	private String currentAddress;
	
	@NotNull(message = "Gender Cannot be Null")
	private String gender;
	
	@NotNull(message = "Previous Organisation Cannot be Null")
	private String previousOrganisation;
	
	@NotNull(message = "DOB Cannot be Null")
	private Date dob;
	
	@NotNull(message = "Marital Status Cannot be Null")
	private String maritalStatus;
	
	@NotNull(message = "Refferal Cannot be Null")
	private String refferal;
	
	
	private String aadharFilename;
	
	
	private String initialStatus;
	
	
	private String processesStatus;
	
	
	private String hrStatus;
	private String managerStatus;
	private List<StatusHistory> statusHistories;
    private List<InterviewProcesses> interviewProcesses;
	@NotNull(message = "Aadhar no Cannot be Null")
	private String aadhaarNumber;
	
	@NotNull(message = "Languages Cannot be Null")
	private String languages;
	
	@NotNull(message = "Experience Cannot be Null")
	private int experience;
	
	@NotNull(message = "Source Cannot be Null")
	private String source;
	
	@NotNull(message = "Sub Source Cannot be Null")
	private String subSource;
	
	private Date creationDate;
	private String lastInterviewAssin;

	
	
	
     

}
