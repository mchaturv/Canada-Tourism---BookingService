/**
 * 
 */
package com.tourism.canada.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.canada.dao.AvailibiltyDao;
import com.tourism.canada.dto.AvailibiltyDTO;
import com.tourism.canada.entities.AvalibilityIdentity;
import com.tourism.canada.entities.BusAvailibilty;

/**
 * @author Mayank
 *
 */
@Service
public class AvailibilityService {

	@Autowired
	private AvailibiltyDao availableDao;

	public List<AvailibiltyDTO> getAllAvailibity(Date journeyDate) {
		

		
		Iterable<BusAvailibilty> availibility = availableDao.findByIdentityIdOnDate(journeyDate);
		List<AvailibiltyDTO> response = new ArrayList<AvailibiltyDTO>();
		for (BusAvailibilty avail : availibility) {
			avail.getIdentityId().setOnDate(journeyDate);
			response.add(new AvailibiltyDTO(avail));
		}
		return response;
	}

	public BusAvailibilty getAvailibity(AvalibilityIdentity id) {
		System.out.println(id.toString());

		return availableDao.findByIdentityId(id);
	}

	public BusAvailibilty updateAvailibity(BusAvailibilty busAvailibilty) {

		return availableDao.save(busAvailibilty);
	}

}
