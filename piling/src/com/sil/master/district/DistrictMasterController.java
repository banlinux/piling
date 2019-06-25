/**
 * 
 */
package com.sil.master.district;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sil.master.region.RegionMasterBean;
import com.sil.master.state.StateMasterBean;


@Controller
@RequestMapping("districtMaster.htm")
public class DistrictMasterController {
	private DistrictMasterLogic districtMasterLogic;
	private DistrictMasterValidator districtMasterValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	 public String getInitPage(ModelMap map){
		 DistrictMasterBean bean=new DistrictMasterBean();
		 bean.setCountryMap(districtMasterLogic.getCountryMap());
		 map.addAttribute("districtMasterBean", bean);
		 return "master/districtMaster";
	 }
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(districtMasterValidator);
	}
	
	@RequestMapping(params="_save",method = RequestMethod.POST)
	public String submitPage(@Validated DistrictMasterBean bean,BindingResult result){
		if (result.hasErrors()) {
			return  "master/districtMaster";
		}
		districtMasterLogic.saveDistrict(bean);
		return "redirect:districtMaster.htm";
	}
	
	@RequestMapping(params="_modify",method = RequestMethod.POST)
	public String modifyPage(@Validated DistrictMasterBean bean,BindingResult result){
		if (result.hasErrors()) {
			return  "master/districtMaster";
		}
		districtMasterLogic.modifyDistrict(bean);
		return "redirect:districtMaster.htm";
	}
	
	@RequestMapping(params="_delete",method = RequestMethod.POST)
	public String deletePage(@Validated DistrictMasterBean bean,BindingResult result){
		if (result.hasErrors()) {
			return  "master/districtMaster";
		}
		districtMasterLogic.deleteDistrict(bean);
		return "redirect:districtMaster.htm";
	}
	
	
	
	@RequestMapping(params="_target1", headers = "Accept=*/*",method=RequestMethod.POST )	
	 public @ResponseBody String getLocationDetails( HttpServletRequest request,String stateCode){	
		 
		 List <DistrictMasterBean> list=districtMasterLogic.getDistrictDetails(stateCode);
		 StringBuffer jsonString=new StringBuffer();
		 jsonString.append("[");
		 for(DistrictMasterBean out:list){
			 jsonString.append("{\"stateCode\": \""+out.getStateCode()+"\",\"districtCode\": \""+out.getDistrictCode()+"\",\"districtName\": \""+out.getDistrictName()+"\"},"); 
		 }
		 jsonString.append("]"); 
	 	if(jsonString.indexOf("]")>1){
	 		jsonString.deleteCharAt(jsonString.indexOf("]")-1);
	 	}
			return jsonString.toString();
		
	 }
	
	
	@RequestMapping(params="_target2", headers = "Accept=*/*",method=RequestMethod.POST )	
	 public @ResponseBody String getStateDetails( HttpServletRequest request,String regionCode){	
		 
		 List <StateMasterBean> list=districtMasterLogic.getStateDetails(regionCode);
		 StringBuffer jsonString=new StringBuffer();
		 jsonString.append("[");
		 for(StateMasterBean out:list){
			 jsonString.append("{\"stateCode\": \""+out.getStateCode()+"\",\"stateName\": \""+out.getStateName()+"\"},"); 
		 }
		 jsonString.append("]"); 
	 	if(jsonString.indexOf("]")>1){
	 		jsonString.deleteCharAt(jsonString.indexOf("]")-1);
	 	}
			return jsonString.toString();
		
	 }

	/**
	 * @param districtMasterLogic the districtMasterLogic to set
	 */
	@Autowired
	public void setDistrictMasterLogic(DistrictMasterLogic districtMasterLogic) {
		this.districtMasterLogic = districtMasterLogic;
	}

	/**
	 * @param districtMasterValidator the districtMasterValidator to set
	 */
	@Autowired
	public void setDistrictMasterValidator(
			DistrictMasterValidator districtMasterValidator) {
		this.districtMasterValidator = districtMasterValidator;
	}

}
