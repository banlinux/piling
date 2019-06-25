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
@Table(name="STATE_MASTER")
public class StateMaster implements Serializable{
	@Id
	@Column(name="STATE_CODE")
	private Integer state_code;
	@Id
	@Column(name="REGION_CODE")
	private Integer region_code;
	@Id
	@Column(name="COUNTRY_CODE")
	private Integer country_code;
	@Column(name="STATE_NAME")
	private String state_name;
	@Column(name="DEL_FLAG")
	private String del_flag;
	/**
	 * @return the state_code
	 */
	public Integer getState_code() {
		return state_code;
	}
	/**
	 * @param state_code the state_code to set
	 */
	public void setState_code(Integer state_code) {
		this.state_code = state_code;
	}
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
	 * @return the state_name
	 */
	public String getState_name() {
		return state_name;
	}
	/**
	 * @param state_name the state_name to set
	 */
	public void setState_name(String state_name) {
		this.state_name = state_name;
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
