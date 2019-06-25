package com.sil.pilingRigProgress;
import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.sil.master.district.DistrictMasterBean;
import com.sil.master.region.RegionMasterBean;
import com.sil.pile.PileMasterBean;
import com.sil.pilingRigProgress.PilingRigProgressForm;
import com.sil.pilingRigProgress.PilingRigProgressLogic;
import com.sil.rig.RigMasterBean;
import com.sil.util.CommonFunctionDao;

@Controller
@RequestMapping("/pilingRigProgressForm")
@SessionAttributes("pilingRigProgressForm")
public class PilingRigProgressController {
	public List<IdleTime> otherQualifications = new ArrayList<IdleTime>();
	private PilingRigProgressLogic pilingRigProgressLogic;
	private CommonFunctionDao commonFunctionDao;


	@Autowired
	public void setPilingRigProgressLogic(PilingRigProgressLogic pilingRigProgressLogic) {
		this.pilingRigProgressLogic = pilingRigProgressLogic;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String getInitialPage(HttpServletRequest request,Map map){
		HttpSession session = request.getSession(true);

		

		PilingRigProgressForm bean = new PilingRigProgressForm();
		
//		bean.setZoneMap(pilingRigProgressLogic.getZoneMap()); Removed as asked by BDM
	
			Map<String,String> boringHourMap = new LinkedHashMap<String,String>();
			for(int i=0;i<=23;i++){
				boringHourMap.put(Integer.toString(i),Integer.toString(i));
			}
			Map<String,String> boringMinuteMap = new LinkedHashMap<String,String>();
			for(int i=0;i<=59;i++){
				boringMinuteMap.put(Integer.toString(i),Integer.toString(i));
			}
			bean.setBoringHourMap(boringHourMap);
			bean.setBoringMinuteMap(boringMinuteMap);
			
			
			Map<String,String> movementHourMap = new LinkedHashMap<String,String>();
			for(int i=0;i<=23;i++){
				movementHourMap.put(Integer.toString(i),Integer.toString(i));
			}
			Map<String,String> movementMinuteMap = new LinkedHashMap<String,String>();
			for(int i=0;i<=59;i++){
				movementMinuteMap.put(Integer.toString(i),Integer.toString(i));
			}
			bean.setMovementHourMap(movementHourMap);
			bean.setMovementMinuteMap(movementMinuteMap);
			
			
			Map<String,String> idleHourMap = new LinkedHashMap<String,String>();
			for(int i=0;i<=23;i++){
				idleHourMap.put(Integer.toString(i),Integer.toString(i));
			}
			Map<String,String>idleMinuteMap = new LinkedHashMap<String,String>();
			for(int i=0;i<=59;i++){
				idleMinuteMap.put(Integer.toString(i),Integer.toString(i));
			}
			bean.setIdleHourMap(idleHourMap);
			bean.setIdleMinuteMap(idleMinuteMap);
			
			
			Map<String,String> breakdownHourMap = new LinkedHashMap<String,String>();
			for(int i=0;i<=23;i++){
				breakdownHourMap.put(Integer.toString(i),Integer.toString(i));
			}
			Map<String,String>breakdownMinuteMap = new LinkedHashMap<String,String>();
			for(int i=0;i<=59;i++){
				breakdownMinuteMap.put(Integer.toString(i),Integer.toString(i));
			}
			bean.setBreakdownHourMap(breakdownHourMap);
			bean.setBreakdownMinuteMap(breakdownMinuteMap);
			map.put("pilingRigProgressForm", bean);
		return  "rig/pilingRigProgressForm";
	}
//	@RequestMapping(params="_target2", headers = "Accept=*/*",method=RequestMethod.POST )	Asked by BDM
/*	 public @ResponseBody String getSiteDetails( HttpServletRequest request,String zoneCode){	
		 List <PilingRigProgressForm> list=pilingRigProgressLogic.getSiteDetails(zoneCode);
		 StringBuffer jsonString=new StringBuffer();
		 jsonString.append("[");
		 for(PilingRigProgressForm out:list){
			// jsonString.append("{\"siteCode\": \""+out.getSiteCode()+"\",\" siteName\": \""+out.getSiteName()+"\"},");
			 jsonString.append("{\"siteCode\": \""+out.getSiteCode()+"\",\"siteName\": \""+out.getSiteName().replace("\"", "'")+"\"},"); 
		 }
		 jsonString.append("]"); 
	 	if(jsonString.indexOf("]")>1){
	 		jsonString.deleteCharAt(jsonString.indexOf("]")-1);
	 	}
	 	System.out.println(jsonString.toString());
			return jsonString.toString();
		
	 }
*/	
	@RequestMapping(params="_target3", headers = "Accept=*/*",method=RequestMethod.POST )	
	 public @ResponseBody String getContractDetails( HttpServletRequest request,String siteCode){	
		System.out.println("Controller");
		 List <PilingRigProgressForm> list=pilingRigProgressLogic.getContractDetails(siteCode);
		 System.out.println("back to Controller");
		 StringBuffer jsonString=new StringBuffer();
		 jsonString.append("[");
		 for(PilingRigProgressForm out:list){
			 System.out.println(out.getContractCode()+out.getContractName());
			 jsonString.append("{\"contractCode\": \""+out.getContractCode()+"\",\"contractName\": \""+out.getContractName().replace("\"", "'")+"\"},"); 
		 }
		 jsonString.append("]"); 
	 	if(jsonString.indexOf("]")>1){
	 		jsonString.deleteCharAt(jsonString.indexOf("]")-1);
	 	}
	 	
	 	System.out.println(jsonString.toString());
			return jsonString.toString();
		
	 }
	@RequestMapping(value = "/pilingRigProgressFormAjax",method = RequestMethod.GET,headers="Accept=*/*")
	public @ResponseBody Set<String> getContractDetails(@RequestParam("term") String query,@RequestParam("senderType") String senderType) {
		System.out.println("senderType=="+senderType+"=query="+query);
		   Set<String> list = pilingRigProgressLogic.getContractDetails(senderType,query);
		   return list;
	}
	@RequestMapping(params="_target1", headers = "Accept=*/*",method=RequestMethod.POST )	
	public @ResponseBody String getRigDetails( HttpServletRequest request,String contractNo){	
		List <String> list=pilingRigProgressLogic.getSiteDetails(contractNo);
		System.out.println(">>>>>>"+contractNo);
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
	@RequestMapping(value = "/pilingRigProgressFormRig",method = RequestMethod.GET,headers="Accept=*/*")
	public @ResponseBody Set<String> getRigList(@RequestParam("term") String query,@RequestParam("senderType") String senderType) {

		System.out.println("senderType=="+senderType+"=query="+query);
		   Set<String> list = pilingRigProgressLogic.getRigList(senderType,query);
		   return list;
}
	@RequestMapping(value = "/pilingRigProgressFormPile",method = RequestMethod.GET,headers="Accept=*/*")
	public @ResponseBody Set<String> getSenderCodeList(@RequestParam("term") String query,@RequestParam("senderType") String senderType) {

		System.out.println("senderType=="+senderType+"=query="+query);
		   Set<String> list = pilingRigProgressLogic.getPileDetails(senderType,query);

		   return list;
}
	@RequestMapping(params="_target4", headers = "Accept=*/*",method=RequestMethod.POST )	
	 public @ResponseBody String getLocationDetails( HttpServletRequest request,String pileNo){	
		 
		 List <PileMasterBean> list=pilingRigProgressLogic.getPileDetails(pileNo);
		 StringBuffer jsonString=new StringBuffer();
		 jsonString.append("[");
		 for(PileMasterBean out:list){
			 jsonString.append("{\"pileNo\": \""+out.getPile_no()+"\",\"pileDia\": \""+out.getPile_dia()+"\",\"cageLength\": \""+out.getCage_length()+"\",\"boringLength\": \""+out.getBoring_length()+"\",\"concreteVoume\": \""+out.getConcrete_volume()+"\",\"cageDetail\": \""+out.getCage_detail()+"\",\"drawingNo\": \""+out.getDrawing_no()+"\"},");
		 }
		 jsonString.append("]"); 
	 	if(jsonString.indexOf("]")>1){
	 		jsonString.deleteCharAt(jsonString.indexOf("]")-1);
	 	}
	 	
	 	System.out.println("==11=="+jsonString);
			return jsonString.toString();
		
	 }
	@RequestMapping(params = "_target5")
	public String processFifthStep(
			final @ModelAttribute("pilingRigProgressForm") PilingRigProgressForm pilingRigProgressForm,
			ModelMap map,
			HttpServletRequest requset, HttpServletResponse response)
			throws Exception {

		pilingRigProgressLogic.setIdleTime(requset, pilingRigProgressForm);

		map.put("pilingRigProgressForm", pilingRigProgressForm);

		return ("rig/pilingRigProgressForm");

	}
	
	@RequestMapping(params = "_target6")
	public String processSixthStep(
			final @ModelAttribute("pilingRigProgressForm") PilingRigProgressForm pilingRigProgressForm,
			ModelMap map,
			HttpServletRequest requset, HttpServletResponse response)
			throws Exception {

		pilingRigProgressLogic.setBreakdownTime(requset, pilingRigProgressForm);

		map.put("pilingRigProgressForm", pilingRigProgressForm);

		return ("rig/pilingRigProgressForm");

	}
	@RequestMapping(params = "_target7")
	public String processSeventhStep(
			final @ModelAttribute("pilingRigProgressForm") PilingRigProgressForm pilingRigProgressForm,
			ModelMap map,
			HttpServletRequest requset, HttpServletResponse response)
			throws Exception {

		pilingRigProgressLogic.setMovementTime(requset, pilingRigProgressForm);

		map.put("pilingRigProgressForm", pilingRigProgressForm);

		return ("rig/pilingRigProgressForm");

	}
	@RequestMapping(params = "_save", method = RequestMethod.POST)
	public String saveDetail(@Valid PilingRigProgressForm pilingRigProgressForm,
			BindingResult result, Map map, HttpServletRequest req) {
		try {
			pilingRigProgressLogic.saveDetail(pilingRigProgressForm);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "postresume/successView";
			// return "postresume/failourMsg";
		}
		return "postresume/successView";
	}
}

