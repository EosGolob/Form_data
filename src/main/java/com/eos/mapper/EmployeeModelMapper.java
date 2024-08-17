package com.eos.mapper;



import com.eos.dto.EmployeeDto;
import com.eos.entity.EmployeeEntity;

public class EmployeeModelMapper {

//	@Autowired
//	private ModelMapper modelMapper;
	
	public  static EmployeeDto mapToEmployeeDto(EmployeeEntity employee) {
//		EmployeeDto employeeDto = this.modelMapper.map(employeeEntity,EmployeeDto.class);
//		return employeeDto;
		
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
//		EmployeeEntity employeeEntity = this.modelMapper.map(employeeDto,EmployeeEntity.class);
//		return employeeEntity;
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
