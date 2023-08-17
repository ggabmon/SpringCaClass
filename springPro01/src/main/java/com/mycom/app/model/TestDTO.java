package com.mycom.app.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestDTO {
	private String userName;
	private List<String> hobby;
	private int pageNo;
	private String searchType;
	private String searchKey;
	
}
