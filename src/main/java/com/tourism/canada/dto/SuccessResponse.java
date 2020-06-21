package com.tourism.canada.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author Mayank
 *
 */
@Component
public class SuccessResponse implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private Object object;
	
	
	public SuccessResponse() {
		
	}


	/**
	 * @param status
	 * @param object
	 */
	public SuccessResponse(String status, Object object) {
		super();
		this.status = status;
		this.object = object;
	}
	
	/**
	 * @param status
	 */
	public SuccessResponse(String status) {
		super();
		this.status = status;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}


	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}


	@Override
	public String toString() {
		return "SuccessResponse [status=" + status + ", object=" + object + "]";
	}


	

	
}
