package com.eos.serviceimpl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eos.entity.EmployeeEntity;
import com.eos.entity.StatusHistory;
import com.eos.repository.EmployeeRepository;
import com.eos.repository.StatusHistoryRepository;
import com.eos.service.StatusHistoryService;



@Service
public class StatusHistoryServiceImpl implements StatusHistoryService {

	@Autowired
	private StatusHistoryRepository statusHistoryRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void createInitialStatus(EmployeeEntity employee) {

		StatusHistory initialStatus = new StatusHistory();
		initialStatus.setId(generateUniqueId());
		initialStatus.setEmployee(employee);
		initialStatus.setStatus("Active");
		initialStatus.setChangesDateTime(LocalDateTime.now());
		statusHistoryRepository.save(initialStatus);

	}

	private Long generateUniqueId() {
		return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}

	@Override
	public void trackStatusChange(EmployeeEntity employee, String newStatus) {

		StatusHistory latestStatusHistory = statusHistoryRepository
				.findTopByEmployeeOrderByChangesDateTimeDesc(employee);
		if (latestStatusHistory != null && !latestStatusHistory.getStatus().equals(newStatus)) {
			StatusHistory statusHistory = new StatusHistory();
			statusHistory.setEmployee(employee);
			statusHistory.setStatus(newStatus);
			statusHistory.setChangesDateTime(LocalDateTime.now());
			statusHistoryRepository.save(statusHistory);
			employeeRepository.save(employee);

		}

	}

}
