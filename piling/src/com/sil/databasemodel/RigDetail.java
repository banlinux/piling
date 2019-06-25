package com.sil.databasemodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="RIG_DETAIL")
public class RigDetail implements Serializable {


		@Id
		@Column(name="RIG_SL_NO")
		private String rig_sl_no;
		@Column(name="RFID_CODE")
		private String rfid_code;
		@Column(name="MACHINE_CODE")
		private String machine_code;
		@Column(name="RIG_NAME")
		private String rig_name;
		@Column(name="RIG_MAKE")
		private String rig_make;
		@Column(name="RIG_MODEL")
		private String rig_model;
		@Column(name="RIG_CAPACITY")
		private String rig_capacity;
		@Column(name="RIG_YOM")
		private String rig_yom;
		@Column(name="RIG_INSTALLATION_DATE")
		private Date rig_installation_date; 
		@Column(name="RIG_RELEASE_DATE")
		private Date rig_release_date; 

		@Column(name="REMARK")
		private String remark;
		@Column(name="SITE_NO")
		private String site_no;
		@Column(name="CONTRACT_NO")
		private String contract_no;
		public String getRig_sl_no() {
			return rig_sl_no;
		}
		public void setRig_sl_no(String rig_sl_no) {
			this.rig_sl_no = rig_sl_no;
		}
		public String getRfid_code() {
			return rfid_code;
		}
		public void setRfid_code(String rfid_code) {
			this.rfid_code = rfid_code;
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
		
		
		
		
		
}
