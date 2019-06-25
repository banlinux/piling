package com.sil.databasemodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_ss_contract_mst")
public class ContractMaster {
	@Id
	@Column(name="CONTRACT_NO")
	private String contract_no;
	@Column(name="SITE_NO")
	private String site_no;
	@Column(name="PROV_CONTRACTNO")
	private String prov_contractno;
	@Column(name="PROV_SITENO")
	private String prov_siteno;
	@Column(name="CONTRACT_DESC")
	private String contract_desc;
	@Column(name="CUST_ID")
	private String cust_id;
	@Column(name="CUST_NAME")
	private String cust_name;
	@Column(name="CUST_ADDRLN1")
	private String cust_addrln1;
	@Column(name="CUST_ADDRLN2")
	private String cust_addrln2;
	@Column(name="CUST_ADDRLN3")
	private String cust_addrln3;
	@Column(name="CUST_ADDRLN4")
	private String cust_addrln4;
	@Column(name="CUST_CITY")
	private String cust_city;
	@Column(name="CUST_STATE")
	private String cust_state;
	@Column(name="CUST_COUNTRY")
	private String cust_country;
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	public String getSite_no() {
		return site_no;
	}
	public void setSite_no(String site_no) {
		this.site_no = site_no;
	}
	public String getProv_contractno() {
		return prov_contractno;
	}
	public void setProv_contractno(String prov_contractno) {
		this.prov_contractno = prov_contractno;
	}
	public String getProv_siteno() {
		return prov_siteno;
	}
	public void setProv_siteno(String prov_siteno) {
		this.prov_siteno = prov_siteno;
	}
	public String getContract_desc() {
		return contract_desc;
	}
	public void setContract_desc(String contract_desc) {
		this.contract_desc = contract_desc;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_addrln1() {
		return cust_addrln1;
	}
	public void setCust_addrln1(String cust_addrln1) {
		this.cust_addrln1 = cust_addrln1;
	}
	public String getCust_addrln2() {
		return cust_addrln2;
	}
	public void setCust_addrln2(String cust_addrln2) {
		this.cust_addrln2 = cust_addrln2;
	}
	public String getCust_addrln3() {
		return cust_addrln3;
	}
	public void setCust_addrln3(String cust_addrln3) {
		this.cust_addrln3 = cust_addrln3;
	}
	public String getCust_addrln4() {
		return cust_addrln4;
	}
	public void setCust_addrln4(String cust_addrln4) {
		this.cust_addrln4 = cust_addrln4;
	}
	public String getCust_city() {
		return cust_city;
	}
	public void setCust_city(String cust_city) {
		this.cust_city = cust_city;
	}
	public String getCust_state() {
		return cust_state;
	}
	public void setCust_state(String cust_state) {
		this.cust_state = cust_state;
	}
	public String getCust_country() {
		return cust_country;
	}
	public void setCust_country(String cust_country) {
		this.cust_country = cust_country;
	}
	@Column(name="CUST_PIN")
	private String cust_pin;
	@Column(name="CUST_ALLOCD")
	private String cust_allocd;	
	@Column(name="CUST_SCHCD")
	private String cust_schcd;
	@Column(name="OVERSEAS_VALUE")
	private String overseas_value;
	@Column(name="CURRENCY_RATE")
	private String current_rate;
	@Column(name="CURRENCY_NAME")
	private String current_name;
	@Column(name="CONTRACT_VALUE")
	private String contract_value;
	@Column(name="PLACE_OF_WORK")
	private String place_of_work;
	@Column(name="WORK_STATE")
	private String work_stare;
	@Column(name="STATE_CODE")
	private String state_code;
	@Column(name="ZONE")
	private String zone;
	@Column(name="START_DATE")
	private Date start_date;
	public String getCust_pin() {
		return cust_pin;
	}
	public void setCust_pin(String cust_pin) {
		this.cust_pin = cust_pin;
	}
	public String getCust_allocd() {
		return cust_allocd;
	}
	public void setCust_allocd(String cust_allocd) {
		this.cust_allocd = cust_allocd;
	}
	public String getCust_schcd() {
		return cust_schcd;
	}
	public void setCust_schcd(String cust_schcd) {
		this.cust_schcd = cust_schcd;
	}
	public String getOverseas_value() {
		return overseas_value;
	}
	public void setOverseas_value(String overseas_value) {
		this.overseas_value = overseas_value;
	}
	public String getCurrent_rate() {
		return current_rate;
	}
	public void setCurrent_rate(String current_rate) {
		this.current_rate = current_rate;
	}
	public String getCurrent_name() {
		return current_name;
	}
	public void setCurrent_name(String current_name) {
		this.current_name = current_name;
	}
	public String getContract_value() {
		return contract_value;
	}
	public void setContract_value(String contract_value) {
		this.contract_value = contract_value;
	}
	public String getPlace_of_work() {
		return place_of_work;
	}
	public void setPlace_of_work(String place_of_work) {
		this.place_of_work = place_of_work;
	}
	public String getWork_stare() {
		return work_stare;
	}
	public void setWork_stare(String work_stare) {
		this.work_stare = work_stare;
	}
	public String getState_code() {
		return state_code;
	}
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	
}
