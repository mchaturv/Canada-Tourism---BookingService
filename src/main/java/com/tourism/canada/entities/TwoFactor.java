package com.tourism.canada.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Component;

/**
 * Author: Mayank
 *
 */
@Component
@Entity
@Table(name = "twofactor")
public class TwoFactor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "two_factor_id")
	private Integer twoFactorId;

	@ManyToOne()
	private User userDetails;

	@Column(name = "code")
	private String code;

	@Column(name = "exp_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expireTime;

	@Column(name = "jwttoken")
	private String jwtToken;

	/**
	 * 
	 */
	public TwoFactor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param twoFactorId
	 * @param userDetails
	 * @param code
	 * @param expireTime
	 * @param jwtToken
	 */
	public TwoFactor(User userDetails, String code, Date expireTime, String jwtToken) {
		super();

		this.userDetails = userDetails;
		this.code = code;
		this.expireTime = expireTime;
		this.jwtToken = jwtToken;
	}

	/**
	 * @param twoFactorId
	 * @param userDetails
	 * @param code
	 * @param expireTime
	 */
	public TwoFactor(Integer twoFactorId, User userDetails, String code, Date expireTime) {
		super();
		this.twoFactorId = twoFactorId;
		this.userDetails = userDetails;
		this.code = code;
		this.expireTime = expireTime;
	}

	/**
	 * @param userDetails
	 * @param code
	 * @param date
	 */
	public TwoFactor(User userDetails, String code, java.util.Date date) {
		super();
		this.userDetails = userDetails;
		this.code = code;
		this.expireTime = date;
	}

	/**
	 * @return the twoFactorId
	 */
	public Integer getTwoFactorId() {
		return twoFactorId;
	}

	/**
	 * @param twoFactorId the twoFactorId to set
	 */
	public void setTwoFactorId(Integer twoFactorId) {
		this.twoFactorId = twoFactorId;
	}

	/**
	 * @return the userDetails
	 */
	public User getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the expireTime
	 */
	public Date getExpireTime() {
		return expireTime;
	}

	/**
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * @return the jwtToken
	 */
	public String getJwtToken() {
		return jwtToken;
	}

	/**
	 * @param jwtToken the jwtToken to set
	 */
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	@Override
	public String toString() {
		return "TwoFactor [twoFactorId=" + twoFactorId + ", userDetails=" + userDetails + ", code=" + code
				+ ", expireTime=" + expireTime + ", jwtToken=" + jwtToken + "]";
	}

}
