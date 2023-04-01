package com.springproject.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.sms.entity.News;
import com.springproject.sms.repository.NewsRepo;

@RestController
public class NewsController {
	
	@Autowired
	private NewsRepo newsRepo;
	
	@GetMapping("/getAllNews")
	public List<News> getAllNews()
	{
//		News n = new News();
//		n.setDate(LocalDate.now());
		List<News> news = newsRepo.findAll();
		return news;
	}

}
