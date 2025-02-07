package com.eos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eos.entity.Notification;
import com.eos.service.NotificationService;
//@CrossOrigin(origins = {"http://localhost:443","http://172.16.10.162:443"})
//@CrossOrigin(origins = {"http://localhost:3000","http://20.193.159.186:3000"})
@CrossOrigin(originPatterns = "*")
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
