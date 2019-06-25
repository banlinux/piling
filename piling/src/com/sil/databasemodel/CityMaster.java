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
@Table(name="CITY_MASTER")
public class CityMaster implements Serializable{
	@Id
	@Column(name="CITY_CODE")
	private Integer city_code;
	@Id
	@Column(name="DISTRICT_CODE")
	private Integer district_code;
	@Column(name="CITY_NAME")
	private String city_name;
	@Column(name="DEL_FLAG")
	private String del_flag;
	
	
	/**
	 * @return the city_name
	 */
	public String getCity_name() {
		return city_name;
	}
	/**
	 * @param city_name the city_name to set
	 */
	public void setCity_name(String city_name) {
		this.city_name = city_name;
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
	/**
	 * @return the city_code
	 */
	public Integer getCity_code() {
		return city_code;
	}
	/**
	 * @param city_code the city_code to set
	 */
	public void setCity_code(Integer city_code) {
		this.city_code = city_code;
	}
	/**
	 * @return the district_code
	 */
	public Integer getDistrict_code() {
		return district_code;
	}
	/**
	 * @param district_code the district_code to set
	 */
	public void setDistrict_code(Integer district_code) {
		this.district_code = district_code;
	}

}
