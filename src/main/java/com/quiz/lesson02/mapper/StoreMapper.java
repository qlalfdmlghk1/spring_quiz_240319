package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Store;

@Mapper
public interface StoreMapper {
	
	// input: (BO로부터 받아옴) X
	// output: (BO한테 전달) List<Store>
	public List<Store> selectStoreList(); // interface 이기 때문에 return 없음
}
