package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	@Autowired
	public BookmarkBO bookmarkBO;
	
	// http://localhost:8080/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// AJAX가 하는 요청 -> AJAX가 하는 응답값은 반드시 String 이다. 
	@ResponseBody
	@PostMapping("/add-bookmark")
	public String addBookmark(
			@RequestParam("title") String title, 
			@RequestParam("address") String address,
			HttpServletResponse response) {
		
		// db insert 
		bookmarkBO.addBookmark(title, address);
		
		// 응답값 - response body에 "성공" 들어감
		return "성공";
	}
	
	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmarkView(Model model) {
		// select db
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		
		// model 담기
		model.addAttribute("bookmarkList",bookmarkList);
				
		return "redirect:/lesson06/afterAddBookmark";
	}
}
