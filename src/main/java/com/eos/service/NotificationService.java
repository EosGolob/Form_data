package com.eos.service;

import java.util.List;

import com.eos.entity.Notification;

public interface NotificationService {
 
	public void notifyAdminNewEmployee(Long employeeId);
	List<Notification> getAllNotifications();
}
