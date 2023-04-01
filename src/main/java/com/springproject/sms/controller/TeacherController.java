package com.springproject.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.sms.entity.MessageToTeacher;
import com.springproject.sms.entity.Teacher;
import com.springproject.sms.repository.MessageRepo;
import com.springproject.sms.service.TeacherService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/teacher")
@PreAuthorize("hasAnyRole('User', 'Admin')")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private MessageRepo msgRepo;
	
	@GetMapping("/")
	public String teacher_controller()
	{
		return "This is teacher controller";
	}
	
	@GetMapping("/list")
	public List<Teacher> listAllTeachers()
	{
		return teacherService.listAllTeachers();
	}
	
	@PostMapping("/addTeacher")
	public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher)
	{
		return new ResponseEntity<Teacher>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Teacher> getTeacherByID(@PathVariable("id") Long id)
	{
		return new ResponseEntity<Teacher>(teacherService.getTeacherByID(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher, @PathVariable("id") Long id)
	{
		return new ResponseEntity<Teacher>(teacherService.updateTeacher(teacher, id), HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTeacher(@PathVariable("id") Long id)
	{
		teacherService.deleteTeacher(id);
		return new ResponseEntity<String>("Teacher deleted successfully", HttpStatus.OK);
	}
	
	
	@GetMapping("/getMessage")
	public List<MessageToTeacher> getMessage()
	{
		return msgRepo.findAll();
	}
	
	
	


}
