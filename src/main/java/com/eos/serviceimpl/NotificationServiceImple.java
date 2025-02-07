package com.eos.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eos.entity.Notification;
import com.eos.repository.NotificationRepository;
import com.eos.service.NotificationService;
import com.eos.webSocketHandler.NotificationWebSocketHandler;

@Service
public class NotificationServiceImple implements NotificationService {

	@Autowired
	private NotificationWebSocketHandler notificationWebSocketHandler;
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Override
	public void notifyAdminNewEmployee(Long employeeId, String name) {
        String notificationMessage =  name + " has been Register form.";  
        Notification notification = new Notification(employeeId,notificationMessage, false);
        notificationRepository.save(notification);
		notificationWebSocketHandler.sendNotification(notificationMessage);
		
	}

	@Override
	public List<Notification> getAllNotifications() {
		return notificationRepository.findAll();
	}

}
