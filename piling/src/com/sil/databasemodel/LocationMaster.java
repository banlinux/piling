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
@Table(name="LOCATION_MASTER")
public class LocationMaster implements Serializable{
	@Id
	@Column(name="LOCCODE")
	private String location_code;
	@Id
	@Column(name="CONTCD")
	private String contract_code;
	@Column(name="LOCNAME")
	private String location_name;
	@Column(name="ACTIVEIND")
	private String active;
	@Column(name="LOCADDRESS")
	private String location_address;
	/**
	 * @return the location_code
	 */
	public String getLocation_code() {
		return location_code;
	}
	/**
	 * @param location_code the location_code to set
	 */
	public void setLocation_code(String location_code) {
		this.location_code = location_code;
	}
	/**
	 * @return the contract_code
	 */
	public String getContract_code() {
		return contract_code;
	}
	/**
	 * @param contract_code the contract_code to set
	 */
	public void setContract_code(String contract_code) {
		this.contract_code = contract_code;
	}
	/**
	 * @return the location_name
	 */
	public String getLocation_name() {
		return location_name;
	}
	/**
	 * @param location_name the location_name to set
	 */
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}
	/**
	 * @return the location_address
	 */
	public String getLocation_address() {
		return location_address;
	}
	/**
	 * @param location_address the location_address to set
	 */
	public void setLocation_address(String location_address) {
		this.location_address = location_address;
	}
}
