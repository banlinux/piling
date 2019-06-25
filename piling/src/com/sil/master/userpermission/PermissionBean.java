/**
 * 
 */
package com.sil.master.userpermission;

import java.util.Date;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;


public class PermissionBean {
	private String userId;  //Rinku Needed
//	private String empMenuMaster;
//	private String usrMenuPermission; 
//	private String dptMenu;
//	private String contractMenu;
//	private String contractGroupMenu;
//	private String locationMenu;
//	private String courierMenu;
//	private String contMstViewMenu;
//	private String courierRateMenu;
//	private String countryMstMenu;
//	private String regionMstMenu;
//	private String stateMstMenu;
//	private String districtMstMenu;
//	private String cityMstMenu;
//	private String contDeptAssociation;
//	private String outEntryMenu;
//	private String outEntryDispMenu;
//	private String returnEntryModMenu;
//	private String returnMenu;
//	private String consignModMenu;
//	private String inEntryMenu;
//	private String courierReturnMenu;
//	private String indAckMenu;
//	private String entryAckMenu;
//	private String incommingRptMenu;
//	private String outSumRptMenu;
//	private String returnRptMenu;
//	private String outDtlRptMenu;
//	private String entryUserId;
//	@DateTimeFormat(pattern="dd-MM-yyyy")
//	private Date entryDate;
//	private String contCode;		// default contract code.
//	private String contractDesc;	// default contract description.
//	private String deptCode;		// default department code.
//	private String deptName;		// default department name.
	private String userName;  //Rinku Needed
//	private String password;
//	private String repassword;
	private String status; //Rinku Needed
//	private Map<String,String> employees;
	
