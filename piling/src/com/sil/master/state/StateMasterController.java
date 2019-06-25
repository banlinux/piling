/**
 * 
 */
package com.sil.master.state;

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

/**
 * @author sumanta roy
 * 
 */
@Controller
@RequestMapping("stateMaster.htm")
public class StateMasterController {
	private StateMasterLogic stateMasterLogic;
	private StateMasterValidator stateMasterValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String getInitPage(ModelMap map) {
		StateMasterBean bean = new StateMasterBean();
		bean.setCountryMap(stateMasterLogic.getCountryMap());
		map.addAttribute("stateMasterBean", bean);
		return "master/stateMaster";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(stateMasterValidator);
	}

	@RequestMapping(params = "_save", method = RequestMethod.POST)
	public String submitPage(@Validated StateMasterBean bean,BindingResult result) {
		if (result.hasErrors()) {
			return  "master/stateMaster";
		}
		stateMasterLogic.saveState(bean);
		return "redirect:stateMaster.htm";
	}

	@RequestMapping(params = "_modify", method = RequestMethod.POST)
	public String modifyPage(@Validated StateMasterBean bean,BindingResult result) {
		if (result.hasErrors()) {
			return  "master/stateMaster";
		}
		stateMasterLogic.modifyState(bean);
		return "redirect:stateMaster.htm";
	}

	@RequestMapping(params = "_delete", method = RequestMethod.POST)
	public String deletePage(@Validated StateMasterBean bean,BindingResult result) {
		if (result.hasErrors()) {
			return  "master/stateMaster";
		}
		stateMasterLogic.deleteState(bean);
		return "redirect:stateMaster.htm";
	}

	@RequestMapping(params = "_target1", headers = "Accept=*/*", method = RequestMethod.POST)
	public @ResponseBody
	String getLocationDetails(HttpServletRequest request, String regionCode) {
		List<StateMasterBean> list = stateMasterLogic
				.getStateDetails(regionCode);
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("[");
		for (StateMasterBean out : list) {
			jsonString.append("{\"countryCode\": \"" + out.getCountryCode()
					+ "\",\"regionCode\": \"" + out.getRegionCode()
					+ "\",\"stateCode\": \"" + out.getStateCode()
					+ "\",\"stateName\": \"" + out.getStateName() + "\"},");
		}
		jsonString.append("]");
		if (jsonString.indexOf("]") > 1) {
			jsonString.deleteCharAt(jsonString.indexOf("]") - 1);
		}
		return jsonString.toString();

	}

	@RequestMapping(params = "_target2", headers = "Accept=*/*", method = RequestMethod.POST)
	public @ResponseBody
	String getRegionDetails(HttpServletRequest request, String countryCode,
			String regionCode) {

		List<RegionMasterBean> list = stateMasterLogic
				.getRegionDetails(countryCode);
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("[");
		for (RegionMasterBean out : list) {
			jsonString.append("{\"regionCode\": \"" + out.getRegionCode()
					+ "\",\"regionName\": \"" + out.getRegionName() + "\"},");
		}
		jsonString.append("]");
		if (jsonString.indexOf("]") > 1) {
			jsonString.deleteCharAt(jsonString.indexOf("]") - 1);
		}
		return jsonString.toString();

	}

	/**
	 * @param stateMasterLogic
	 *            the stateMasterLogic to set
	 */
	@Autowired
	public void setStateMasterLogic(StateMasterLogic stateMasterLogic) {
		this.stateMasterLogic = stateMasterLogic;
	}

	/**
	 * @param stateMasterValidator
	 *            the stateMasterValidator to set
	 */
	@Autowired
	public void setStateMasterValidator(
			StateMasterValidator stateMasterValidator) {
		this.stateMasterValidator = stateMasterValidator;
	}

}
