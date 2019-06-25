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
@Table(name="DISTRICT_MASTER")
public class DistrictMaster implements Serializable {
	@Id
	@Column(name="DISTRICT_CODE")
	private Integer district_code;	
	@Id
	@Column(name="STATE_CODE")
	private Integer state_code;
	@Column(name="DISTRICT_NAME")
	private String district_name;
	@Column(name="DEL_FLAG")
	private String del_flag;
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
	 * @return the district_name
	 */
	public String getDistrict_name() {
		return district_name;
	}
	/**
	 * @param district_name the district_name to set
	 */
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
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
