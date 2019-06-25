/**
 * 
 */
package com.sil.databasemodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="COUNTRY_MASTER")
public class CountryMaster {
	@Id
	@Column(name="COUNTRY_CODE")
	private Integer country_code;
	@Column(name="COUNTRY_NAME")
	private String country_name;
	@Column(name="DEL_FLAG")
	private String del_flag;
	/**
	 * @return the country_code
	 */
	public Integer getCountry_code() {
		return country_code;
	}
	/**
	 * @param country_code the country_code to set
	 */
	public void setCountry_code(Integer country_code) {
		this.country_code = country_code;
	}
	/**
	 * @return the country_name
	 */
	public String getCountry_name() {
		return country_name;
	}
	/**
	 * @param country_name the country_name to set
	 */
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	/**
	 * @return the del_flag
	 */
	public String getDel_flag() {
		return del_flag;
	}
	/**
	 * @param del_flag the del_flag to set
	 */
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}

}
