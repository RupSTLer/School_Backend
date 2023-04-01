package com.springproject.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.sms.entity.Role;

public interface RoleRepo extends JpaRepository<Role, String>{

}
