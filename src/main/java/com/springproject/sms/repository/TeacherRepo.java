package com.springproject.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.sms.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {

}
