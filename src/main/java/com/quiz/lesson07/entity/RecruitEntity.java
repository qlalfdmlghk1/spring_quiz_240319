package com.quiz.lesson07.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString  // 객체 출력시 필드 값들이 보인다.
@AllArgsConstructor // 모든 파라미터 있는 생성자
@NoArgsConstructor  // 파라미터 없는 생성자
@Builder(toBuilder = true) // setter를 대신해서 내용을 담음, toBuilder=true: 필드 수정 허용
@Getter
@Table(name = "recruit")
@Entity // 이 객체는 엔티디이다. BO-JPA-DB
public class RecruitEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert 시 방금 들어간 id 가져옴
	private int id;
	
	@Column(name = "companyId")
	private int companyId;
	
	private String position;
	
	private String responsibilities;
	
	private String qualification;
	
	private String type;
	
	private String region;
	
	private int salary;
	
	private LocalDate deadline;
	
	@CreationTimestamp // 시간값이 없어도 현재시간으로 들어감, 업데이트시 변경 X
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // 업데이트시 변경 O
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;

}
