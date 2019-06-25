package com.sil.databasemodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="piling_rig_movement_time")
public class PilingRigMovementTime implements Serializable{
	@Id
	@Column(name="sl_no")
	private String sl_no;
	
	@Column(name="movement_date")
	private Date movement_date;

	@Column(name="rig_no")
	private String rig_no;
	@Column(name="piling_rig_movement_time_start")
	private String piling_rig_movement_time_start;

	@Column(name="piling_rig_movement_time_end")
	private String piling_rig_movement_time_end;

	@Column(name="from_pile")
	private String from_pile;
	
	@Column(name="to_pile")
	private String to_pile;

	public String getSl_no() {
		return sl_no;
	}

	public void setSl_no(String sl_no) {
		this.sl_no = sl_no;
	}

	public Date getMovement_date() {
		return movement_date;
	}

	public void setMovement_date(Date movement_date) {
		this.movement_date = movement_date;
	}

	public String getRig_no() {
		return rig_no;
	}

	public void setRig_no(String rig_no) {
		this.rig_no = rig_no;
	}

	public String getPiling_rig_movement_time_start() {
		return piling_rig_movement_time_start;
	}

	public void setPiling_rig_movement_time_start(String piling_rig_movement_time_start) {
		this.piling_rig_movement_time_start = piling_rig_movement_time_start;
	}

	public String getPiling_rig_movement_time_end() {
		return piling_rig_movement_time_end;
	}

	public void setPiling_rig_movement_time_end(String piling_rig_movement_time_end) {
		this.piling_rig_movement_time_end = piling_rig_movement_time_end;
	}

	public String getFrom_pile() {
		return from_pile;
	}

	public void setFrom_pile(String from_pile) {
		this.from_pile = from_pile;
	}

	public String getTo_pile() {
		return to_pile;
	}

	public void setTo_pile(String to_pile) {
		this.to_pile = to_pile;
	}


	
	
}
