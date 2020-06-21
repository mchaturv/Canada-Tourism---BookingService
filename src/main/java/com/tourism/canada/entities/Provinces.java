package com.tourism.canada.entities;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "province")
public class Provinces {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "province_id")
	private Integer provinceId;

	@Column(name = "province_name", unique = true)
	private String provinceName;

	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	private Set<City> listCities;

	public Provinces(Integer provinceId, String provinceName) {
		super();
		this.provinceId = provinceId;
		this.provinceName = provinceName;
	}

	/**
	 * @param provinceId
	 */
	public Provinces(Integer provinceId) {
		super();
		this.provinceId = provinceId;
	}

	public Provinces() {

	}

	/**
	 * @return the provinceId
	 */
	public Integer getProvinceId() {
		return provinceId;
	}

	/**
	 * @param provinceId the provinceId to set
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * @return the provinceName
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * @param provinceName the provinceName to set
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	/**
	 * @return the listCities
	 */
	public Set<City> getListCities() {
		return listCities;
	}

	/**
	 * @param listCities the listCities to set
	 */
	public void setListCities(Set<City> listCities) {
		this.listCities = listCities;
	}

	@Override
	public String toString() {
		return "Provinces [provinceId=" + provinceId + ", provinceName=" + provinceName + ", listCities=" + listCities
				+ "]";
	}

}
