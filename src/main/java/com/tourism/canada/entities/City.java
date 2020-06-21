package com.tourism.canada.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "cities")
public class City {

	@Id
	@Column(name = "city_id")
	int cityId;

	@Column(name = "city_name")
	String cityName;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "province")
	private Provinces province;

	/**
	 * @return the cityId
	 */
	public int getCityId() {
		return cityId;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @param cityId
	 * @param cityName
	 */
	public City(int cityId, String cityName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
	}

	/**
	 * @param cityId
	 */
	public City(int cityId) {
		super();
		this.cityId = cityId;
	}

	/**
	 * 
	 */
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the province
	 */
	public Provinces getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(Provinces province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + "]";
	}

}
