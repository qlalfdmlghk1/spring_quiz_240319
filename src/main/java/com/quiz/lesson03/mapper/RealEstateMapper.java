package com.quiz.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	public RealEstate selectRealEstateById(int id);
	
	public RealEstate selectRealEstateListByRentPrice(int rentPrice);
	
	public RealEstate selectRealEstateListByAreaAndPrice(int area, int price);
}
