package com.mycom.app.admin.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl {
	//필드
	@Autowired
	private JavaMailSender mailSender;
	
	
	
	//메서드
	public void sendMail(String to, String subject, String content) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper=new MimeMessageHelper(message, true, "utf-8");
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setFrom("whwnd5993@naver.com","관리자");
			messageHelper.setText(content);
			mailSender.send(message);
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
}
