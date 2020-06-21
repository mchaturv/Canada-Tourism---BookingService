package com.tourism.canada.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tourism.canada.dto.AvailibiltyDTO;
import com.tourism.canada.dto.BookingDTO;
import com.tourism.canada.entities.AvalibilityIdentity;
import com.tourism.canada.entities.Booking;
import com.tourism.canada.entities.Bus;
import com.tourism.canada.entities.BusAvailibilty;
import com.tourism.canada.entities.User;
import com.tourism.canada.exception.UserRelatedException;
import com.tourism.canada.service.AvailibilityService;
import com.tourism.canada.service.BookingService;
import net.minidev.json.JSONArray;

@RestController
@RequestMapping(value = "/api/bus")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Value("${user.service.api.url}")
	String userServiceURI;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private AvailibilityService availibiltyService;



	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/booking/{username}/findall")
	public Iterable<BookingDTO> getAllBookingAdmin(@PathVariable String username) {
		return bookingService.getAllBooking(username);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/booking/{username}/booking/{id}")
	public BookingDTO getBooking(@PathVariable Integer id) {
		BookingDTO responseBooking = new BookingDTO(bookingService.getBooking(id).get());
		return responseBooking;
	}

	@PreAuthorize("hasAnyRole('ROLE_USER')")
	@RequestMapping(value = "/booking/getbooking/{bookingid}")
	public BookingDTO getBookingbyId(@PathVariable Integer bookingid) {
		BookingDTO responseBooking = new BookingDTO(bookingService.getBooking(bookingid).get());
		return responseBooking;
	}

	@RequestMapping(value = "/getavailibility")
	public Iterable<AvailibiltyDTO> getAvailibilty(@RequestBody @Valid AvailibiltyDTO availibityDTO) {
		// DateTimeFormat format =(pattern = "yyyy-MM-dd") Date journeyDate
		return availibiltyService.getAllAvailibity(availibityDTO.getJourneyDate());

	}

	@PreAuthorize("hasAnyRole('ROLE_USER')")
	@RequestMapping(method = RequestMethod.POST, value = "/booking/makebooking")
	public BookingDTO addBooking(@RequestBody @Valid BookingDTO bookingDto) {
		String message;
		Booking response;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		BusAvailibilty availibilty = availibiltyService
				.getAvailibity(new AvalibilityIdentity(new Bus(bookingDto.getBusId()), bookingDto.getJourneyDate()));
		
		//To fetch User from user servcies
		
		String uri = userServiceURI + "getuser/{username}";

		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);

		RestTemplate restTemplate = new RestTemplate();
		User user=restTemplate.getForObject(uri, User.class, params);
		
		
		//User user = customerManagementService.getCustomerByEmail(username).get();
		int leftSeat = availibilty.getIdentityId().getBusId().getCapacity() - availibilty.getBookedSeat();
		if (leftSeat < bookingDto.getNoOfSeats()) {
			throw new UserRelatedException("Seats already sold out. Please refresh and try again");
		} else {
			bookingDto.setUserDetails(user);
			bookingDto.setBusType(availibilty.getIdentityId().getBusId().getBusType());
			bookingDto.setPaid(false);
			bookingDto.setBookingDate(new Date());
			response = bookingService.addBooking(new Booking(bookingDto));
			message = "Booking made Successfully";
		}
		if (response != null) {
			availibilty.setBookedSeat(availibilty.getBookedSeat() + bookingDto.getNoOfSeats());
			availibiltyService.updateAvailibity(availibilty);
		}
	
		return new BookingDTO(response);
	}

	@PreAuthorize("hasAnyRole('ROLE_USER')")
	@RequestMapping(value = "/booking/getbooking/all")
	public Iterable<BookingDTO> getAllBooking() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return bookingService.getAllBooking(username);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.PUT, value = "/booking/userDetails/{userDetailsId}/Booking/{id}")
	public void updateBooking(@RequestBody Booking Booking, @PathVariable Integer userDetailsId,
			@PathVariable String id) {
		Booking.setUserDetails(new User(userDetailsId));
		bookingService.updateBooking(Booking);
	}

	@PreAuthorize("hasAnyRole('ROLE_USER')")
	@RequestMapping(method = RequestMethod.POST, value = "/booking/delete/{id}")
	public void deleteBooking(@PathVariable Integer id) {
		bookingService.deleteBooking(id);
	}
	


}
