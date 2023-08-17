package com.mycom.app.member.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	public List<Member> memberList() {
		List<Member> memberList = sqlSession.selectList("member.listMember");
		return memberList;
	}

	public List<HashMap<String, Object>> memberList2(int pageNo) {
		List<HashMap<String, Object>> memberList = sqlSession.selectList("member.listMember2");
		return memberList;
	}

	//회원의 아이디를 입력받아서 그 아이디에 대한 상세 정보 받아오기
	public Member selectMemberById(String memberId) {
		Member member = sqlSession.selectOne("member.selectById", memberId);
		return member;
	}

	//회원의 상세페이지에서 그 회원의 정보를 삭제하기 버튼
	public int deleteMemberByNo(int no) {
		int delCnt = sqlSession.delete("member.deleteMemberByNo",no);
		return delCnt;
	}

	public int join(Member member) {
		int joinCnt = sqlSession.insert("member.join", member);
		return joinCnt;
	}

	//회원의 정보를 수정
	public int update(Member member) {
		int updateCnt = sqlSession.insert("member.update",member);
		return updateCnt;
	}
}
