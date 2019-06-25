/**
 * 
 */
package com.sil.databasemodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sumanta roy
 *
 */
@Entity
@Table(name="MENU_MASTER")
public class MenuMaster {
	@Id
	@Column(name="MENU_ID")
	private String menu_id;
	@Column(name="MENU_DESC")
	private String menu_desc;
	@Column(name="ACTIVE")
	private String active;
	/**
	 * @return the menu_id
	 */
	public String getMenu_id() {
		return menu_id;
	}
	/**
	 * @param menu_id the menu_id to set
	 */
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	/**
	 * @return the menu_desc
	 */
	public String getMenu_desc() {
		return menu_desc;
	}
	/**
	 * @param menu_desc the menu_desc to set
	 */
	public void setMenu_desc(String menu_desc) {
		this.menu_desc = menu_desc;
	}
	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}
	

}
