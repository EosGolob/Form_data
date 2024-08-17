package com.eos.serviceimpl;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eos.dto.EmployeeDto;
import com.eos.entity.EmployeeEntity;
import com.eos.entity.InterviewProcesses;
import com.eos.entity.StatusHistory;
import com.eos.mapper.EmployeeModelMapper;
import com.eos.repository.EmployeeRepository;
import com.eos.repository.StatusHistoryRepository;
import com.eos.service.EmployeeService;
import com.eos.service.FileService;
import com.eos.service.StatusHistoryService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private FileService fileService;

	@Autowired
	private StatusHistoryService statusHistoryService;

	@Autowired
	private StatusHistoryRepository statusHistoryRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto, MultipartFile file, String path) throws IOException {
		if (checkDuplicateEmailAndAddharNo(employeeDto.getEmail(), employeeDto.getAadhaarNumber())) {
			throw new RuntimeException("Email or Aadhaar number already exists");
		}
//		if(checkDuplicateEmail(employeeDto.getEmail()) && checkDuplicateAdhaarNo(employeeDto.getAadhaarNumber())) {
//			throw new RuntimeException("Email And addharNo should be unique");
//		}else if(checkDuplicateEmail(employeeDto.getEmail())){
//			throw new RuntimeException("Email is duplicated ");
//		
//		}else if(checkDuplicateAdhaarNo(employeeDto.getAadhaarNumber())) {
//			throw new RuntimeException("Adhaar no is duplicated");
//		}else {
//		
	
		String fileName = fileService.uploadImage(path, file, employeeDto.getAadhaarNumber());
		employeeDto.getAadhaarNumber();
		employeeDto.setAadharFilename(fileName);
		EmployeeEntity employeeEntity = EmployeeModelMapper.mapToEmployeeEntity(employeeDto);
		EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
		statusHistoryService.createInitialStatus(savedEmployeeEntity);
		updateEmployeeStatus(savedEmployeeEntity);
		return EmployeeModelMapper.mapToEmployeeDto(savedEmployeeEntity);
//		}
	}

	@Override
	public boolean checkDuplicateEmailAndAddharNo(String email, String aadhaarNumber) {
		// TODO Auto-generated method stub
		boolean emailExists = employeeRepository.existsByEmail(email);
		boolean addharnoExists = employeeRepository.existsByAadhaarNumber(aadhaarNumber);
		return emailExists || addharnoExists;

	}

	@Override
	public boolean checkDuplicateEmail(String email) {
		boolean emailCheck = employeeRepository.existsByEmail(email);
		return emailCheck;
	}

	@Override
	public boolean checkDuplicateAdhaarNo(String aadharNumber) {
		boolean checkAdhaarNo = employeeRepository.existsByAadhaarNumber(aadharNumber);
		return checkAdhaarNo;
	}

	private void updateEmployeeStatus(EmployeeEntity employee) {
		StatusHistory latestStatus = statusHistoryRepository.findTopByEmployeeOrderByChangesDateTimeDesc(employee);
		if (latestStatus != null) {
			employee.setInitialStatus(latestStatus.getStatus());
			employeeRepository.save(employee);
		}
	}

	private void setStatusHistoryRecored(Long employeeId, InterviewProcesses savedInterviewProcess, String newStatus,
			EmployeeEntity employee) {
		StatusHistory statusHistory = new StatusHistory();
		statusHistory.setEmployee(employee);
		statusHistory.setInterviewProcess(savedInterviewProcess);
		statusHistory.setStatus(newStatus);
		statusHistory.setChangesDateTime(LocalDateTime.now());
		statusHistoryRepository.save(statusHistory);
	}

}
