package com.sil.rig;

import java.util.Date;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

public class RigMasterBean {

	 private String rfif_code;
	 private String machine_code;
	 private String rig_name;
	 private String rig_make;
	 private String rig_model;
	 private String rig_capacity;
	 private String rig_yom;
	 @DateTimeFormat(pattern="dd-MM-yyyy")
	 private Date rig_installation_date;
	 @DateTimeFormat(pattern="dd-MM-yyyy")
	 private Date rig_release_date;
	 private String rig_sl_no;
	 private String remark;
	 private String site_no;
	 private String contract_no;
	 private String contractName;
	 
	 
	 
	 private Map zoneMap;






	public String getRfif_code() {
		return rfif_code;
	}



	public void setRfif_code(String rfif_code) {
		this.rfif_code = rfif_code;
	}



	public String getMachine_code() {
		return machine_code;
	}



	public void setMachine_code(String machine_code) {
		this.machine_code = machine_code;
	}



	public String getRig_name() {
		return rig_name;
	}



	public void setRig_name(String rig_name) {
		this.rig_name = rig_name;
	}



	public String getRig_make() {
		return rig_make;
	}



	public void setRig_make(String rig_make) {
		this.rig_make = rig_make;
	}



	public String getRig_model() {
		return rig_model;
	}



	public void setRig_model(String rig_model) {
		this.rig_model = rig_model;
	}



	public String getRig_capacity() {
		return rig_capacity;
	}



	public void setRig_capacity(String rig_capacity) {
		this.rig_capacity = rig_capacity;
	}



	public String getRig_yom() {
		return rig_yom;
	}



	public void setRig_yom(String rig_yom) {
		this.rig_yom = rig_yom;
	}



	public Date getRig_installation_date() {
		return rig_installation_date;
	}



	public void setRig_installation_date(Date rig_installation_date) {
		this.rig_installation_date = rig_installation_date;
	}



	public Date getRig_release_date() {
		return rig_release_date;
	}



	public void setRig_release_date(Date rig_release_date) {
		this.rig_release_date = rig_release_date;
	}



	public String getRig_sl_no() {
		return rig_sl_no;
	}



	public void setRig_sl_no(String rig_sl_no) {
		this.rig_sl_no = rig_sl_no;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getSite_no() {
		return site_no;
	}



	public void setSite_no(String site_no) {
		this.site_no = site_no;
	}



	public String getContract_no() {
		return contract_no;
	}



	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}



	public Map getZoneMap() {
		return zoneMap;
	}



	public void setZoneMap(Map zoneMap) {
		this.zoneMap = zoneMap;
	}



	public String getContractName() {
		return contractName;
	}



	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	 
	 
	 
	 
	 
	 
}
