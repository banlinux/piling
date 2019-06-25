/**
 * 
 */
package com.sil.master.region;

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



/**
 * @author sumanta roy
 *
 */
@Controller
@RequestMapping("regionMaster.htm")
public class RegionMasterController {
	private RegionMasterLogic regionMasterLogic;
	private RegionMasterValidator regionMasterValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	 public String getInitPage(ModelMap map){
		 RegionMasterBean bean=new RegionMasterBean();
		 bean.setCountryMap(regionMasterLogic.getCountryMap());
		 map.addAttribute("regionMasterBean", bean);
		 return "master/regionMaster";
	 }
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(regionMasterValidator);
	}
	
	@RequestMapping(params="_save",method = RequestMethod.POST)
	public String submitPage(@Validated RegionMasterBean bean,BindingResult result){
		if (result.hasErrors()) {
			return  "master/regionMaster";
		}
		regionMasterLogic.saveRegion(bean);
		return "redirect:regionMaster.htm";
	}
	
	@RequestMapping(params="_modify",method = RequestMethod.POST)
	public String modifyPage(@Validated RegionMasterBean bean,BindingResult result){
		if (result.hasErrors()) {
			return  "master/regionMaster";
		}
		regionMasterLogic.modifyRegion(bean);
		return "redirect:regionMaster.htm";
	}
	
	@RequestMapping(params="_delete",method = RequestMethod.POST)
	public String deletePage(@Validated RegionMasterBean bean,BindingResult result){
		if (result.hasErrors()) {
			return  "master/regionMaster";
		}
		regionMasterLogic.deleteRegion(bean);
		return "redirect:regionMaster.htm";
	}
	
	
	
	@RequestMapping(params="_target1", headers = "Accept=*/*",method=RequestMethod.POST )	
	 public @ResponseBody String getLocationDetails( HttpServletRequest request,String countryCode){	
		 
		 List <RegionMasterBean> list=regionMasterLogic.getRegionDetails(countryCode);
		 StringBuffer jsonString=new StringBuffer();
		 jsonString.append("[");
		 for(RegionMasterBean out:list){
			 jsonString.append("{\"countryCode\": \""+out.getCountryCode()+"\",\"regionName\": \""+out.getRegionName()+"\",\"regionCode\": \""+out.getRegionCode()+"\"},"); 
		 }
		 jsonString.append("]"); 
	 	if(jsonString.indexOf("]")>1){
	 		jsonString.deleteCharAt(jsonString.indexOf("]")-1);
	 	}
			return jsonString.toString();
		
	 }

	/**
	 * @param regionMasterLogic the regionMasterLogic to set
	 */
	@Autowired
	public void setRegionMasterLogic(RegionMasterLogic regionMasterLogic) {
		this.regionMasterLogic = regionMasterLogic;
	}

	/**
	 * @param regionMasterValidator the regionMasterValidator to set
	 */
	@Autowired
	public void setRegionMasterValidator(RegionMasterValidator regionMasterValidator) {
		this.regionMasterValidator = regionMasterValidator;
	}

}
