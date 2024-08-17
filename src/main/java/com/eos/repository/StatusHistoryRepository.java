package com.eos.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.eos.entity.EmployeeEntity;
import com.eos.entity.StatusHistory;



public interface StatusHistoryRepository extends  JpaRepository<StatusHistory, Long> {

	StatusHistory findTopByEmployeeOrderByChangesDateTimeDesc(EmployeeEntity employee);
}
