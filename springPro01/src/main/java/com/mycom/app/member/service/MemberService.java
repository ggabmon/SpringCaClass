package com.mycom.app.member.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.app.member.model.Member;
import com.mycom.app.member.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepository;
	
	public int showMemberCnt() {
		int totalMemberCnt = memberRepository.showMemberCnt();
		return totalMemberCnt;
	}

	public Member showMember() {
		Member member = memberRepository.showMember();
		return member;
	}

	public List<Member> memberList(int pageNo) {
		List<Member> memberList = memberRepository.memberList(pageNo);
		return memberList;
	}

	public List<HashMap<String, Object>> memberList2(int pageNo) {
		List<HashMap<String, Object>> memberList = memberRepository.memberList2(pageNo);
		return memberList;
	}
}
