package com.tourism.canada.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.tourism.canada.entities.Booking;

public interface BookingDao extends CrudRepository<Booking, Integer> {
	public ArrayList<Booking> findByUserDetailsCustomerEmail(String email);
}
