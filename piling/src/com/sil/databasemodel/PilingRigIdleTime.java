package com.sil.databasemodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="piling_rig_idle_time")
public class PilingRigIdleTime implements Serializable {
	@Id
	@Column(name="sl_no")
	private String sl_no;
	
	@Column(name="idle_date")
	private Date idle_date;

	@Column(name="rig_no")
	private String rig_no;
	@Column(name="piling_rig_idle_time_start")
	private String piling_rig_idle_time_start;

	@Column(name="piling_rig_idle_time_end")
	private String piling_rig_idle_time_end;

	@Column(name="reason")
	private String reason;



	public String getSl_no() {
		return sl_no;
	}

	public void setSl_no(String sl_no) {
		this.sl_no = sl_no;
	}

	public Date getIdle_date() {
		return idle_date;
	}

	public void setIdle_date(Date idle_date) {
		this.idle_date = idle_date;
	}

	public String getRig_no() {
		return rig_no;
	}

	public void setRig_no(String rig_no) {
		this.rig_no = rig_no;
	}

	public String getPiling_rig_idle_time_start() {
		return piling_rig_idle_time_start;
	}

	public void setPiling_rig_idle_time_start(String piling_rig_idle_time_start) {
		this.piling_rig_idle_time_start = piling_rig_idle_time_start;
	}

	public String getPiling_rig_idle_time_end() {
		return piling_rig_idle_time_end;
	}

	public void setPiling_rig_idle_time_end(String piling_rig_idle_time_end) {
		this.piling_rig_idle_time_end = piling_rig_idle_time_end;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
