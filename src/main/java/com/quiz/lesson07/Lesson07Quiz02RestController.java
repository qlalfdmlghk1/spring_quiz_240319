package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public List<RecruitEntity> select1() {
		// 1) id가 8인 공고를 조회
		return recruitRepository.findById(8);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> select2(
			@RequestParam("companyId") int companyId) {
		// 2) 전달 받은 company id로 해당하는 회사의 공고를 조회
		return recruitRepository.findByCompanyId(companyId);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> select3() {
		// 3) 웹 back-end 개발자 이고 정규직인 공고를 조회
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	@GetMapping("/4")
	public List<RecruitEntity> select4() {
		// 4) 정규직이거나 연봉이 9000 이상인 공고를 조회
		return recruitRepository.findByTypeOrSalary("정규직", 9000);
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> select5() {
		// 5) 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회
		return recruitRepository.findAllByOrderBySalaryDesc();
	}
	
	@GetMapping("/6")
	public List<RecruitEntity> select6() {
		// 5) 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회
		return recruitRepository.findBySalaryBetween(7000, 8500);
	}
}
