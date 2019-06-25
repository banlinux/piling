package com.sil.databasemodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_ss_zone_mst")
public class ZoneMaster {
	  @Id
	  @Column(name="ZONE_NO")
	  private String zone_no;
	  @Column(name="ZONE_DESC") 
	  private String zone_desc;
	  @Column(name="CREATE_BY ")
	  private String create_by;
	  @Column(name="CREATE_DATE ")
	  private Date create_date;
	  @Column(name="MODIFY_BY ")
	  private String modified_by;
	  @Column(name="MODIFY_DATE ")
	  private Date modify_date;
	  @Column(name="STATUS ")
	private String status;
	  @Column(name="ZONE_INCHARGE ")
	private String zone_incharge;
	  @Column(name="ZONE_COORDINATOR ")
	private String zone_coordinator;
	  @Column(name="ZONE_ADDRESS1 ")
	private String zone_address1;
	  @Column(name="ZONE_ADDRESS2 ")
	private String zone_address2;
	  @Column(name="ZONE_ADDRESS3 ")
	private String zone_address3;
	  @Column(name="ZONE_CITY ")
	private String zone_city;
	  @Column(name="ZONE_STATE ")
	private String zone_state;
	  @Column(name="ZONE_PIN ")
	private String zone_pin;
	  @Column(name="ZONE_PHONE ")
	private String zone_phone;
	  @Column(name="ZONE_FAX ")
	private String zone_fax;
	  @Column(name="HEAD_SITE ")
	private String head_site;
	  @Column(name="ZONE_ABVR ")
	private String zone_abvr;
	  @Column(name="ALLOCD_ID ")
	private String alloc_id;
	public String getZone_no() {
		return zone_no;
	}
	public void setZone_no(String zone_no) {
		this.zone_no = zone_no;
	}
	public String getZone_desc() {
		return zone_desc;
	}
	public void setZone_desc(String zone_desc) {
		this.zone_desc = zone_desc;
	}
	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getZone_incharge() {
		return zone_incharge;
	}
	public void setZone_incharge(String zone_incharge) {
		this.zone_incharge = zone_incharge;
	}
	public String getZone_coordinator() {
		return zone_coordinator;
	}
	public void setZone_coordinator(String zone_coordinator) {
		this.zone_coordinator = zone_coordinator;
	}
	public String getZone_address1() {
		return zone_address1;
	}
	public void setZone_address1(String zone_address1) {
		this.zone_address1 = zone_address1;
	}
	public String getZone_address2() {
		return zone_address2;
	}
	public void setZone_address2(String zone_address2) {
		this.zone_address2 = zone_address2;
	}
	public String getZone_address3() {
		return zone_address3;
	}
	public void setZone_address3(String zone_address3) {
		this.zone_address3 = zone_address3;
	}
	public String getZone_city() {
		return zone_city;
	}
	public void setZone_city(String zone_city) {
		this.zone_city = zone_city;
	}
	public String getZone_state() {
		return zone_state;
	}
	public void setZone_state(String zone_state) {
		this.zone_state = zone_state;
	}
	public String getZone_pin() {
		return zone_pin;
	}
	public void setZone_pin(String zone_pin) {
		this.zone_pin = zone_pin;
	}
	public String getZone_phone() {
		return zone_phone;
	}
	public void setZone_phone(String zone_phone) {
		this.zone_phone = zone_phone;
	}
	public String getZone_fax() {
		return zone_fax;
	}
	public void setZone_fax(String zone_fax) {
		this.zone_fax = zone_fax;
	}
	public String getHead_site() {
		return head_site;
	}
	public void setHead_site(String head_site) {
		this.head_site = head_site;
	}
	public String getZone_abvr() {
		return zone_abvr;
	}
	public void setZone_abvr(String zone_abvr) {
		this.zone_abvr = zone_abvr;
	}
	public String getAlloc_id() {
		return alloc_id;
	}
	public void setAlloc_id(String alloc_id) {
		this.alloc_id = alloc_id;
	}
	  
	  
	  
}
