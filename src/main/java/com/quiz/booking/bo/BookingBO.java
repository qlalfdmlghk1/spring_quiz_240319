package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	// input: X
	// output: List<Booking>
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList(); // 컨트롤러한테 전달
	}
	
	// input: id
	// output: int
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	
	public void addBooking(String name, LocalDate date, 
			int day, int headcount, String phoneNumber) {
		
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}

	// input: name, phoneNumber
	// output: List<Booking>
	public List<Booking> checkBookingListByNamePhoneNumber(String name, String phoneNumber) {
		return bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber); // 컨트롤러한테 전달
	}
}