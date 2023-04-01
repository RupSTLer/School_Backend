package com.springproject.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.sms.entity.News;

public interface NewsRepo extends JpaRepository<News, String> {

}
