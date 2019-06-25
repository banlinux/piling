/**
 * 
 */
package com.sil.master.country;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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

import com.sil.master.location.LocationMasterForm;


@Controller
@RequestMapping("countryMaster.htm")
public class CountryMasterController {
	static Logger log = Logger.getLogger(CountryMasterController.class.getName());
	private CountryMasterLogic countryMasterLogic;
	private CountryMasterValidator countryMasterValidator;
	@RequestMapping(method=RequestMethod.GET)
	 public String getInitPage(ModelMap map){
		 CountryMasterBean bean=new CountryMasterBean();
		 map.addAttribute("countryMasterBean", bean);
		 return "master/countryMaster";
	 }
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(countryMasterValidator);
	}
	
	@RequestMapping(params="_save",method = RequestMethod.POST)
	public String submitPage(@Validated CountryMasterBean bean,BindingResult result){
		if (result.hasErrors()) {
			return  "master/countryMaster";
		}
		countryMasterLogic.saveCountry(bean);
		return "redirect:countryMaster.htm";
	}
	
	@RequestMapping(params="_modify",method = RequestMethod.POST)
	public String modifyPage(@Validated CountryMasterBean bean,BindingResult result){
		if (result.hasErrors()) {
			return  "master/countryMaster";
		}
		countryMasterLogic.modifyCountry(bean);
		return "redirect:countryMaster.htm";
	}
	
	@RequestMapping(params="_delete",method = RequestMethod.POST)
	public String deletePage(@Validated CountryMasterBean bean,BindingResult result){
		if (result.hasErrors()) {
			return  "master/countryMaster";
		}
		countryMasterLogic.deleteCountry(bean);
		return "redirect:countryMaster.htm";
	}
	
	
	
	@RequestMapping(params="_target1", headers = "Accept=*/*",method=RequestMethod.POST )	
	 public @ResponseBody String getLocationDetails( HttpServletRequest request){	
		 
		 List <CountryMasterBean> list=countryMasterLogic.getCountryDetails();
		 StringBuffer jsonString=new StringBuffer();
		 jsonString.append("[");
		 for(CountryMasterBean out:list){
			 jsonString.append("{\"countryCode\": \""+out.getCountryCode()+"\",\"countryName\": \""+out.getCountryName()+"\"},"); 
		 }
		 jsonString.append("]"); 
	 	if(jsonString.indexOf("]")>1){
	 		jsonString.deleteCharAt(jsonString.indexOf("]")-1);
	 	}
	 	
	 	System.out.println("==11=="+jsonString);
			return jsonString.toString();
		
	 }

	

	/**
	 * @param countryMasterLogic the countryMasterLogic to set
	 */
	@Autowired
	public void setCountryMasterLogic(CountryMasterLogic countryMasterLogic) {
		this.countryMasterLogic = countryMasterLogic;
	}

	/**
	 * @param countryMasterValidator the countryMasterValidator to set
	 */
	@Autowired
	public void setCountryMasterValidator(
			CountryMasterValidator countryMasterValidator) {
		this.countryMasterValidator = countryMasterValidator;
	}

}
