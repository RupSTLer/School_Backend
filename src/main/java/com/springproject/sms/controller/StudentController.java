package com.springproject.sms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.sms.service.StudentService;
import com.springproject.sms.entity.LeaveApplication;
//import com.springproject.sms.entity.MessageToTeacher;
import com.springproject.sms.entity.Student;
import com.springproject.sms.repository.LeaveRepo;
import com.springproject.sms.repository.StudentRepo;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/student")
@PreAuthorize("hasAnyRole('User', 'Admin')")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private LeaveRepo leaveRepo;

	@GetMapping("/app")
	public String stu_controller() {
		return "This is student controller";
	}

	@GetMapping("/listStudents")
	public List<Student> listAllStudents() {
		return studentService.listAllStudents();
	}

	@PostMapping("/addStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable("id") Long id) {
		return new ResponseEntity<Student>(studentService.getStudentByID(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/countStudent")
	public ResponseEntity<Long> countStudent() {
		Long n1 = studentService.countStudent();
		return new ResponseEntity<Long>(n1, HttpStatus.OK);
	}

//	@PostMapping("/message/{id}")
//	public ResponseEntity<MessageToTeacher> sendMessage(@PathVariable("id") Long id, @RequestBody MessageToTeacher msg, @AuthenticationPrincipal UserDetails userDetails)
//	{
//		Student student = studentRepo.findby
//	}
//	

//	public ResponseEntity<LeaveApplication> applyLeave(@PathVariable("id") Long id, @RequestBody LeaveApplication leave,
//			@AuthenticationPrincipal UserDetails userDetails) {
//		Optional<Student> student = studentRepo.findById(id);
//		if (student == null) {
//			return new ResponseEntity<LeaveApplication>(HttpStatus.NOT_FOUND);
//		}
//
//		leave.setStudent(student);
//		LeaveApplication saveLeave = leaveRepo.save(leave);
//		return new ResponseEntity<LeaveApplication>(saveLeave, HttpStatus.CREATED);
//
//	}

	////////////////////////////////////////////////

//	
//	public StudentController(StudentService studentService)
//	{
//		this.studentService = studentService;
//	}
//	
//	@PostMapping("/leave")
//	public ResponseEntity<String> appForLeave(@RequestBody LeaveApplication leaveApplication)
//	{
//		studentService.applyForLeave(leaveApplication);
//		
//		return ResponseEntity.ok("Leave Application submitted successfully");
//	}

}
