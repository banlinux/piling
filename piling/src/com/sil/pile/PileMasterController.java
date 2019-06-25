package com.sil.pile;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sil.rig.RigMasterBean;
import com.sil.rig.RigMasterController;
import com.sil.rig.RigMasterLogic;
import com.sil.rig.RigMasterValidator;

@Controller
@RequestMapping("/pileMaster")
@SessionAttributes("pileMasterBean")
public class PileMasterController {
	static Logger log = Logger.getLogger(PileMasterController.class.getName());
	private PileMasterLogic pileMasterLogic;
	private PileMasterValidator pileMasterValidator;
	@RequestMapping(method=RequestMethod.GET)
	 public String getInitPage(ModelMap map){
		PileMasterBean bean=new PileMasterBean();
		 map.addAttribute("pileMasterBean", bean);
		 return "master/pileMaster";
	 }
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(pileMasterValidator);
	}
	@Autowired
	public void setPileMasterLogic(PileMasterLogic pileMasterLogic) {
		this.pileMasterLogic = pileMasterLogic;
	}
	@RequestMapping(value = "/pileMasterAjax",method = RequestMethod.GET,headers="Accept=*/*")
	public @ResponseBody Set<String> getContractDetails(@RequestParam("term") String query,@RequestParam("senderType") String senderType) {
		System.out.println("senderType=="+senderType+"=query="+query);
		   Set<String> list = pileMasterLogic.getContractDetails(senderType,query);
		   log.info("senderType=="+list);
		   return list;
	}
	@RequestMapping(params="_target1", headers = "Accept=*/*",method=RequestMethod.POST )	
	public @ResponseBody String getPileDetails( HttpServletRequest request,String contractNo){	
		List <String> list=pileMasterLogic.getSiteDetails(contractNo);
		System.out.println(contractNo);
		 StringBuffer jsonString=new StringBuffer();
		 jsonString.append("[");
		 for(String out:list){
			 jsonString.append("{\"siteCode\": \""+out.toString()+"\"},"); 
		 }
		 jsonString.append("]"); 
		if(jsonString.indexOf("]")>1){
			jsonString.deleteCharAt(jsonString.indexOf("]")-1);
		}
		
		System.out.println("==11=="+jsonString);
			return jsonString.toString();
		
	}
	@RequestMapping(params="_save",method = RequestMethod.POST)
	public String submitPage(@Validated PileMasterBean bean1,
			BindingResult result, ModelMap map, final HttpSession httpSession) {

		final String sessionToken = (String) httpSession
				.getAttribute("SESSION_TOKEN");
		log.info("*********5555*********" + sessionToken);
		/*
		 * if(StringUtils.isEmpty(sessionToken)) {
		 * System.out.println("*********666*********"); return "login/login"; }
		 */
		log.info("*********222*********");
		boolean res = pileMasterLogic.savePileMaster(bean1, httpSession);

		
		return "master/pileMaster";
		
	}
}
