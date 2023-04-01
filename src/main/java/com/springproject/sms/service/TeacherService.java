package com.springproject.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.sms.entity.Teacher;
import com.springproject.sms.exception.ResourceNotFoundException;
import com.springproject.sms.repository.TeacherRepo;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepo teacherRepo;
	
	public Teacher saveTeacher(Teacher teacher)
	{
		return teacherRepo.save(teacher);
	}
	
	public List<Teacher> listAllTeachers()
	{
		return teacherRepo.findAll();
	}
	
	public Teacher getTeacherByID(Long id)
	{
		return teacherRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id: " + id));
	}

	public Teacher updateTeacher(Teacher teacher, Long id)
	{
		Teacher existingTeacher = teacherRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id: " + id));
		
//		existingTeacher.setTeacherID(teacher.getTeacherID());
//		existingTeacher.setId(teacher.getId());
		existingTeacher.setName(teacher.getName());
		existingTeacher.setPassword(teacher.getPassword());
		existingTeacher.setEmail(teacher.getEmail());
		
		teacherRepo.save(existingTeacher);
		return existingTeacher;
	}
	
	public void deleteTeacher(Long id)
	{
		teacherRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id: " + id));
		teacherRepo.deleteById(id);
	}

}
