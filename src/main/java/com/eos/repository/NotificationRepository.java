package com.eos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eos.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
