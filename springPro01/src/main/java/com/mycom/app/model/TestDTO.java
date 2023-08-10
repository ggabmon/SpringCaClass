package com.mycom.app.model;

import java.util.List;

public class TestDTO {
	private String userName;
	private List<String> hobby;
	private int pageNo;
	private String searchType;
	private String searchKey;
	

	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public TestDTO(String userName, List<String> hobby, int pageNo, String searchType, String searchKey) {
		super();
		this.userName = userName;
		this.hobby = hobby;
		this.pageNo = pageNo;
		this.searchType = searchType;
		this.searchKey = searchKey;
	}
	public TestDTO() {
	}
	
}
