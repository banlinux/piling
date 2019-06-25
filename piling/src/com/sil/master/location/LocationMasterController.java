/**
 * 
 */
package com.sil.master.location;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sumanta roy
 *
 */
@Controller
@RequestMapping("locationMaster.htm")
public class LocationMasterController {
	private LocationMasterLogic locationMasterLogic;
 @RequestMapping(method=RequestMethod.GET)
 public String getInitPage(ModelMap map){
	 LocationMasterForm bean=new LocationMasterForm();
//	 bean.setContractDetails(locationMasterLogic.contractDetails());
	 map.addAttribute("locationMasterForm", bean);
	 return "location/locationMaster";
 }
 
 
 @RequestMapping(method=RequestMethod.POST)
 public String submitPage(@ModelAttribute("locationMasterForm")LocationMasterForm bean){
	 
	 locationMasterLogic.saveLocation(bean);
	 
	 return "location/locationMaster";
 }
 
 @RequestMapping(params="_target1", headers = "Accept=*/*",method=RequestMethod.POST )	
 public @ResponseBody String getLocationDetails( HttpServletRequest request){	
	 String conCode=request.getParameter("contractCode");
	 List <LocationMasterForm> list=locationMasterLogic.getLocationDetails(conCode);
	 StringBuffer jsonString=new StringBuffer();
	 jsonString.append("[");
	 for(LocationMasterForm out:list){
		 jsonString.append("{\"contractCode\": \""+out.getContractCode()+"\",\"locationCode\": \""+out.getLocationCode()+"\"," +
					"\"lName\": \""+out.getLocationName()+"\",\"lAddress\": \""+out.getLocationAddress()+"\"," +
									"\"active\": \""+out.getActive()+"\"},"); 
	 }
	 jsonString.append("]"); 
 	if(jsonString.indexOf("]")>1){
 		jsonString.deleteCharAt(jsonString.indexOf("]")-1);
 	}
 	
 	System.out.println("==11=="+jsonString);
		return jsonString.toString();
	
 }
/**
 * @param locationMasterLogic the locationMasterLogic to set
 */
 @Autowired
public void setLocationMasterLogic(LocationMasterLogic locationMasterLogic) {
	this.locationMasterLogic = locationMasterLogic;
}

}
