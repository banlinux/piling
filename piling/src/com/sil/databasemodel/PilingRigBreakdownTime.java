package com.sil.databasemodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="piling_rig_breakdown_time")
public class PilingRigBreakdownTime implements Serializable{
	@Id
	@Column(name="sl_no")
	private String sl_no;
	
	@Column(name="breakdown_date")
	private Date breakdown_date;

	@Column(name="rig_no")
	private String rig_no;
	@Column(name="piling_rig_breakdown_time_start")
	private String piling_rig_breakdown_time_start;

	@Column(name="piling_rig_breakdown_time_end")
	private String piling_rig_breakdown_time_end;

	@Column(name="details")
	private String details;

	public String getSl_no() {
		return sl_no;
	}

	public void setSl_no(String sl_no) {
		this.sl_no = sl_no;
	}

	public Date getBreakdown_date() {
		return breakdown_date;
	}

	public void setBreakdown_date(Date breakdown_date) {
		this.breakdown_date = breakdown_date;
	}

	public String getRig_no() {
		return rig_no;
	}

	public void setRig_no(String rig_no) {
		this.rig_no = rig_no;
	}

	public String getPiling_rig_breakdown_time_start() {
		return piling_rig_breakdown_time_start;
	}

	public void setPiling_rig_breakdown_time_start(String piling_rig_breakdown_time_start) {
		this.piling_rig_breakdown_time_start = piling_rig_breakdown_time_start;
	}

	public String getPiling_rig_breakdown_time_end() {
		return piling_rig_breakdown_time_end;
	}

	public void setPiling_rig_breakdown_time_end(String piling_rig_breakdown_time_end) {
		this.piling_rig_breakdown_time_end = piling_rig_breakdown_time_end;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	
	
}
