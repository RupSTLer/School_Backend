package com.springproject.sms.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.sms.entity.MessageToTeacher;
import com.springproject.sms.repository.MessageRepo;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepo messageRepo;
	
	MessageToTeacher msg = new MessageToTeacher();
	
//	@Autowired
//	private MessageToTeacher messageToTeacher;
	
//	public List<MessageToTeacher> getMessagesForStudentAndTeacher(Long stu_id, Long tea_id)
//	{
//		return messageRepo.findByStudentIdAndTeacherId(stu_id, tea_id);
//		
//	}
//	
//	public MessageToTeacher createMessage(MessageToTeacher message)
//	{
//		message.setTimeStamp(LocalDateTime.now());
//		return messageRepo.save(message);
//	}
	
	
	public MessageToTeacher saveMessage(MessageToTeacher msg)
	{
		LocalDateTime datetime = LocalDateTime.now();  
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	    String timestamp = datetime.format(format);  
		msg.setTime(timestamp);
		return messageRepo.save(msg);
	}
	
	

}
