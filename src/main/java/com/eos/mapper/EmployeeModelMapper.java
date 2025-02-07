package com.eos.mapper;



import com.eos.dto.EmployeeDto;
import com.eos.entity.EmployeeEntity;

public class EmployeeModelMapper {


	public  static EmployeeDto mapToEmployeeDto(EmployeeEntity employee) {

		
		return new EmployeeDto(
				employee.getId(),
				employee.getFullName(),
				employee.getEmail(),
				employee.getJobProfile(),
				employee.getQualification(),
				employee.getMobileNo(),
				employee.getPermanentAddress(),
				employee.getCurrentAddress(),
				employee.getGender(),
				employee.getPreviousOrganisation(),
				employee.getWorkExp(),
				employee.getDob(),
				employee.getMaritalStatus(),
				employee.getRefferal(),
				employee.getAadharFilename(),
				employee.getInitialStatus(),
				employee.getProcessesStatus(),
				employee.getHrStatus(),
				employee.getManagerStatus(),
				employee.getStatusHistories(),
				employee.getInterviewProcesses(),
				employee.getAadhaarNumber(),
				employee.getLanguages(),
				employee.getExperience(),
				employee.getSource(),
				employee.getSubSource(),
				employee.getCreationDate(),
				employee.getLastInterviewAssin()
				
				);
	}
	
	public static EmployeeEntity mapToEmployeeEntity(EmployeeDto employeeDto) {

		 return new EmployeeEntity(
				  employeeDto.getId(),
				  employeeDto.getFullName(),
				  employeeDto.getEmail(),
				  employeeDto.getJobProfile(),
				  employeeDto.getQualification(),
				  employeeDto.getMobileNo(),
				  employeeDto.getPermanentAddress(),
				  employeeDto.getCurrentAddress(),
				  employeeDto.getGender(),
				  employeeDto.getPreviousOrganisation(),
				  employeeDto.getWorkExp(),
				  employeeDto.getDob(),
				  employeeDto.getMaritalStatus(),
				  employeeDto.getRefferal(),  		 
				  employeeDto.getAadhaarNumber(),
				  employeeDto.getLanguages(),
				  employeeDto.getExperience(),
				  employeeDto.getSource(),
				  employeeDto.getSubSource(),
				  employeeDto.getInitialStatus(),
				  employeeDto.getProcessesStatus(),
				  employeeDto.getHrStatus(),
				  employeeDto.getManagerStatus(),
				  employeeDto.getStatusHistories(),
				  employeeDto.getInterviewProcesses(),
				  employeeDto.getAadharFilename(),
				  employeeDto.getCreationDate(),	
				  employeeDto.getLastInterviewAssin()
				  );
	}
}
