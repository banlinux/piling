/**
 * 
 */
package com.sil.databasemodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="piling_user_permission")
public class UserPermission {
	@Id
	@Column(name="USER_ID")
	private String user_id;
//	@Column(name="m_zone")
//	private String m_zone;
	@Column(name="m_site")
	private String m_site;
	@Column(name="m_contract")
	private String m_contract;
	@Column(name="m_permission")
	private String m_permission;
	@Column(name="f_rig_progress")
	private String f_rig_progress;
	@Column(name="r_rig_progress")
	private String r_rig_progress;

	@Column(name="m_rig")
	private String m_rig;
	@Column(name="m_pile")
	private String m_pile;
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
/*	public String getM_zone() {
		return m_zone;
	}
	public void setM_zone(String m_zone) {
		this.m_zone = m_zone;
	}*/
	public String getM_site() {
		return m_site;
	}
	public void setM_site(String m_site) {
		this.m_site = m_site;
	}
	public String getM_contract() {
		return m_contract;
	}
	public void setM_contract(String m_contract) {
		this.m_contract = m_contract;
	}

	public String getM_permission() {
		return m_permission;
	}
	public void setM_permission(String m_permission) {
		this.m_permission = m_permission;
	}
	public String getF_rig_progress() {
		return f_rig_progress;
	}
	public void setF_rig_progress(String f_rig_progress) {
		this.f_rig_progress = f_rig_progress;
	}
	public String getR_rig_progress() {
		return r_rig_progress;
	}
	public void setR_rig_progress(String r_rig_progress) {
		this.r_rig_progress = r_rig_progress;
	}
	public String getM_rig() {
		return m_rig;
	}
	public void setM_rig(String m_rig) {
		this.m_rig = m_rig;
	}
	public String getM_pile() {
		return m_pile;
	}
	public void setM_pile(String m_pile) {
		this.m_pile = m_pile;
	}

	
	

}
