package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz01")
@RestController  // 이걸 안했더니 404 오류가 반복해서 발생함
public class Lesson03Quiz01RestController {
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/1")
	public RealEstate quiz01_1(
			@RequestParam(value = "id") int id
			) {
		return realEstateBO.getRealEstateById(id);
	}
	
	
	// input(request): rent_price(필수)
	// output(response): List<RealEstate>
	//  /lesson03/quiz01/2?rent_price=90
	@RequestMapping("/2")
	public RealEstate quiz01_2(
			@RequestParam("rent_price") int rentPrice
			) {
		return realEstateBO.getRealEstateListByRentPrice(rentPrice);
	}
	
	@RequestMapping("/3")
	public RealEstate quiz01_3(
			@RequestParam("area") int area,
			@RequestParam("price") int price
			) {
		return realEstateBO.getRealEstateListByAreaAndPrice(area, price);
	}
}
