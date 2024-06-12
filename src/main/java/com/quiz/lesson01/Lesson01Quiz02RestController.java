package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController  //  @Controller + @ResponseBody, spring bean
public class Lesson01Quiz02RestController {
	
	// http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {  // List 한칸 안에 담기는 형태 명시
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>(); // 비어있는 리스트 생성
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rate", 15);
		map.put("director", "봉준호");
		map.put("time", 131);
		map.put("title", "기생충");
		lists.add(map);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("rate", 0);
		map2.put("director", "로베르토 베니니");
		map2.put("time", 116);
		map2.put("title", "인생은 아름다워");
		lists.add(map2);
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("rate", 12);
		map3.put("director", "크리소토퍼 놀란");
		map3.put("time", 147);
		map3.put("title", "인셉션");
		lists.add(map3);
		
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("rate", 19);
		map4.put("director", "윤종빈");
		map4.put("time", 133);
		map4.put("title", "범죄와의 전쟁");
		lists.add(map4);	
		
		Map<String, Object> map5 = new HashMap<String, Object>();
		map4.put("rate", 15);
		map4.put("director", "프란시스 로렌스");
		map4.put("time", 137);
		map4.put("title", "헝거게임");
		lists.add(map4);	
		
		return lists;  // return 타입이 List<Map<String, Object>> 와 같아야 함.
		}
	
	
	// http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Board> quiz02_2() {
		// 중요!!
		// @ResponseBody + return String => HttpMessageConverter => HTML
		// @ResponseBody + return 객체(Map, 객체, List) => HttpMessageConverter => jackson lib => JSON 
		
		List<Board> list = new ArrayList<>();
		
		Board board = new Board();
		board.setTitle("안녕하세요 가입인사 드립니다.");
		board.setUser("marobina");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");
		list.add(board);
		
		board = new Board();
		board.setTitle("안녕하세요 가입인사 드립니다.");
		board.setUser("marobina");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");
		list.add(board);
		
		board = new Board();
		board.setTitle("헐 대박");
		board.setUser("bady");
		board.setContent("...");
		list.add(board);
		
		return list;
	}
	
	// http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<Board> quiz02_3() {
		Board board = new Board();
		board.setTitle("안녕하세요 가입인사 드립니다.");
		board.setUser("marobina");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");
		
		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}