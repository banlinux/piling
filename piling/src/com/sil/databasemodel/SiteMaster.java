/**
 * 
 */
package com.sil.databasemodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Milan Dutta
 *
 */
@Entity
@Table(name="TB_SS_SITE_MST")
public class SiteMaster {
	@Id
	@Column(name="SITE_NO")
	private String site_no;
	@Column(name="SITE_DESC")
	private String site_desc;
	@Column(name="SITE_INCHARGE")
	private String site_incharge;
	@Column(name="SITE_COORDINATOR")
	private String site_coordinator;
	@Column(name="SITE_COORDINATOR_TECH")
	private String site_coordinator_tech;
	@Column(name="SITE_ADDRESS1")
	private String site_address1;
	@Column(name="SITE_ADDRESS2")
	private String site_address2;
	@Column(name="SITE_ADDRESS3")
	private String site_address3;
	@Column(name="SITE_ADDRESS4")
	private String site_address4;
	@Column(name="SITE_CITY")
	private String site_city;
	@Column(name="SITE_STATE")
	private String site_state;
	@Column(name="SITE_PIN")
	private String site_pin;
	@Column(name="SITE_COUNTRY")
	private String site_country;
	@Column(name="SITE_PHONE")
	private String site_phone;
	@Column(name="SITE_FAX")
	private String site_fax;
	@Column(name="CREATE_DATE")
	private Date create_date;
	@Column(name="USER_NAME")
	private String user_name;
	@Column(name="MODIFY_BY")
	private String modify_by;
	@Column(name="MODIFY_DATE")
	private Date modify_date;
	@Column(name="SITE_ACTIVE")
	private String site_active;
	/**
	 * @return the site_no
	 */
	public String getSite_no() {
		return site_no;
	}
	/**
	 * @param site_no the site_no to set
	 */
	public void setSite_no(String site_no) {
		this.site_no = site_no;
	}
	/**
	 * @return the site_desc
	 */
	public String getSite_desc() {
		return site_desc;
	}
	/**
	 * @param site_desc the site_desc to set
	 */
	public void setSite_desc(String site_desc) {
		this.site_desc = site_desc;
	}
	/**
	 * @return the site_incharge
	 */
	public String getSite_incharge() {
		return site_incharge;
	}
	/**
	 * @param site_incharge the site_incharge to set
	 */
	public void setSite_incharge(String site_incharge) {
		this.site_incharge = site_incharge;
	}
	/**
	 * @return the site_coordinator
	 */
	public String getSite_coordinator() {
		return site_coordinator;
	}
	/**
	 * @param site_coordinator the site_coordinator to set
	 */
	public void setSite_coordinator(String site_coordinator) {
		this.site_coordinator = site_coordinator;
	}
	/**
	 * @return the site_coordinator_tech
	 */
	public String getSite_coordinator_tech() {
		return site_coordinator_tech;
	}
	/**
	 * @param site_coordinator_tech the site_coordinator_tech to set
	 */
	public void setSite_coordinator_tech(String site_coordinator_tech) {
		this.site_coordinator_tech = site_coordinator_tech;
	}
	/**
	 * @return the site_address1
	 */
	public String getSite_address1() {
		return site_address1;
	}
	/**
	 * @param site_address1 the site_address1 to set
	 */
	public void setSite_address1(String site_address1) {
		this.site_address1 = site_address1;
	}
	/**
	 * @return the site_address2
	 */
	public String getSite_address2() {
		return site_address2;
	}
	/**
	 * @param site_address2 the site_address2 to set
	 */
	public void setSite_address2(String site_address2) {
		this.site_address2 = site_address2;
	}
	/**
	 * @return the site_address3
	 */
	public String getSite_address3() {
		return site_address3;
	}
	/**
	 * @param site_address3 the site_address3 to set
	 */
	public void setSite_address3(String site_address3) {
		this.site_address3 = site_address3;
	}
	/**
	 * @return the site_address4
	 */
	public String getSite_address4() {
		return site_address4;
	}
	/**
	 * @param site_address4 the site_address4 to set
	 */
	public void setSite_address4(String site_address4) {
		this.site_address4 = site_address4;
	}
	/**
	 * @return the site_city
	 */
	public String getSite_city() {
		return site_city;
	}
	/**
	 * @param site_city the site_city to set
	 */
	public void setSite_city(String site_city) {
		this.site_city = site_city;
	}
	/**
	 * @return the site_state
	 */
	public String getSite_state() {
		return site_state;
	}
	/**
	 * @param site_state the site_state to set
	 */
	public void setSite_state(String site_state) {
		this.site_state = site_state;
	}
	/**
	 * @return the site_pin
	 */
	public String getSite_pin() {
		return site_pin;
	}
	/**
	 * @param site_pin the site_pin to set
	 */
	public void setSite_pin(String site_pin) {
		this.site_pin = site_pin;
	}
	/**
	 * @return the site_country
	 */
	public String getSite_country() {
		return site_country;
	}
	/**
	 * @param site_country the site_country to set
	 */
	public void setSite_country(String site_country) {
		this.site_country = site_country;
	}
	/**
	 * @return the site_phone
	 */
	public String getSite_phone() {
		return site_phone;
	}
	/**
	 * @param site_phone the site_phone to set
	 */
	public void setSite_phone(String site_phone) {
		this.site_phone = site_phone;
	}
	/**
	 * @return the site_fax
	 */
	public String getSite_fax() {
		return site_fax;
	}
	/**
	 * @param site_fax the site_fax to set
	 */
	public void setSite_fax(String site_fax) {
		this.site_fax = site_fax;
	}
	/**
	 * @return the create_date
	 */
	public Date getCreate_date() {
		return create_date;
	}
	/**
	 * @param create_date the create_date to set
	 */
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
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
	 * @return the modify_by
	 */
	public String getModify_by() {
		return modify_by;
	}
	/**
	 * @param modify_by the modify_by to set
	 */
	public void setModify_by(String modify_by) {
		this.modify_by = modify_by;
	}
	/**
	 * @return the modify_date
	 */
	public Date getModify_date() {
		return modify_date;
	}
	/**
	 * @param modify_date the modify_date to set
	 */
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	/**
	 * @return the site_active
	 */
	public String getSite_active() {
		return site_active;
	}
	/**
	 * @param site_active the site_active to set
	 */
	public void setSite_active(String site_active) {
		this.site_active = site_active;
	}

}
