package com.springproject.sms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

import java.util.Set;

@Entity
public class User {
//	private Long id;
//	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Id
	private String userName;
	private String userFirstName;
	private String userLastName;
	private String userPassword;
	
	

	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserFirstName() {
		return userFirstName;
	}



	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}



	public String getUserLastName() {
		return userLastName;
	}



	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	public Set<Role> getRole() {
		return role;
	}



	public void setRole(Set<Role> role) {
		this.role = role;
	}



	// create a set collection because a user can have multiple roles, so to store multiple roles we use Set
	// here we use Assocoation to connect two tables
	// manyToMany coz many users can have many roles
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE", 
				joinColumns = { 
						@JoinColumn(name = "USER_ID") 
						}, 
				inverseJoinColumns = {
						@JoinColumn(name = "ROLE_ID")  
						})
	private Set<Role> role;

}
