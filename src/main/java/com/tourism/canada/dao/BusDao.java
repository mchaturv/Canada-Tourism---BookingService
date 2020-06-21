package com.tourism.canada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.canada.entities.Bus;

public interface BusDao extends JpaRepository<Bus, Integer> {

}
