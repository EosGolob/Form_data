package com.eos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eos.dto.EmployeeDto;
import com.eos.service.EmployeeService;

import jakarta.validation.Valid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = {"http://localhost:3000","http://20.193.159.186:3000"})
//@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Value("${file.upload-dir}")
	private String path;

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	@PostMapping("/createEmployee")
	public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestPart("employee") EmployeeDto employeeDto,
			@RequestParam("image") MultipartFile image) {
		try {
			if (employeeDto == null || image == null || image.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto, image, path);
			return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
		} catch (IOException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	/**
	@PostMapping("/createEmployee")
	public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestPart("employee") EmployeeDto employeeDto,
			@RequestParam(value = "image",required = false) MultipartFile image) {
		try {
			if (employeeDto == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto, image, path);
			return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
		} catch (IOException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	*/

	

}