	//Rinku added
	private String m_site;
	private String m_contract;
	private String m_permission;
	private String f_rig_progress;
	private String r_rig_progress;
	private String m_rig;
	private String m_pile;
	private String empCode;


	

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
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	//	/**
//	 * @return the empMenuMaster
//	 */
//	public String getEmpMenuMaster() {
//		return empMenuMaster;
//	}
//	/**
//	 * @param empMenuMaster the empMenuMaster to set
//	 */
//	public void setEmpMenuMaster(String empMenuMaster) {
//		this.empMenuMaster = empMenuMaster;
//	}
//	/**
//	 * @return the usrMenuPermission
//	 */
//	public String getUsrMenuPermission() {
//		return usrMenuPermission;
//	}
//	/**
//	 * @param usrMenuPermission the usrMenuPermission to set
//	 */
//	public void setUsrMenuPermission(String usrMenuPermission) {
//		this.usrMenuPermission = usrMenuPermission;
//	}
//	/**
//	 * @return the dptMenu
//	 */
//	public String getDptMenu() {
//		return dptMenu;
//	}
//	/**
//	 * @param dptMenu the dptMenu to set
//	 */
//	public void setDptMenu(String dptMenu) {
//		this.dptMenu = dptMenu;
//	}
//	/**
//	 * @return the contractMenu
//	 */
//	public String getContractMenu() {
//		return contractMenu;
//	}
//	/**
//	 * @param contractMenu the contractMenu to set
//	 */
//	public void setContractMenu(String contractMenu) {
//		this.contractMenu = contractMenu;
//	}
//	/**
//	 * @return the contractGroupMenu
//	 */
//	public String getContractGroupMenu() {
//		return contractGroupMenu;
//	}
//	/**
//	 * @param contractGroupMenu the contractGroupMenu to set
//	 */
//	public void setContractGroupMenu(String contractGroupMenu) {
//		this.contractGroupMenu = contractGroupMenu;
//	}
//	/**
//	 * @return the locationMenu
//	 */
//	public String getLocationMenu() {
//		return locationMenu;
//	}
//	/**
//	 * @param locationMenu the locationMenu to set
//	 */
//	public void setLocationMenu(String locationMenu) {
//		this.locationMenu = locationMenu;
//	}
//	/**
//	 * @return the courierMenu
//	 */
//	public String getCourierMenu() {
//		return courierMenu;
//	}
//	/**
//	 * @param courierMenu the courierMenu to set
//	 */
//	public void setCourierMenu(String courierMenu) {
//		this.courierMenu = courierMenu;
//	}
//	/**
//	 * @return the contMstViewMenu
//	 */
//	public String getContMstViewMenu() {
//		return contMstViewMenu;
//	}
//	/**
//	 * @param contMstViewMenu the contMstViewMenu to set
//	 */
//	public void setContMstViewMenu(String contMstViewMenu) {
//		this.contMstViewMenu = contMstViewMenu;
//	}
//	/**
//	 * @return the outEntryMenu
//	 */
//	public String getOutEntryMenu() {
//		return outEntryMenu;
//	}
//	/**
//	 * @param outEntryMenu the outEntryMenu to set
//	 */
//	public void setOutEntryMenu(String outEntryMenu) {
//		this.outEntryMenu = outEntryMenu;
//	}
//	/**
//	 * @return the outEntryDispMenu
//	 */
//	public String getOutEntryDispMenu() {
//		return outEntryDispMenu;
//	}
//	/**
//	 * @param outEntryDispMenu the outEntryDispMenu to set
//	 */
//	public void setOutEntryDispMenu(String outEntryDispMenu) {
//		this.outEntryDispMenu = outEntryDispMenu;
//	}
//	/**
//	 * @return the returnEntryModMenu
//	 */
//	public String getReturnEntryModMenu() {
//		return returnEntryModMenu;
//	}
//	/**
//	 * @param returnEntryModMenu the returnEntryModMenu to set
//	 */
//	public void setReturnEntryModMenu(String returnEntryModMenu) {
//		this.returnEntryModMenu = returnEntryModMenu;
//	}
//	/**
//	 * @return the returnMenu
//	 */
//	public String getReturnMenu() {
//		return returnMenu;
//	}
//	/**
//	 * @param returnMenu the returnMenu to set
//	 */
//	public void setReturnMenu(String returnMenu) {
//		this.returnMenu = returnMenu;
//	}
//	/**
//	 * @return the consignModMenu
//	 */
//	public String getConsignModMenu() {
//		return consignModMenu;
//	}
//	/**
//	 * @param consignModMenu the consignModMenu to set
//	 */
//	public void setConsignModMenu(String consignModMenu) {
//		this.consignModMenu = consignModMenu;
//	}
//	/**
//	 * @return the inEntryMenu
//	 */
//	public String getInEntryMenu() {
//		return inEntryMenu;
//	}
//	/**
//	 * @param inEntryMenu the inEntryMenu to set
//	 */
//	public void setInEntryMenu(String inEntryMenu) {
//		this.inEntryMenu = inEntryMenu;
//	}
//	/**
//	 * @return the courierReturnMenu
//	 */
//	public String getCourierReturnMenu() {
//		return courierReturnMenu;
//	}
//	/**
//	 * @param courierReturnMenu the courierReturnMenu to set
//	 */
//	public void setCourierReturnMenu(String courierReturnMenu) {
//		this.courierReturnMenu = courierReturnMenu;
//	}
//	/**
//	 * @return the indAckMenu
//	 */
//	public String getIndAckMenu() {
//		return indAckMenu;
//	}
//	/**
//	 * @param indAckMenu the indAckMenu to set
//	 */
//	public void setIndAckMenu(String indAckMenu) {
//		this.indAckMenu = indAckMenu;
//	}
//	/**
//	 * @return the entryAckMenu
//	 */
//	public String getEntryAckMenu() {
//		return entryAckMenu;
//	}
//	/**
//	 * @param entryAckMenu the entryAckMenu to set
//	 */
//	public void setEntryAckMenu(String entryAckMenu) {
//		this.entryAckMenu = entryAckMenu;
//	}
//	/**
//	 * @return the incommingRptMenu
//	 */
//	public String getIncommingRptMenu() {
//		return incommingRptMenu;
//	}
//	/**
//	 * @param incommingRptMenu the incommingRptMenu to set
//	 */
//	public void setIncommingRptMenu(String incommingRptMenu) {
//		this.incommingRptMenu = incommingRptMenu;
//	}
//	/**
//	 * @return the outSumRptMenu
//	 */
//	public String getOutSumRptMenu() {
//		return outSumRptMenu;
//	}
//	/**
//	 * @param outSumRptMenu the outSumRptMenu to set
//	 */
//	public void setOutSumRptMenu(String outSumRptMenu) {
//		this.outSumRptMenu = outSumRptMenu;
//	}
//	/**
//	 * @return the returnRptMenu
//	 */
//	public String getReturnRptMenu() {
//		return returnRptMenu;
//	}
//	/**
//	 * @param returnRptMenu the returnRptMenu to set
//	 */
//	public void setReturnRptMenu(String returnRptMenu) {
//		this.returnRptMenu = returnRptMenu;
//	}
//	/**
//	 * @return the outDtlRptMenu
//	 */
//	public String getOutDtlRptMenu() {
//		return outDtlRptMenu;
//	}
//	/**
//	 * @param outDtlRptMenu the outDtlRptMenu to set
//	 */
//	public void setOutDtlRptMenu(String outDtlRptMenu) {
//		this.outDtlRptMenu = outDtlRptMenu;
//	}
//	/**
//	 * @return the courierRateMenu
//	 */
//	public String getCourierRateMenu() {
//		return courierRateMenu;
//	}
//	/**
//	 * @param courierRateMenu the courierRateMenu to set
//	 */
//	public void setCourierRateMenu(String courierRateMenu) {
//		this.courierRateMenu = courierRateMenu;
//	}
//	/**
//	 * @return the entryDate
//	 */
//	public Date getEntryDate() {
//		return entryDate;
//	}
//	/**
//	 * @param entryDate the entryDate to set
//	 */
//	public void setEntryDate(Date entryDate) {
//		this.entryDate = entryDate;
//	}
//	/**
//	 * @return the entryUserId
//	 */
//	public String getEntryUserId() {
//		return entryUserId;
//	}
//	/**
//	 * @param entryUserId the entryUserId to set
//	 */
//	public void setEntryUserId(String entryUserId) {
//		this.entryUserId = entryUserId;
//	}
//	/**
//	 * @return the contCode
//	 */
//	public String getContCode() {
//		return contCode;
//	}
//	/**
//	 * @param contCode the contCode to set
//	 */
//	public void setContCode(String contCode) {
//		this.contCode = contCode;
//	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
//	/**
//	 * @return the contractDesc
//	 */
//	public String getContractDesc() {
//		return contractDesc;
//	}
//	/**
//	 * @param contractDesc the contractDesc to set
//	 */
//	public void setContractDesc(String contractDesc) {
//		this.contractDesc = contractDesc;
//	}
//	/**
//	 * @return the deptCode
//	 */
//	public String getDeptCode() {
//		return deptCode;
//	}
//	/**
//	 * @param deptCode the deptCode to set
//	 */
//	public void setDeptCode(String deptCode) {
//		this.deptCode = deptCode;
//	}
//	/**
//	 * @return the deptName
//	 */
//	public String getDeptName() {
//		return deptName;
//	}
//	/**
//	 * @param deptName the deptName to set
//	 */
//	public void setDeptName(String deptName) {
//		this.deptName = deptName;
//	}
//	/**
//	 * @return the employees
//	 */
//	public Map<String,String> getEmployees() {
//		return employees;
//	}
//	/**
//	 * @param employees the employees to set
//	 */
//	public void setEmployees(Map<String,String> employees) {
//		this.employees = employees;
//	}
//	/**
//	 * @return the password
//	 */
//	public String getPassword() {
//		return password;
//	}
//	/**
//	 * @param password the password to set
//	 */
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	/**
//	 * @return the repassword
//	 */
//	public String getRepassword() {
//		return repassword;
//	}
//	/**
//	 * @param repassword the repassword to set
//	 */
//	public void setRepassword(String repassword) {
//		this.repassword = repassword;
//	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
//	/**
//	 * @return the countryMstMenu
//	 */
//	public String getCountryMstMenu() {
//		return countryMstMenu;
//	}
//	/**
//	 * @param countryMstMenu the countryMstMenu to set
//	 */
//	public void setCountryMstMenu(String countryMstMenu) {
//		this.countryMstMenu = countryMstMenu;
//	}
//	/**
//	 * @return the regionMstMenu
//	 */
//	public String getRegionMstMenu() {
//		return regionMstMenu;
//	}
//	/**
//	 * @param regionMstMenu the regionMstMenu to set
//	 */
//	public void setRegionMstMenu(String regionMstMenu) {
//		this.regionMstMenu = regionMstMenu;
//	}
//	/**
//	 * @return the stateMstMenu
//	 */
//	public String getStateMstMenu() {
//		return stateMstMenu;
//	}
//	/**
//	 * @param stateMstMenu the stateMstMenu to set
//	 */
//	public void setStateMstMenu(String stateMstMenu) {
//		this.stateMstMenu = stateMstMenu;
//	}
//	/**
//	 * @return the districtMstMenu
//	 */
//	public String getDistrictMstMenu() {
//		return districtMstMenu;
//	}
//	/**
//	 * @param districtMstMenu the districtMstMenu to set
//	 */
//	public void setDistrictMstMenu(String districtMstMenu) {
//		this.districtMstMenu = districtMstMenu;
//	}
//	/**
//	 * @return the cityMstMenu
//	 */
//	public String getCityMstMenu() {
//		return cityMstMenu;
//	}
//	/**
//	 * @param cityMstMenu the cityMstMenu to set
//	 */
//	public void setCityMstMenu(String cityMstMenu) {
//		this.cityMstMenu = cityMstMenu;
//	}
//	/**
//	 * @return the contDeptAssociation
//	 */
//	public String getContDeptAssociation() {
//		return contDeptAssociation;
//	}
//	/**
//	 * @param contDeptAssociation the contDeptAssociation to set
//	 */
//	public void setContDeptAssociation(String contDeptAssociation) {
//		this.contDeptAssociation = contDeptAssociation;
//	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	
}
