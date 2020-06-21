package com.tourism.canada.jwtutility;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private boolean isVerified;
	private String message;
	private final String token;
	private String userFullname;

	public JwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

	/**
	 * @return the isVerified
	 */
	public boolean isVerified() {
		return isVerified;
	}

	/**
	 * @param isVerified the isVerified to set
	 */
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return the userFullname
	 */
	public String getUserFullname() {
		return userFullname;
	}

	/**
	 * @param userFullname the userFullname to set
	 */
	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}

	
	
	
}
