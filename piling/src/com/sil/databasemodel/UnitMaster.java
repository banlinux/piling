/**
 * 
 */
package com.sil.databasemodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="UNIT_MASTER")
public class UnitMaster {
	@Id
	@Column(name="UNIT_CODE")
	private Integer unit_code;
	@Column(name="UNIT_NAME")
	private String unit_name;
	@Column(name="DEL_FLAG")
	private String del_flag;
	/**
	 * @return the unit_code
	 */
	public Integer getUnit_code() {
		return unit_code;
	}
	/**
	 * @param unit_code the unit_code to set
	 */
	public void setUnit_code(Integer unit_code) {
		this.unit_code = unit_code;
	}
	/**
	 * @return the unit_name
	 */
	public String getUnit_name() {
		return unit_name;
	}
	/**
	 * @param unit_name the unit_name to set
	 */
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
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
