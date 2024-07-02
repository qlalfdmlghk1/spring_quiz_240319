package com.quiz.booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingBO bookingBO;
	
	// 예약 목록 화면
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		
		// DB Select => List<Booking>
		List<Booking> bookingList = bookingBO.getBookingList();
		
		// Model에 담기
		model.addAttribute("bookingList", bookingList);
		
		// return
		return "booking/bookingList";
	}
	
	// AJAX 요청 - id로 삭제
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// db delete
		int rowCount = bookingBO.deleteBookingById(id);
		
		// 응답값 json
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 항목이 존재하지 않습니다.");
			
		}
		return result;
	}

	
	// 예약하기 페이지
	@GetMapping("/add-booking-view")
	public String addBookingView() {
		return "booking/makeBooking";
	}
	
	// AJAX가 하는 요청 -> AJAX가 하는 응답값은 반드시 String 이다. 
	// 즐겨찾기 추가 로직
	@ResponseBody
	@PostMapping("/make-booking-view")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name, 
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// db insert 
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// 성공 JSON
		// {"code":200, "result":"성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result; // JSON String
	}
	
}
