package com.springproject.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.sms.entity.LeaveApplication;

public interface LeaveRepo extends JpaRepository<LeaveApplication, Long> {
	
	

}
