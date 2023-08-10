package com.mycom.app.member.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.mycom.app.member.model.Member;

@Repository
public class MemberRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public int showMemberCnt() {
		int totalMemberCnt = sqlSession.selectOne("member.countMember");
		return totalMemberCnt;
	}

	public Member showMember() {
		Member member = (Member)sqlSession.selectOne("member.showOneMember");
		return member;
	}

	public List<Member> memberList(int pageNo) {
		List<Member> memberList = sqlSession.selectList("member.listMember");
		return memberList;
	}

	public List<HashMap<String, Object>> memberList2(int pageNo) {
		List<HashMap<String, Object>> memberList = sqlSession.selectList("member.listMember");
		return memberList;
	}
}
