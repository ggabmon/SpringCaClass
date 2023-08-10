package com.mycom.app.member.model;

import java.util.Date;

public class Member {
	private int no;
	private String memberid;
	private String password;
	private String name;
	private Date regdate;
	private String isshow;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	public Member() {
	}
	public Member(int no, String memberid, String password, String name, Date regdate, String isshow) {
		this.no = no;
		this.memberid = memberid;
		this.password = password;
		this.name = name;
		this.regdate = regdate;
		this.isshow = isshow;
	}
	@Override
	public String toString() {
		return "member [no=" + no + ", memberid=" + memberid + ", password=" + password + ", name=" + name
				+ ", regdate=" + regdate + ", isshow=" + isshow + "]";
	}
	
	
	
}
