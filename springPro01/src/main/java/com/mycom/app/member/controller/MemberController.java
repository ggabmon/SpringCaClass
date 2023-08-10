package com.mycom.app.member.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.app.member.model.Member;
import com.mycom.app.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;

	
	@RequestMapping("/mvcPrac01")
	public String showMemberCnt(Model model) {
		int totalMemberCnt = memberService.showMemberCnt();
		System.out.println("컨트롤러의수"+totalMemberCnt);
		model.addAttribute("number",totalMemberCnt);
		return "home";
	}
	
	@RequestMapping("/showMember")
	public String showMember(Model model) {
		Member member = memberService.showMember();
		model.addAttribute(member);
		return "memberTable";
	}
	
	@RequestMapping("/member/list") // 목록가져오기 : get방식으로
	public String memberList(@RequestParam(required = false, defaultValue = "1") int pageNo
			, Model model) {
		List<Member> memberList = memberService.memberList(pageNo);
		model.addAttribute(memberList);
		return "listMember";
	}
	
	//한명의 정보는 각자 HashMap에 담았고, 그것들을 List에 담았다.
	@RequestMapping("/member/list2") // 목록가져오기 : get방식으로
	public String memberList2(@RequestParam(required = false, defaultValue = "1") int pageNo
			, Model model) {
		List<HashMap<String, Object>> memberList = memberService.memberList2(pageNo);
		model.addAttribute(memberList);
		return "listMember";
	}
	
	@RequestMapping("/member/modify")
	public String memberModify(@RequestParam int memberNo) {
		
		return "";
	}
	
	@RequestMapping("/member/delete")
	public String memberDelete(@RequestParam int memberNo) {
		
		return "";
	}
}
