package com.springproject.sms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.sms.entity.User;

public interface UserRepo extends JpaRepository<User, String> 
{

}
