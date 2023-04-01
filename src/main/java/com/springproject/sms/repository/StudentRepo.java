package com.springproject.sms.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.springproject.sms.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
