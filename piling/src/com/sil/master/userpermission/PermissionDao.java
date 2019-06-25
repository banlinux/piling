/**
 * 
 */
package com.sil.master.userpermission;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface PermissionDao {
	
	public List<String> getPermissionDetails(String empcd);

	public List<String> getEmpDetails(String empCode); 

	public boolean insertPermissionEntry(PermissionBean permissionBean); 
	
//	public Map<String, String> getEmployeeNames(String userContcd); Rinku Commented

	public boolean modifyPermissionEntry(PermissionBean permissionBean); 

	public List<String> getPassword(String empCode);
	
	public Set<String> getEmployeeDetails(String senderType,String query);
	
}
