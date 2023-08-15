package com.mycom.app.member.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.app.member.model.Member;
import com.mycom.app.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;

	// 전체 회원수를 조회하는 메서드
	@RequestMapping("/mvcPrac01")
	public String showMemberCnt(Model model) {
		int totalMemberCnt = memberService.showMemberCnt();
		System.out.println("컨트롤러의수"+totalMemberCnt);
		model.addAttribute("number",totalMemberCnt);
		return "home";
	}
	
	// 특정 회원의 정보를 가져오는 메서드
	@RequestMapping("/showMember")
	public String showMember(Model model) {
		Member member = memberService.showMember();
		model.addAttribute(member);
		return "memberTable";
	}
	
	// 전체 회원의 목록을 가져오는 메서드
	@RequestMapping("/member/list") // 목록가져오기 : get방식으로
	public String memberList(@RequestParam(required = false, defaultValue = "1") int pageNo
			, Model model) {
		List<Member> memberList = memberService.memberList(pageNo);
		model.addAttribute("memberList",memberList);
		return "listMember";
	}
	
	//각자의 정보를 각자 HashMap에 담았고, 그것들을 List에 담아 가져오는 메서드
	@RequestMapping("/member/list2") // 목록가져오기 : get방식으로
	public String memberList2(@RequestParam(required = false, defaultValue = "1") int pageNo
			, Model model) {
		List<HashMap<String, Object>> memberList = memberService.memberList2(pageNo);
		model.addAttribute("memberList",memberList);
		return "listMember";
	}
	
		
	//회원의 아이디를 누르면 그 아이디에 대한 상세 정보 받아오기
	@RequestMapping("/member/detail")
	public String selectMemberById(@RequestParam String memberId, Model model) {
		Member member = memberService.selectMemberById(memberId);
		model.addAttribute(member);
		return "memberTable";
	}
	
	//회원의 상세페이지에서 그 회원의 정보를 삭제하기 버튼
	@RequestMapping("/member/delete")
	public ModelAndView deleteMemberByNo(@RequestParam("no") int no, ModelAndView mv) {
		//비즈니스 로직 수행
		int delCnt = memberService.deleteMemberByNo(no);
		//결과물로 삭제된 row의 개수가 나옴. 지워지면 1 안지워졌으면 0 일것이다.
		if(delCnt==1) {mv.setViewName("redirect:/member/list");}
		else {mv.setViewName("/fail/deleteFail");}
		return mv;
	}

	//회원가입 페이지 요청
	@RequestMapping("/member/joinform")
	public String joinForm() {
		return "member/Join";
	}
	
	//회원가입 메서드
	@RequestMapping("/member/join")
	public ModelAndView join(ModelAndView mv,
			@RequestParam String memberId,
			@RequestParam String password,
			@RequestParam String name) {
		//정보를 받아 객체를 담아 전달
		int joinCnt = memberService.join(new Member(memberId, password, name));
		//회원가입 성공시 목록으로, 실패시 다시 가입폼으로 
		if(joinCnt!=1) {mv.setViewName("redirect:/member/joinform");}
		else {mv.setViewName("redirect:/member/list");}
		return mv;
	}
	
	//정보수정 페이지 요청
	@RequestMapping("/member/updateForm")
	public String updateForm(@RequestParam String memberId,
							Model model) {
		Member member = memberService.selectMemberById(memberId);
		model.addAttribute("member", member);
		return "member/Update";
	}
	
	//정보수정 메서드
	@RequestMapping("/member/update")
	public ModelAndView update(	ModelAndView mv,
			@RequestParam String memberId,
			@RequestParam String password,
			@RequestParam String name,
			@RequestParam int no
									) {
		Member member = new Member(no, memberId, password, name);
		int updateCnt = memberService.update(member);
		mv.setViewName("redirect:/member/list");
		return mv;
	}
	
}
