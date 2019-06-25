/**
 * 
 */
package com.sil.master.userpermission;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.sil.master.userpermission.PermissionBean;
import com.sil.master.userpermission.PermissionLogic;


@Controller
@RequestMapping("/userPermission")
public class PermissionController {
	private PermissionLogic permissionLogic;
	
	@Autowired
	public void setPermissionLogic(PermissionLogic permissionLogic) {
		this.permissionLogic = permissionLogic;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String initPage(HttpServletRequest request, ModelMap map){
		//getting user's parameter from session parameter.
		HttpSession session = request.getSession(true);
		//String userContcd = (String)session.getAttribute("contractCode");  //Rinku Looks Discarded
		if(session.getAttribute("sessUserID")==null)
			return "redirect:index.htm";
		PermissionBean bean =new PermissionBean();
		
	//	bean.setEntryDate(permissionLogic.getCurrentDate());
		// combo for valid users.
		//bean.setEmployees(permissionLogic.getEmployeeNames(userContcd));  //Rinku Looks Discarded
		 
		map.put("permissionBean", bean);
		return "user/permission";
	}
	
	@RequestMapping(params = "_save",  method = RequestMethod.POST)
	public String processFinish(@Validated PermissionBean permissionBean, BindingResult result, HttpServletRequest request,
			 Map map) {
		//getting user's parameter from session parameter.
		HttpSession session = request.getSession(true);
		String userId = (String)session.getAttribute("sessUserID");
		
	//	permissionBean.setEntryDate(permissionLogic.getCurrentDate());
	//	permissionBean.setEntryUserId(userId);
		System.out.println(">>>>"+permissionBean.getEmpCode());
		System.out.println(">>>>"+permissionBean.getUserName());
		System.out.println(">>>>"+permissionBean.getStatus());
		System.out.println(">>>>"+permissionBean.getUserId());
		boolean res=permissionLogic.insertPermissionEntry(permissionBean); 
		
		//permissionBean.setEmployees(permissionLogic.getEmployeeNames(userContcd));
		map.put("permissionBean", permissionBean);
		return "redirect:userPermission.htm";
	}
	@RequestMapping(params="_modify",method = RequestMethod.POST)
	public String modifyPage(@Validated PermissionBean permissionBean,
			BindingResult result, ModelMap map, final HttpSession httpSession) {
		
		boolean res=permissionLogic.modifyPermissionEntry(permissionBean); 
		map.put("permissionBean", permissionBean);
		return "redirect:userPermission.htm";
	}
	@RequestMapping(params = "_cancel")
	public String processCancel(final SessionStatus status) {

		status.setComplete();
		
		return "redirect:mainMenu.htm";
	}	
	@RequestMapping(params = "_target1",  method = RequestMethod.POST)
	public @ResponseBody
	String getPermissionDetails(@RequestParam("empCode")  String empcd) {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("[");
		List<String> list = permissionLogic.getPermissionDetails(empcd);
		System.out.println("TARGET1   , Size is"+list.size());
		
		if (list.size()>0)
		{
			System.out.println("F_RIG_PROGERSS  "+list.get(5));
			jsonString.append("{\"USER_ID\": \"" + list.get(0) + "\","
			//		+ "\"M_ZONE\": \"" + list.get(1) + "\","
					+ "\"M_SITE\": \"" + list.get(1) + "\","
					+ "\"M_CONTRACT\": \"" + list.get(2) + "\","
					+ "\"M_PERMISSION\": \"" + list.get(3) + "\","
					+ "\"F_RIG_PROGERSS\": \"" + list.get(4) + "\","
					+ "\"R_RIG_PROGERSS\": \"" + list.get(5) + "\","
					+ "\"M_RIG\": \"" + list.get(6)+ "\","
					+ "\"M_PILE\": \"" + list.get(7) + "\"},");
			
				
		}
		jsonString.append("]");
		if (jsonString.indexOf("]") > 1) {
			jsonString.deleteCharAt(jsonString.indexOf("]") - 1);
		}
		System.out.println(jsonString);
		return jsonString.toString();
	}

	@RequestMapping(params = "_target2", method = RequestMethod.POST)
	public @ResponseBody
	String getEmpDetails(@RequestParam("empCode") String empCode) {
		//System.out.println("*******empCode******="+empCode);
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("[");
		List<String> list = permissionLogic.getEmpDetails(empCode);
		if(list.size()>0) {
			jsonString.append("{\"eCode\": \"" + list.get(0) + "\","
					+ "\"eName\": \"" + list.get(1) + "\","
					+ "\"uId\": \"" + list.get(2) + "\","
					+ "\"status\": \"" + list.get(3) + "\"},");
				
		}
		jsonString.append("]");
		if (jsonString.indexOf("]") > 1) {
			//System.out.println("=33===" + jsonString.indexOf("]"));
			jsonString.deleteCharAt(jsonString.indexOf("]") - 1);
		}

		System.out.println("==1111111==" + jsonString);
		return jsonString.toString();
	}
	
	
	@RequestMapping(params = "_target3", method = RequestMethod.POST)
	public @ResponseBody
	String getPassword(@RequestParam("empCode") String empCode) {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("[");
		List<String> list = permissionLogic.getPassword(empCode);
		if(list.size()>0){
			jsonString.append("{\"password\": \"" + list.get(0) + "\","
					+ "\"status\": \"" + list.get(1) + "\"},");
		}
		jsonString.append("]");
		if (jsonString.indexOf("]") > 1){
			jsonString.deleteCharAt(jsonString.indexOf("]") - 1);
		}
		System.out.println("==22==" + jsonString);
		return jsonString.toString();
	}
	
	/*
	// this is required when one user getting permissions for multiple contracts.
	@RequestMapping(params = "_target1",  method = RequestMethod.POST)
	public @ResponseBody
	String getPermissionDetails(@RequestParam("empCode")  String empcd) {
		StringBuffer jsonString = new StringBuffer();
		int srl = 0;
		jsonString.append("[");
		List<PermissionBean> list = permissionLogic.getPermissionDetails(empcd);
		for (PermissionBean out : list) {
			jsonString.append("{\"id\": \"" + ++srl 	// id must be a unique column.
					+"\",\"empcd\":\"" + out.getUserId()
					+ "\",\"contractcd\": \"" + out.getAddedContCode() + "\","
					+ "\"mst1\": \"" + out.getEmpMenuMaster() + "\","
					+ "\"mst2\": \"" + out.getUsrMenuPermission() + "\","
					+ "\"mst3\": \"" + out.getDptMenu() + "\","
					+ "\"mst4\": \"" + out.getContractMenu() + "\","
					+ "\"mst5\": \"" + out.getContractGroupMenu() + "\","
					+ "\"mst6\": \"" + out.getLocationMenu() + "\","
					+ "\"mst7\": \"" + out.getCourierMenu() + "\","
					+ "\"mst8\": \"" + out.getContMstViewMenu() + "\","
					+ "\"mst9\": \"" + out.getCourierRateMenu()+ "\"," 
					+ "\"out1\": \"" + out.getOutEntryMenu() + "\","
					+ "\"out2\": \"" + out.getOutEntryDispMenu() + "\","
					+ "\"out3\": \"" + out.getReturnEntryModMenu() + "\","
					+ "\"out4\": \"" + out.getReturnMenu() + "\","
					+ "\"out5\": \"" + out.getConsignModMenu() + "\","
					+ "\"ine1\": \"" + out.getInEntryMenu() + "\","
					+ "\"ine2\": \"" + out.getCourierReturnMenu() + "\","
					+ "\"ine3\": \"" + out.getIndAckMenu() + "\","
					+ "\"ine4\": \"" + out.getEntryAckMenu() + "\","
					+ "\"rpt1\": \"" + out.getIncommingRptMenu() + "\","
					+ "\"rpt2\": \"" + out.getOutSumRptMenu() + "\","
					+ "\"rpt3\": \"" + out.getReturnRptMenu() + "\","
					+ "\"rpt4\": \"" + out.getOutDtlRptMenu() + "\"},");
		}
		jsonString.append("]");
		if (jsonString.indexOf("]") > 1) {
			jsonString.deleteCharAt(jsonString.indexOf("]") - 1);
		}
		return jsonString.toString();
	}	
	*/
	@RequestMapping(value = "/employeeDetailAjax",method = RequestMethod.GET,headers="Accept=*/*")
	public @ResponseBody Set<String> getEmployeeDetails(@RequestParam("term") String query,@RequestParam("senderType") String senderType) {


		   Set<String> list = permissionLogic.getEmployeeDetails(senderType,query);
	
		   return list;
}
}
