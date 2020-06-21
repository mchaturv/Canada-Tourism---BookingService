package com.tourism.canada.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="customer")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_id")
	private Integer customerId;
	
	@JsonProperty(value ="customerFname")
	@NotNull(message ="customer First Name is Required")
	@NotEmpty(message ="customer First Name is Required")
	@Column(name="customer_fname",length=60,nullable=false)
	private String customerFname;
	
	@JsonProperty(value ="customerLname")
	@NotNull(message ="Customer Last Name is Required")
	@NotEmpty(message ="Customer Last Name is Required")
	@Column(name="customer_lname",length=60,nullable=false)
	private String customerLname;
	
	@JsonProperty(value ="customerNum")
	@NotNull(message ="Customer Phone Number is Required")
	@NotEmpty(message ="Customer Phone Number is Required")
	@Column(name="customer_num")
	private String customerNum;
	
	@Email
	@JsonProperty(value ="customerEmail")
	@NotNull(message ="Customer Email is Required")
	@NotEmpty(message ="Customer Email is Required")
	@Column(name="customer_email",unique=true)
	private String customerEmail;
	
	@JsonProperty(value ="customerPassword")
	@NotNull(message ="Customer Password is Required")
	@NotEmpty(message ="Customer Password is Required")
	@Column(name="customer_password",length=68, nullable = false)
	private String customerPassword;
	
	@JsonIgnore
	@ManyToOne(optional = false)
    @JoinColumn(name="roleid")
	private Role customerType;
	
	
	@Column(name="is2faEnabled")
	private boolean is2faEnabled;
	
	
	
	public User() {

	}
	
	

	

	/**
	 * @param customerId
	 */
	public User(Integer customerId) {
		super();
		this.customerId = customerId;
	}





	

	/**
	 * @param customerId
	 * @param customerFname
	 * @param customerLname
	 * @param customerNum
	 * @param customerEmail
	 * @param customerPassword
	 * @param customerType
	 * @param is2faEnabled
	 */
	public User(Integer customerId,
			@NotNull(message = "customer First Name is Required") @NotEmpty(message = "customer First Name is Required") String customerFname,
			@NotNull(message = "Customer Last Name is Required") @NotEmpty(message = "Customer Last Name is Required") String customerLname,
			@NotNull(message = "Customer Phone Number is Required") @NotEmpty(message = "Customer Phone Number is Required") String customerNum,
			@Email @NotNull(message = "Customer Email is Required") @NotEmpty(message = "Customer Email is Required") String customerEmail,
			@NotNull(message = "Customer Password is Required") @NotEmpty(message = "Customer Password is Required") String customerPassword,
			Role customerType, boolean is2faEnabled) {
		super();
		this.customerId = customerId;
		this.customerFname = customerFname;
		this.customerLname = customerLname;
		this.customerNum = customerNum;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerType = customerType;
		this.is2faEnabled = is2faEnabled;
	}





	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the customerFname
	 */
	public String getCustomerFname() {
		return customerFname;
	}

	/**
	 * @param customerFname the customerFname to set
	 */
	public void setCustomerFname(String customerFname) {
		this.customerFname = customerFname;
	}

	/**
	 * @return the customerLname
	 */
	public String getCustomerLname() {
		return customerLname;
	}

	/**
	 * @param customerLname the customerLname to set
	 */
	public void setCustomerLname(String customerLname) {
		this.customerLname = customerLname;
	}

	/**
	 * @return the customerNum
	 */
	public String getCustomerNum() {
		return customerNum;
	}

	/**
	 * @param customerNum the customerNum to set
	 */
	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}

	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the customerPassword
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}

	/**
	 * @param customerPassword the customerPassword to set
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	/**
	 * @return the customerType
	 */
	public Role getCustomerType() {
		return customerType;
	}

	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(Role customerType) {
		this.customerType = customerType;
	}
	
	

	/**
	 * @return the is2faEnabled
	 */
	public boolean isIs2faEnabled() {
		return is2faEnabled;
	}





	/**
	 * @param is2faEnabled the is2faEnabled to set
	 */
	public void setIs2faEnabled(boolean is2faEnabled) {
		this.is2faEnabled = is2faEnabled;
	}





	@Override
	public String toString() {
		return "User [customerId=" + customerId + ", customerFname=" + customerFname + ", customerLname="
				+ customerLname + ", customerNum=" + customerNum + ", customerEmail=" + customerEmail
				+ ", customerPassword=" + customerPassword + ", customerType=" + customerType + ", is2faEnabled="
				+ is2faEnabled + "]";
	}





	
	
	
	
	

	
}
