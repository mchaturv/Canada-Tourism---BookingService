package com.tourism.canada.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourism.canada.entities.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {

	@Query("Select c from City c")
	ArrayList<City> getCities();
	
	@Query("Select c from City c where c.province.provinceId =:province")
	ArrayList<City> getCitiesOfProvince(@Param("province") int provinceId );
}
