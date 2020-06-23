package com.tourism.canada.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.canada.dao.BookingDao;
import com.tourism.canada.dao.BusDao;
import com.tourism.canada.dto.BookingDTO;
import com.tourism.canada.entities.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;

	@Autowired
	private BusDao busDao;

	@Transactional
	public Iterable<BookingDTO> getAllBooking(String username) {
		ArrayList<Booking> bookingList = new ArrayList<Booking>();
		ArrayList<BookingDTO> bookingDTOList = new ArrayList<BookingDTO>();
		bookingList = bookingDao.findByUserDetailsCustomerEmail(username);
		bookingDTOList = convertToDTO(bookingList);
		return bookingDTOList;
	}

	public Optional<Booking> getBooking(Integer bookingId) {
		return bookingDao.findById(bookingId);
	}

	public void deleteBooking(Integer bookingId) {
		bookingDao.deleteById(bookingId);
	}

	public Booking updateBooking(Booking booking) {
		Booking responseBooking = bookingDao.save(booking);
		return responseBooking;
	}

	@Transactional
	public Booking addBooking(Booking booking) {

		double amount = 0;
		System.out.println(booking.getBookingDate()+","+booking.getJourneyDate());
		amount = booking.getNoOfSeats() * (busDao.findById(booking.getBusId().getBusId()).get().getAmount());
		booking.setBookingAmount(amount);
		booking.setPaid(false);
		Booking responseBooking = bookingDao.save(booking);
	
			responseBooking.setBookingDate(booking.getBookingDate());
			responseBooking.setJourneyDate(booking.getJourneyDate());
		
		return responseBooking;
	}

	public ArrayList<BookingDTO> convertToDTO(ArrayList<Booking> bookingList) {
		ArrayList<BookingDTO> bookingDTOList = new ArrayList<BookingDTO>();
		for (Booking b : bookingList) {
			bookingDTOList.add(new BookingDTO(b));
		}
		Collections.reverse(bookingDTOList);
		return bookingDTOList;
	}
}
