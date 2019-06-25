/**
 * 
 */
package com.sil.master.userpermission;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sil.master.userpermission.PermissionDao;
import com.sil.util.CommonFunctionDao;


@Repository
@Service
public class PermissionLogic {
	private CommonFunctionDao commonFunctionDao;
	private PermissionDao permissionDao;
	@Autowired
	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}	

	/**
	 * @param commonFunctionDao the commonFunctionDao to set
	 */
	@Autowired
	public void setCommonFunctionDao(CommonFunctionDao commonFunctionDao) {
		this.commonFunctionDao = commonFunctionDao;
	}
	
	public Date getCurrentDate() {
		// TODO Auto-generated method stub
		return commonFunctionDao.getCurrentDate();
	}

	public List<String> getPermissionDetails(String empcd) {
		// TODO Auto-generated method stub
		return permissionDao.getPermissionDetails(empcd);
	}
	/*RINKU Added*/
	
	public Set getEmployeeDetails(String senderType,String query){
		System.out.println(senderType+":"+query);
		return permissionDao.getEmployeeDetails(senderType,query);
	}
	/*Rinku Add end*/

	public List<String> getEmpDetails(String empCode) {
		// TODO Auto-generated method stub
		
		return permissionDao.getEmpDetails(empCode);
	}
	
	public boolean insertPermissionEntry(PermissionBean permissionBean) {
		// TODO Auto-generated method stub
		return permissionDao.insertPermissionEntry(permissionBean);
	}
	/*Rinku Commented
	public Map<String, String> getEmployeeNames(String userContcd) {
		// TODO Auto-generated method stub
		Map<String,String> result = permissionDao.getEmployeeNames(userContcd);
		return result;
	}
*/
	public boolean modifyPermissionEntry(PermissionBean permissionBean) {
		// TODO Auto-generated method stub
		return permissionDao.modifyPermissionEntry(permissionBean);
	}

	public List<String> getPassword(String empCode) {
		// TODO Auto-generated method stub
		return permissionDao.getPassword(empCode);
	}

	

}
