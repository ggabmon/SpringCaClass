package com.mycom.app.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.app.member.model.Member;
import com.mycom.app.member.service.MemberService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	MemberService memberService;
	
	//공지사항 페이지로 연결
	// (http://localhost:8081/app/notice/list)
	@RequestMapping("/list")
	public String noticePage(Model model) {
		System.out.println("메서드에 접근");
		//회원목록을 불러와서 tiles와 함께 연습해본다.
		List<Member> memberList = memberService.memberList();
		model.addAttribute("MEMBER", memberList);
		return "/notice/list";
	}
}
