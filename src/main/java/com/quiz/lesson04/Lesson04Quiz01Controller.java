package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
//
	@Autowired
	private SellerBO sellerBO;
	
	// 판매자 추가 화면
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@RequestMapping(path="/add-seller-view", method = RequestMethod.GET)
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname, 
			@RequestParam("profileImageUrl") String profileImageUrl, 
			@RequestParam("temperature") Double temperature) {
		
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 결과 화면
		return "lesson04/afterAddSeller";
	}
	
	
	// 최근 가입자 뿌리는 화면
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	@GetMapping("/seller-info-view")
	public String latestSellerView(Model model) {
		// DB select (최신 가입자 1명)
		Seller seller = sellerBO.getLatestSeller();
		
		// Model 주머니에 담는다. => HTML에서 꺼내쓴다.
		model.addAttribute("result",seller);
		model.addAttribute("title", "판매자 정보!");
		
		// 화면 이동
		return "lesson04/latestSeller";
	}
	
}
