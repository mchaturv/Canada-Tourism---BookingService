package com.tourism.canada.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tourism.canada.dao.UserDao;
import com.tourism.canada.entities.User;
import com.tourism.canada.exception.UserRelatedException;

@Service
public class CustomerManagementService implements UserDetailsService {

	@Autowired
	private UserDao customerManagementDao;

	@Transactional
	public User addUser(User customer) {

		User user;
		customer.setCustomerPassword(new BCryptPasswordEncoder().encode(customer.getCustomerPassword()));
		if (!customerManagementDao.findByCustomerEmail(customer.getCustomerEmail()).isPresent()) {
			user = customerManagementDao.save(customer);
		} else
			throw new UserRelatedException(customer.getCustomerEmail() + " already in use");

		return user;
	}

	public Optional<User> getCustomerById(Integer customerId) {
		return customerManagementDao.findById(customerId);
	}

	public Optional<User> getCustomerByEmail(String email) {
		return customerManagementDao.findByCustomerEmail(email);
	}

	public Iterable<User> getAllCustomers() {
		return customerManagementDao.findAll();
	}

	public User updateCustomer(User customer) {
		return customerManagementDao.save(customer);
	}

	public void deleteCustomer(Integer customerId) {
		customerManagementDao.deleteById(customerId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = customerManagementDao.findByCustomerEmail(username)
				.orElseThrow(() -> new UserRelatedException("User does not exists with username: " + username));
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getCustomerType().getRole());

		return new org.springframework.security.core.userdetails.User(user.getCustomerEmail(),
				user.getCustomerPassword(), Arrays.asList(authority));
	}


	public String getUserFullName(String username) {
		User user = customerManagementDao.findByCustomerEmail(username)
				.orElseThrow(() -> new UserRelatedException("User does not exists with username: " + username));
		return user.getCustomerFname() + " " + user.getCustomerLname();
	}

	public Map<UserDetails, Boolean> loadUserByUsernames(String username) throws UsernameNotFoundException {

		User user = customerManagementDao.findByCustomerEmail(username)
				.orElseThrow(() -> new UserRelatedException("User does not exists with username: " + username));
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getCustomerType().getRole());

		Map<UserDetails, Boolean> response = new HashMap<UserDetails, Boolean>();

		UserDetails details = new org.springframework.security.core.userdetails.User(user.getCustomerEmail(),
				user.getCustomerPassword(), Arrays.asList(authority));
		response.put(details, user.isIs2faEnabled());

		return response;
	}

	@Transactional
	public User updateUser(User userforUpdate, String currentuser) {
		// TODO Auto-generated method stub
		User updateduser;
		if (userforUpdate.getCustomerEmail().contentEquals(currentuser)
				|| (!userforUpdate.getCustomerEmail().contentEquals(currentuser)
						&& !customerManagementDao.findByCustomerEmail(userforUpdate.getCustomerEmail()).isPresent())) {
			Optional<User> tempUser = customerManagementDao.findByCustomerEmail(currentuser);
			User existingUser = tempUser.get();
			userforUpdate.setCustomerId(existingUser.getCustomerId());
			userforUpdate.setCustomerType(existingUser.getCustomerType());
			userforUpdate.setCustomerPassword(new BCryptPasswordEncoder().encode(userforUpdate.getCustomerPassword()));
			updateduser = customerManagementDao.save(userforUpdate);
		} else
			throw new UserRelatedException(userforUpdate.getCustomerEmail() + " already in use");

		return updateduser;
	}

}
