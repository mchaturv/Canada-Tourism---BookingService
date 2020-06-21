/**
 * 
 */
package com.tourism.canada;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tourism.canada.jwtutility.JwtAuthenticationEntryPoint;
import com.tourism.canada.jwtutility.JwtRequestFilter;
import com.tourism.canada.service.CustomerManagementService;

/**
 * @author Mayank
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityServerConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;


	@Autowired
	DataSource dataSource;

	AuthenticationFailureHandler failurehandler;
	AuthenticationSuccessHandler successhandler;
	
	@Autowired
	private CustomerManagementService customerManagementService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customerManagementService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Security Configuration for the Tourism application
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.authorizeRequests().antMatchers("**/api/beaches/**", "**/api/provinces/**", "**/api/nationalparks/**","**/api/cities/**",
				"/api/**/user/register", "/api/customer/authenticate", "/api/customer/verifytoken", "/api/customer/validate2FA/**","/api/bus/getavailibility").permitAll().and().authorizeRequests();

		
		http.cors().and().requestMatchers()
				.antMatchers("/api/bus/booking/**", "/api/ticket/**", "/api/twoFactor/**", "**/api/transaction/**",
						"/api/admin/**", "/api/customer/user/profile")
				.and().authorizeRequests().anyRequest().authenticated();

		http.formLogin().disable();
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
