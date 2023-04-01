package com.springproject.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.sms.entity.MessageToTeacher;
import com.springproject.sms.entity.Student;
import com.springproject.sms.service.MessageService;
import com.springproject.sms.service.StudentService;

@RestController
@RequestMapping("/student/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
//	
//	@PostMapping("/create")
//	public MessageToTeacher createMessage(@RequestBody MessageToTeacher message)
//	{
//		return messageService.createMessage(message);
//	}
//	
//	@GetMapping("/msg")
//	public List<MessageToTeacher> getMessagesForStudentAndTeacher(@RequestParam Long studentID, @RequestParam Long teacherID)
//	{
//		return messageService.getMessagesForStudentAndTeacher(studentID, teacherID);
//	}
//	
//	
//	
//	public ResponseEntity<MessageToTeacher> sendMessage(@PathVariable Long teacherId, @RequestBody MessageToTeacher msg, @AuthenticationPrincipal UserDetails userDetails)
//	{
//		
//	}
	
	@PostMapping("/sendMessage")
	public ResponseEntity<MessageToTeacher> sendMessage(@RequestBody MessageToTeacher msg)
	{
		return new ResponseEntity<MessageToTeacher>(messageService.saveMessage(msg), HttpStatus.CREATED);
	}

}
