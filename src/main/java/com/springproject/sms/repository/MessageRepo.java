package com.springproject.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.sms.entity.MessageToTeacher;

public interface MessageRepo extends JpaRepository<MessageToTeacher, Long> {
	
//	List<MessageToTeacher> findByStudentIdAndTeacherId(Long studentID, Long teacherID);

}
