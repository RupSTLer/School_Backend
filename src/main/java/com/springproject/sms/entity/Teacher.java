package com.springproject.sms.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userName;
	
	private String password;
	
	private String name;
	
	private String email;
	
//	@ManyToMany(mappedBy = "USER-ROLE")
//	private Set<Role> role;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "TEACHER_ROLE", 
//				joinColumns = { 
//						@JoinColumn(name = "TEACHER_ID", referencedColumnName = "id") 
//						}, 
//				inverseJoinColumns = {
//						@JoinColumn(name = "ROLE_ID", referencedColumnName = "id")  
//						})
//	private Set<Role> role;

}
