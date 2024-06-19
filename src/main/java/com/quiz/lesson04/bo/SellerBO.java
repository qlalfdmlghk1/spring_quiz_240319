package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {

	@Autowired
	private SellerMapper sellerMapper;
	
	// input: 파라미터 3개
	// output: X
	public void addSeller(String nickname, String profileImageUrl, double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	// input: X
	// output: Seller
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}

	// input: X
	// output: Seller(채워져있거나 null)
	public Seller getLatestSellerById(int id) {
		return sellerMapper.selectLatestSellerById(id);
	}
	
	
}
