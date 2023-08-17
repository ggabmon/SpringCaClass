package com.mycom.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.app.model.TestDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//요청주소 http://localhost:8081/app/test?id=hongid&age=15
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model, 
						HttpServletRequest request, HttpServletResponse response,
						@RequestParam("id") String rpid, @RequestParam("age") int rpage) {
		logger.info("Welcome home! The client locale is {}.", locale);
		//1. 파라미터 받기
		//jsp방식
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("파라미터id"+id);
		System.out.println("파라미터age"+(age-1));
		logger.info("직접 받은 파라미터id {}",id);
		logger.info("직접 받고 파싱한 파라미터age {}",(age-1));
		
		logger.info("한방에 받은 어노테이션 파라미터id {}",rpid);
		logger.info("한방에 받은 어노테이션 파라미터age {}",(rpage-1));
		//2. 비즈니스 로직
		

		//3. 모델
		//jsp방식
		response.setCharacterEncoding("utf-8");
		String name = "조중현";
		request.setAttribute("name", name);
		
		//spring 방식
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );

		//4. 뷰지정
		return "home";
	}
	
	
	@RequestMapping("/form01")
	public String form() {
		
		return "form01";
	}
	
	
	@RequestMapping(value = "/form01Rs", method = RequestMethod.POST)
	public String formRs(@RequestParam String userName,
						@RequestParam String[] hobby,
						@RequestParam String searchType,
						@RequestParam String searchKey,						
						@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo
						
						) {
		logger.info("이름 {}",userName);
		logger.info("취미~ {}",(Object)hobby);
		logger.info("검색 {}, {}",searchType, searchKey);
		logger.info("히든으로 받았어요 {}",pageNo+1);
		return "home";
	}
	
	//요청주소 http://localhost:8081/app/paramTest?name=홍&pw=1234
	@RequestMapping("/paramTest1")
	public String paramTest1(@RequestParam Map<String, Object> paramMap){
		//Map참조변수명.put(Object키, Object밸류);
		
		
		return "home";
	}
	
	//요청주소 http://localhost:8081/app/paramTest?name=홍&pw=1234
	@RequestMapping("/paramTest2")
	public String paramTest2(@RequestParam List<String> nameList){
		//Map참조변수명.put(Object키, Object밸류);
		//
		
		return "home";
	}
	
	@RequestMapping("/modelTest1")
	public String modelTest1(HttpServletRequest request, 
							HttpSession session,
							Model model,
							@ModelAttribute("PARMOD1") TestDTO t
			) {
		t.setSearchKey("파라미터에 있는 서치타입");
		logger.info("modelTest1() 호출!");
		String testMsg = "-객체를 이용하고 있어욧!";
		request.setAttribute("REQMOD1", "request"+testMsg);
		session.setAttribute("SESMOD1", "session"+testMsg);
		model.addAttribute("MODMOD1", "model"+testMsg);
		List<String> hobbies = new LinkedList<String>();
		hobbies.add("춤추기");
		hobbies.add("신나게놀기");
		hobbies.add("클라이밍");
		TestDTO testDTO = new TestDTO("이름", hobbies, 2, "내용", "태풍");
		model.addAttribute("MODMOD2", testDTO);
		
		//속성명은 model값의 타입으로 사용되는 bean과 동일할 때에는 생략할 수 있다.
		model.addAttribute(testDTO);
		
		return "Test/modelView01";
	}
	
	@RequestMapping("/modelViewTest1")
	public ModelAndView modelViewTest1(ModelAndView mv) {
		// model과 view 작업 한번에
		// model 지정
		mv.addObject("MV1", "mv에 직접 넣은 String");
		// view 지정
		mv.setViewName("Test/modelView01");
		return mv;
	}
	
	@RequestMapping("/modelViewTest2")
	public ModelAndView modelviewTest2(ModelAndView mv) {
		mv.addObject("name", "mv에 직접 넣은 String2");
		
		mv.setViewName("redirect:/paramTest1");
		return mv;
	}
	
}
