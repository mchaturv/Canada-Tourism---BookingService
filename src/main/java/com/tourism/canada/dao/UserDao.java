package com.tourism.canada.dao;



import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tourism.canada.entities.User;

public interface UserDao extends CrudRepository<User, Integer> {

	@Transactional(readOnly = true)
	Optional<User> findByCustomerEmail(String customerEmail);
}
