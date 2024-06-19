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
	
	// 판매자 DB에 저장 => 성공 화면
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname, 
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl, // null이 가능하므로 
			@RequestParam(value = "temperature", defaultValue = "36.5") double temperature) { // 필수로 들어올 것이므로 => 소문자 double
		
		// db insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 성공 화면 이동		
		return "lesson04/afterAddSeller";
	}
	
	
	// 최근 가입한 판매자 1명 화면
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	// http://localhost:8080/lesson04/quiz01/seller-info-view?id=3
	@GetMapping("/seller-info-view")
	public String latestSellerView(
			@RequestParam(value = "id", required = false) Integer id, 
			Model model) {
		
		Seller seller = null;
		
		// 데이터 조회
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getLatestSellerById(id);
		}
			
		// Model에 데이터 담는다. => HTML에서 꺼내쓴다.
		model.addAttribute("seller",seller);
		model.addAttribute("title", "판매자 정보");
		
		// 화면 이동
		return "lesson04/latestSeller";
		}
}
