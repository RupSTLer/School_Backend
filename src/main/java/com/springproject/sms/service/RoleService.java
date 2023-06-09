package com.springproject.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.sms.entity.Role;
import com.springproject.sms.repository.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;

	public Role createNewRole(Role role)
	{
		return roleRepo.save(role);
	}
}
