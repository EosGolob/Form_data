package com.eos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eos.entity.Notification;
import com.eos.service.NotificationService;

@RestController
@RequestMapping("/api")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping("/notifications")
	public List<Notification> getAllNotifications(){
		return notificationService.getAllNotifications();
		
	}

}
