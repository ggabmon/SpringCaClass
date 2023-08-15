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

	//회원의 아이디를 입력받아서 그 아이디에 대한 상세 정보 받아오기
	public Member selectMemberById(String memberId) {
		Member member = memberRepository.selectMemberById(memberId);
		return member;
	}
	
	//회원의 상세페이지에서 그 회원의 정보를 삭제
	public int deleteMemberByNo(int no) {
		int delCnt = memberRepository.deleteMemberByNo(no);
		return delCnt;
	}

	public int join(Member member) {
		int joinCnt = memberRepository.join(member);
		return joinCnt;
	}

	//회원의 정보를 수정
	public int update(Member member) {
		int updateCnt = memberRepository.update(member);
		return updateCnt;
	}
}
