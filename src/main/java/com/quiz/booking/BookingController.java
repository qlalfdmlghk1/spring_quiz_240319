package com.quiz.booking;

import java.time.LocalDate;
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
	
	// AJAX - 예약 id로 삭제
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// db delete
		int rowCount = bookingBO.deleteBookingById(id) ;
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 데이터가 없습니다.");
		}
		
		return result;
	}
	
	
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
	
	// 예약하기 화면
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	// AJAX 요청 - add 예약
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("date") LocalDate date, // String도 가능.
			@RequestParam("day") int day, // int -> null x
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// db insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code",200);
		result.put("result","성공");
		return result;
	}
	
	// 예약확인 화면
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	// AJAX 요청 - select 예약 내역 확인
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
		@RequestParam("name") String name,
		@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB Select
		Map<String, Object> result = new HashMap<>();
		
		// 응답값 => JSON (Model 없음)
		return result;
	}
}
