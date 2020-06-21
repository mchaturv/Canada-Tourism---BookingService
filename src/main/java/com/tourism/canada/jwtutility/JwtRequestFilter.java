package com.tourism.canada.jwtutility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tourism.canada.exception.JwtRelatedException;
import com.tourism.canada.service.CustomerManagementService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private CustomerManagementService customerManagementService;
	
	@Value("${user.service.api.url}")
	String userServiceURI;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} 
			
			catch (IllegalArgumentException e) {
				logger.error("JWT Token not provided");
				throw new JwtRelatedException("Invalid JWT signature");
			} 
			
			
			catch (ExpiredJwtException e) {	
				logger.error("JWT Token has expired");
				throw new JwtRelatedException("JWT Token has expired");
			}
			
		} 
		
		else {
			logger.warn("JWT Token does not begin with Bearer String");
			//throw new JwtRelatedException("JWT Token not provided");
		}

		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			String uri = userServiceURI + "getuserdetails/{username}";

			Map<String, String> params = new HashMap<String, String>();
			params.put("username", username);

			RestTemplate restTemplate = new RestTemplate();
			//UserDetails userDetails=restTemplate.getForObject(uri, UserDetails.class, params);
			UserDetails userDetails = this.customerManagementService.loadUserByUsername(username);

			// if token is valid configure Spring Security to manually set
			// authentication
			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				//System.out.println(SecurityContextHolder.getContext().getAuthentication());
			}
		}
		chain.doFilter(request, response);
	}

}