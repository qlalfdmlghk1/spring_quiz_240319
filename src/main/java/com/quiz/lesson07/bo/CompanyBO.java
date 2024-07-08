package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	// input: 4개 파라미터
	// output: CompanyEntity
	public CompanyEntity addCompany(String name, String business, 
			String scale, int headcount) {
		
		return companyRepository.save(
				CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build());
		
	}
	
	// Update
	// input: id, scale, headcount
	// output: CompanyEntity or null
	public CompanyEntity updateCompanyById(int companyId, String scale, int headcount) {
		// 기존 데이터 조회 => CompanyEntity 가져옴
		CompanyEntity company = companyRepository.findById(companyId).orElse(null);
		
		// 엔티티의 데이터 값을 변경해놓는다.
		if (company != null) {
			company = company.toBuilder() // toBuilder는 기존 필드값은 유지하고 일부만 변경
				.scale(scale)
				.headcount(headcount)
				.build();  // 꼭 객체에 다시 저장!
			
			// update
			// save 요청
			company = companyRepository.save(company);
		}
		return company;
	}
	
	
	// DELETE
	// input: id
	// output: X
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}
}
