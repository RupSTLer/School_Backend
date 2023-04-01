package com.springproject.sms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class News {
	
	@Id
	private String title;
	private String body;
	private String date;

}
