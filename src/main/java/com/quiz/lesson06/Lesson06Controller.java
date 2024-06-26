package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	// http://localhost:8080/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// AJAX가 하는 요청 -> AJAX가 하는 응답값은 반드시 String 이다. 
	@ResponseBody
	@PostMapping("/add-user")
	public String addUser(
			@RequestParam("title") String title, 
			@RequestParam("address") String address,
			) {
		
		// db insert 
		
		// 응답값 - response body에 "성공" 들어감
		return "성공";
	}
	
	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmarkView() {
		return "lesson06/afterAddBookmark";
	}
}
