package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
	@Autowired
	private RealtorBO realtorBO;
	
	// 중개사 가입 화면
	// http://localhost:8080/lesson04/quiz02/add-realtor
	@GetMapping("/add-realtor")
	public String addRealtorView() { // 처음에 들어가자마자 나오는 화면인 경우 이름끝(View)
		return "lesson04/addRealtor";
	}
	
	// DB Insert => 방금 가입된 학생 select => 화면
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		// DB Insert 
		realtorBO.addRealtor(realtor);
			
		// DB Select => 방금 가입된 중개사
		// int id = realtor.getId();
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());
			
		// Model에 데이터를 담는다.
		model.addAttribute("realtor",latestRealtor);
			
		// 화면 이동
		return "lesson04/afterAddRealtor";
		}
	}
