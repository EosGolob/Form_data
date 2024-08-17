package com.eos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eos.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	boolean existsByEmail(String email);
	boolean existsByAadhaarNumber(String aadhaarNumber);
}
