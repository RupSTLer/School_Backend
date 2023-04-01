package com.springproject.sms.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springproject.sms.entity.Role;
import com.springproject.sms.entity.Student;
import com.springproject.sms.entity.User;
import com.springproject.sms.repository.RoleRepo;
import com.springproject.sms.repository.StudentRepo;
import com.springproject.sms.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
//	register new user from typing new user value not hardcoded
	public User registerNewUser(User user) {
		Role role = roleRepo.findById("User").get();

		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRole(roles);

		user.setUserPassword(getEncodedPassword(user.getUserPassword()));
		return userRepo.save(user);
	}

	
	
	public void initRolesAndUser() {
		// creating roles -
//
//		//Admin role
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleRepo.save(adminRole);
//
//		//User Role
		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created record");
		roleRepo.save(userRole);
//
//		//Student role
		Role studentRole = new Role();
		studentRole.setRoleName("Student");
		studentRole.setRoleDescription("role for student");
		roleRepo.save(studentRole);
//
//		///////////////////////////////////////////////////////////////////////
//
//		// hardcoded Admin details -
//
		User adminUser = new User();
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));

		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userRepo.save(adminUser);
//
//		// hardcoded User details -
//
		User user = new User();
		user.setUserFirstName("Rupam");
		user.setUserLastName("Roy");
		user.setUserName("rup123");
		user.setUserPassword(getEncodedPassword("rup@pass"));

		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		userRepo.save(user);
//
//		// hardcoded User details -
//
		Student student = new Student();
		student.setId(1L);
		student.setName("Ranjan Roy");
		student.setUserName("ran123");
		student.setPassword(getEncodedPassword("ran@pass"));
		student.setEmail("rup@g.co");
////
		Set<Role> studentRoles = new HashSet<>();
		studentRoles.add(studentRole);
		student.setRole(studentRoles);
		studentRepo.save(student);
//
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
