package com.tourism.canada.service;

import java.time.LocalDate;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.tourism.canada.dao.AvailibiltyDao;
import com.tourism.canada.dao.BusDao;
import com.tourism.canada.entities.AvalibilityIdentity;
import com.tourism.canada.entities.Bus;
import com.tourism.canada.entities.BusAvailibilty;


@Component
public class LoaderService implements ApplicationListener<ApplicationReadyEvent>{





	
	@Autowired
	private AvailibiltyDao availibilitydao;

	
	@Autowired
	private BusDao busDao;

	
	

	public void loadData() {
		
		loadBus();
		loadAvailibility();
		

	}
	
	public void loadBus()
	{
		
		Bus bus1 = new Bus(1, "Sleeper Luxury", 54);
		bus1.setAmount(200);
		busDao.save(bus1);
		Bus bus2 = new Bus(2, "Semi-Sleeper luxury", 80);
		bus2.setAmount(160);
		busDao.save(bus2);
		Bus bus3 = new Bus(3, "Semi-Sleeper supreme", 80);
		bus3.setAmount(140);
		busDao.save(bus3);
		
	}


	
	public void loadAvailibility()
	{
		//Date date = new Date();
		//Calendar c = Calendar.getInstance();
		
		//ZoneId defaultZoneId = ZoneId.systemDefault();
		
		for(int i =1 ;i<30;i++)
		{
			
			
			if(i<5)
			{
				LocalDate localDate =  LocalDate.now().plusDays(i);
				
				Date date = Date.valueOf(localDate);
				
				AvalibilityIdentity identity1 = new AvalibilityIdentity(new Bus(1), date);
				BusAvailibilty availibility1 = new BusAvailibilty(identity1, 40);
				availibilitydao.save(availibility1);
				AvalibilityIdentity identity2 = new AvalibilityIdentity(new Bus(2), date);
				BusAvailibilty availibility2 = new BusAvailibilty(identity2, 76);
				availibilitydao.save(availibility2);
				AvalibilityIdentity identity3 = new AvalibilityIdentity(new Bus(3), date);
				BusAvailibilty availibility3 = new BusAvailibilty(identity3, 74);
				availibilitydao.save(availibility3);
			}
			else {
				LocalDate localDate =  LocalDate.now().plusDays(i);
				Date date = Date.valueOf(localDate);
				
				AvalibilityIdentity identity1 = new AvalibilityIdentity(new Bus(1), date);
				BusAvailibilty availibility1 = new BusAvailibilty(identity1, 0);
				availibilitydao.save(availibility1);
				AvalibilityIdentity identity2 = new AvalibilityIdentity(new Bus(2), date);
				BusAvailibilty availibility2 = new BusAvailibilty(identity2, 0);
				availibilitydao.save(availibility2);
				AvalibilityIdentity identity3 = new AvalibilityIdentity(new Bus(3), date);
				BusAvailibilty availibility3 = new BusAvailibilty(identity3, 0);
				availibilitydao.save(availibility3);
			}
		}
		
	}


	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		loadData();
	}
}
