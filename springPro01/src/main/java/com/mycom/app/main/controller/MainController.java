package com.mycom.app.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	//메인페이지 띄우기 (http://localhost:8081/app/main)
	@RequestMapping("/main")
	public String mainPage() {
		return "/main";
	}
	
	
	
	
	
	//그다음 메서드 작성자리
}
