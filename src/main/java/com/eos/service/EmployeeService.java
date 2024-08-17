package com.eos.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.eos.dto.EmployeeDto;


public interface EmployeeService {
	public EmployeeDto createEmployee(EmployeeDto employeeDto, MultipartFile file, String path)throws IOException;
    boolean checkDuplicateEmailAndAddharNo(String email, String aadhaarNumber);
    boolean checkDuplicateEmail(String email);
    boolean checkDuplicateAdhaarNo(String aadharNumber);
    
}
