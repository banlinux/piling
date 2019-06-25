/**
 * 
 */
package com.sil.databasemodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author AmlanM
 *
 */

@Entity
@Table(name="DEPARTMENTMASTER")
public class DepartmentMasterDetail {
	@Id
	@Column(name="deptcd")
	private String deptcd;
	@Column(name="departmentname")
	private String departmentname;
	@Column(name="activeind")
	private String activeind;

	public String getDeptcd(){
		return deptcd;
	}
	public void setDeptcd(String deptcd){
		this.deptcd = deptcd;
	}
	public String getDepartmentName(){
		return departmentname;
	}
	public void setDepartmentName(String departmentname){
		this.departmentname = departmentname;
	}
	public String getActiveInd(){
		return activeind;
	}
	public void setActiveInd(String activeind){
		this.activeind = activeind;
	}
}
