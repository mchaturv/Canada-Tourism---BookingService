package com.tourism.canada.dao;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourism.canada.entities.AvalibilityIdentity;
import com.tourism.canada.entities.BusAvailibilty;

@Repository
public interface AvailibiltyDao extends JpaRepository<BusAvailibilty, AvalibilityIdentity> {
	
	@Query("select i from BusAvailibilty i  where i.identityId.onDate = :journeyDate")
	public Iterable<BusAvailibilty> findByIdentityIdOnDate(@Param("journeyDate") Date journeyDate);
	
	public BusAvailibilty findByIdentityId(AvalibilityIdentity id);
	
}

