/**
 * 
 */
package com.sil.databasemodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Milan Dutta
 *
 */
@Entity
@Table(name="user_login")
public class UserLoginMaster {
	@Id
	@Column(name="user_id")
	private String user_id;
	@Column(name="USER_NAME")
	private String user_name;	
	@Column(name="password")
	private String password;
	@Column(name="status")
	private String status;
	@Column(name="CONTRACT_CODE")
	private String contract_code;
	@Column(name="LOCATION_CODE")
	private String location_code;
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

}
