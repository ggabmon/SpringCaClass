package com.mycom.app.admin.member.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.app.admin.member.service.MailServiceImpl;

//관리자-회원관리-메일관련

@Controller
public class MailController {
	
	@Autowired
	private MailServiceImpl mailservice;
	
	@RequestMapping(value="/admin/member/sendMail")
	public void sendMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//메세지의 내용을 service로 전달하여 sendmail 실행
		mailservice.sendMail("whwnd5993@naver.com","this is a subject" ,"this is a content, 한글이 깨지지 않았다면 보이는 메세지입니다.");
		
		out.print("이메일을 발송했습니다.");
	}
}
