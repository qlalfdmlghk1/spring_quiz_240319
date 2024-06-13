package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service  // spring bean으로 등록
public class StoreBO {
	
	@Autowired // Dependency Injection(DI): 의존성 주입 [면접 빈출!!]
	private StoreMapper storeMapper;
	
	// input: X (컨트롤러로부터 들어온 요청) 
	// output: List<Store> (Repository한테 받은 것을 컨트롤러한테 줌)
	public List<Store> getStoreList() {
		return storeMapper.selectStoreList(); // 컨트롤러한테 전달
	}
}
