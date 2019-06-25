/**
 * 
 */
package com.sil.databasemodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * @author AmlanM
 *
 */
@Entity
@Table(name="EMPLOYEEMASTER")
public class EmployeeMasterDetail {
	@Id
	@Column(name="empcd")
	private String empcd;
	@Column(name="empname")
	private String empname;
	@Column(name = "contcd")
	private String contcd;
	@Column (name="deptcd")
	private String deptcd;
	@Column (name="designation")
	private String designation;
	@Column(name="activeind")
	private String activeind;
	
	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name="deptcd", insertable=false,updatable=false)
	private DepartmentMasterDetail departmentMasterDetail;
	
	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name="contcd", insertable=false,updatable=false)
	private ContractMaster contractMaster;
	
	
	public String getEmpcd(){
		return empcd;
	}
	public void setEmpcd(String empcd){
		this.empcd = empcd;
	}
	public String getEmpname(){
		return empname;
	}
	public void setEmpname(String empname){
		this.empname = empname;
	}
	public String getContcd(){
		return contcd;
	}
	public void setContcd(String contcd){
		this.contcd = contcd;
	}
	public String getDeptcd(){
		return deptcd;
	}
	public void setDeptcd(String deptcd){
		this.deptcd = deptcd;
	}
	public String getDesignation(){
		return designation;
	}
	public void setDesignation(String designation){
		this.designation = designation;
	}
	public String getActiveInd(){
		return activeind;
	}
	public void setActiveInd(String activeind){
		this.activeind = activeind;
	}
	/**
	 * @return the departmentMasterDetail
	 */
	public DepartmentMasterDetail getDepartmentMasterDetail() {
		return departmentMasterDetail;
	}
	/**
	 * @param departmentMasterDetail the departmentMasterDetail to set
	 */
	public void setDepartmentMasterDetail(
			DepartmentMasterDetail departmentMasterDetail) {
		this.departmentMasterDetail = departmentMasterDetail;
	}
	/**
	 * @return the contractMaster
	 */
	public ContractMaster getContractMaster() {
		return contractMaster;
	}
	/**
	 * @param contractMaster the contractMaster to set
	 */
	public void setContractMaster(ContractMaster contractMaster) {
		this.contractMaster = contractMaster;
	}
}
