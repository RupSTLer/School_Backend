package com.springproject.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.sms.entity.Student;
import com.springproject.sms.exception.ResourceNotFoundException;
import com.springproject.sms.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	
	public Student saveStudent(Student student)
	{
		return studentRepo.save(student);
	}
	
	public List<Student> listAllStudents()
	{
		return studentRepo.findAll();
	}
	
	public Student getStudentByID(Long id)
	{
		return studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));
	}

	public Student updateStudent(Student student, Long id)
	{
		Student existingStudent = studentRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));
		
//		existingStudent.setStudentID(student.getStudentID());
//		existingStudent.setId(student.getId());
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setPassword(student.getPassword());
		
		studentRepo.save(existingStudent);
		return existingStudent;
	}
	
	public void deleteStudent(Long id)
	{
		studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));
		studentRepo.deleteById(id);
	}
	
	public Long countStudent()
	{
		return studentRepo.count();
	}
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////
	
//	private final Map<Long, Student> students;
//	
//	public StudentService()
//	{
//		this.students = new HashMap<>();
//		
//		students.put(1L, new Student(1L, "John Doe"));
//		
//		students.put(2L, new Student(2L, "jane smith"));
//	}
//	
//	
//	public LeaveApplication applyForLeave(Long id, LeaveApplication leaveApplication)
//	{
//		Optional<Student> student = studentRepo.findById(id);
//		
//		LeaveApplication savedApplication = student.add
//		
//		student.addLeaveApplication(leaveApplication);
//		
//	}
//	





}
