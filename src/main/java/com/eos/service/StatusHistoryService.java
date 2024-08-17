package com.eos.service;

import com.eos.entity.EmployeeEntity;

public interface StatusHistoryService {
	  public void createInitialStatus(EmployeeEntity employee);
	  public void trackStatusChange(EmployeeEntity employee, String newStatus );

}
