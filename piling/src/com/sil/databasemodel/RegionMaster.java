/**
 * 
 */
package com.sil.databasemodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sumanta roy
 *
 */
@Entity
@Table(name="REGION_MASTER")
public class RegionMaster implements Serializable{
	
	@Id
	@Column(name="REGION_CODE")
	private Integer region_code;
	@Id
	@Column(name="COUNTRY_CODE")
	private Integer country_code;
	@Column(name="REGION_NAME")
	private String region_name;
	@Column(name="DEL_FLAG")
	private String del_flag;
	/**
	 * @return the region_code
	 */
	public Integer getRegion_code() {
		return region_code;
	}
	/**
	 * @param region_code the region_code to set
	 */
	public void setRegion_code(Integer region_code) {
		this.region_code = region_code;
	}
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
	 * @return the region_name
	 */
	public String getRegion_name() {
		return region_name;
	}
	/**
	 * @param region_name the region_name to set
	 */
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
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
