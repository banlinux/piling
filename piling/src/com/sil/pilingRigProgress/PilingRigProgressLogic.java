package com.sil.pilingRigProgress;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sil.pile.PileMasterBean;

import com.sil.rig.RigMasterBean;
import com.sil.rig.RigMasterDao;
import com.sil.util.CommonFunctionDao;
@Repository
@Service
public class PilingRigProgressLogic {
	private PilingRigProgressDao pilingRigProgressDao;
	@Autowired	
	@Resource(name="pilingRigProgressDaoImpl")
	public void setPilingRigProgressDao(PilingRigProgressDao pilingRigProgressDao) {
		this.pilingRigProgressDao = pilingRigProgressDao;
	}
	 private CommonFunctionDao commonFunctionDao;
	 
		@Autowired
		public void setCommonFunctionDao(CommonFunctionDao commonFunctionDao) {
			this.commonFunctionDao = commonFunctionDao;
		}
	public Map getZoneMap() {
		// TODO Auto-generated method stub
		return commonFunctionDao.getZoneMap();
	}
/*	public List<PilingRigProgressForm> getSiteDetails(String zoneCode){    ASked by BDM
		return commonFunctionDao.getSiteMap(zoneCode);
	}
	*/
	public List<PilingRigProgressForm> getContractDetails(String siteCode){
		
		System.out.println("Logic");
		return commonFunctionDao.getContractDetails(siteCode);
	}
	public Set getContractDetails(String senderType,String query){
		System.out.println(senderType+":"+query);
		return pilingRigProgressDao.getContractDetails(senderType,query);
	}
	public List<String> getSiteDetails(String contractNo) {
		
		return pilingRigProgressDao.getSiteDetails(contractNo);
	}
	public Set getRigList(String senderType,String query){
		System.out.println(senderType+":"+query);
		return pilingRigProgressDao.getRigList(senderType,query);
	}
	public Set getPileDetails(String senderType,String query){
		System.out.println(senderType+":"+query);
		return pilingRigProgressDao.getPileDetails(senderType,query);
	}
	public List<PileMasterBean> getPileDetails(String pileNo) {
		
		return pilingRigProgressDao.getPileDetails(pileNo);
	}
	public void setIdleTime(HttpServletRequest requset,
			PilingRigProgressForm pilingRigProgressForm) {
		String idleHourStart=requset.getParameter("idleHourStart");
		String idleMinuteStart=requset.getParameter("idleMinuteStart");
		String idleHourEnd=requset.getParameter("idleHourEnd");
		String idleMinuteEnd=requset.getParameter("idleMinuteEnd");
System.out.println(idleHourStart+":"+idleMinuteStart+":"+idleHourEnd+":"+idleMinuteEnd);
		IdleTime it=new  IdleTime(idleHourStart,idleMinuteStart,idleHourEnd,idleMinuteEnd);
		pilingRigProgressForm.idleTimes.add(it);
		
		
	}
	
	public void setBreakdownTime(HttpServletRequest requset,
			PilingRigProgressForm pilingRigProgressForm) {
		String breakdownHourStart=requset.getParameter("breakdownHourStart");
		String breakdownMinuteStart=requset.getParameter("breakdownMinuteStart");
		String breakdownHourEnd=requset.getParameter("breakdownHourEnd");
		String breakdownMinuteEnd=requset.getParameter("breakdownMinuteEnd");
		System.out.println(breakdownHourStart+":"+breakdownMinuteStart+":"+breakdownHourEnd+":"+breakdownMinuteEnd);
		BreakdownTime it=new  BreakdownTime(breakdownHourStart,breakdownMinuteStart,breakdownHourEnd,breakdownMinuteEnd);
		pilingRigProgressForm.breakdownTimes.add(it);
		
		
	}
	public void  setMovementTime(HttpServletRequest requset,
			PilingRigProgressForm pilingRigProgressForm) {
		String movementHourStart=requset.getParameter("movementHourStart");
		String movementMinuteStart=requset.getParameter("movementMinuteStart");
		String movementHourEnd=requset.getParameter("movementHourEnd");
		String movementMinuteEnd=requset.getParameter("movementMinuteEnd");
		String fromPile=requset.getParameter("fromPile");
		String toPile=requset.getParameter("toPile");
		System.out.println(movementHourStart+":"+movementMinuteStart+":"+movementHourEnd+":"+movementMinuteEnd);
		MovementTime it=new  MovementTime(movementHourStart,movementMinuteStart,movementHourEnd,movementMinuteEnd,fromPile,toPile);
		pilingRigProgressForm.movementTimes.add(it);
		
		
	}
	public  void saveDetail(PilingRigProgressForm pilingRigProgressForm) {
		// TODO Auto-generated method stub
		pilingRigProgressDao.saveDetail(pilingRigProgressForm);

	}
}
