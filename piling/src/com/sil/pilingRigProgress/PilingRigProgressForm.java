package com.sil.pilingRigProgress;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

//@DateTimeFormat(pattern="dd-MM-yyyy")

public class PilingRigProgressForm {
	private Map<String,String> boringMinuteMap;
	private String boringMinute;
	private String boringMinuteEnd;
	private Map<String,String> boringHourMap;
	public String boringHour;
	public String boringHourEnd;
	public Map<String, String> getBoringMinuteMap() {
		return boringMinuteMap;
	}
	public void setBoringMinuteMap(Map<String, String> boringMinuteMap) {
		this.boringMinuteMap = boringMinuteMap;
	}
	public String getBoringMinute() {
		return boringMinute;
	}
	public void setBoringMinute(String boringMinute) {
		this.boringMinute = boringMinute;
	}
	public Map<String, String> getBoringHourMap() {
		return boringHourMap;
	}
	public void setBoringHourMap(Map<String, String> boringHourMap) {
		this.boringHourMap = boringHourMap;
	}
	public String getBoringHour() {
		return boringHour;
	}
	public void setBoringHour(String boringHour) {
		this.boringHour = boringHour;
	}
	

	public String getBoringMinuteEnd() {
		return boringMinuteEnd;
	}
	public void setBoringMinuteEnd(String boringMinuteEnd) {
		this.boringMinuteEnd = boringMinuteEnd;
	}
	public String getBoringHourEnd() {
		return boringHourEnd;
	}
	public void setBoringHourEnd(String boringHourEnd) {
		this.boringHourEnd = boringHourEnd;
	}


	private Map<String,String> movementMinuteMap;
	private String movementMinute;
	private String movementMinuteEnd;
	private Map<String,String> movementHourMap;
	public String movementHour;
	public String movementHourEnd;
	private String rigMovementDetail;
	private String from_pile;
	private String to_pile;


	public Map<String, String> getMovementMinuteMap() {
		return movementMinuteMap;
	}

	public void setMovementMinuteMap(Map<String, String> movementMinuteMap) {
		this.movementMinuteMap = movementMinuteMap;
	}

	public String getMovementMinute() {
		return movementMinute;
	}

	public void setMovementMinute(String movementMinute) {
		this.movementMinute = movementMinute;
	}

	public Map<String, String> getMovementHourMap() {
		return movementHourMap;
	}

	public void setMovementHourMap(Map<String, String> movementHourMap) {
		this.movementHourMap = movementHourMap;
	}

	public String getMovementHour() {
		return movementHour;
	}

	public void setMovementHour(String movementHour) {
		this.movementHour = movementHour;
	}
	
	
	public String getMovementMinuteEnd() {
		return movementMinuteEnd;
	}
	public void setMovementMinuteEnd(String movementMinuteEnd) {
		this.movementMinuteEnd = movementMinuteEnd;
	}
	public String getMovementHourEnd() {
		return movementHourEnd;
	}
	public void setMovementHourEnd(String movementHourEnd) {
		this.movementHourEnd = movementHourEnd;
	}


	public String getRigMovementDetail() {
		return rigMovementDetail;
	}
	public void setRigMovementDetail(String rigMovementDetail) {
		this.rigMovementDetail = rigMovementDetail;
	}


	public String getFrom_pile() {
		return from_pile;
	}
	public void setFrom_pile(String from_pile) {
		this.from_pile = from_pile;
	}
	public String getTo_pile() {
		return to_pile;
	}
	public void setTo_pile(String to_pile) {
		this.to_pile = to_pile;
	}


	private Map<String,String> idleMinuteMap;
	private String idleMinute;
	private Map<String,String> idleHourMap;
	public String idleHour;
	public String idleHourEnd;
	private String idleMinuteEnd;
	private String idleReason;

	public Map<String, String> getIdleMinuteMap() {
		return idleMinuteMap;
	}

	public void setIdleMinuteMap(Map<String, String> idleMinuteMap) {
		this.idleMinuteMap = idleMinuteMap;
	}

	public String getIdleMinute() {
		return idleMinute;
	}

	public void setIdleMinute(String idleMinute) {
		this.idleMinute = idleMinute;
	}

	public Map<String, String> getIdleHourMap() {
		return idleHourMap;
	}

	public void setIdleHourMap(Map<String, String> idleHourMap) {
		this.idleHourMap = idleHourMap;
	}

	public String getIdleHour() {
		return idleHour;
	}

	public void setIdleHour(String idleHour) {
		this.idleHour = idleHour;
	}
	
	
	public String getIdleHourEnd() {
		return idleHourEnd;
	}
	public void setIdleHourEnd(String idleHourEnd) {
		this.idleHourEnd = idleHourEnd;
	}
	public String getIdleMinuteEnd() {
		return idleMinuteEnd;
	}
	public void setIdleMinuteEnd(String idleMinuteEnd) {
		this.idleMinuteEnd = idleMinuteEnd;
	}
	public String getIdleReason() {
		return idleReason;
	}
	public void setIdleReason(String idleReason) {
		this.idleReason = idleReason;
	}


	private Map<String,String> breakdownMinuteMap;
	private String breakdownMinute;
	private String breakdownMinuteEnd;
	private Map<String,String> breakdownHourMap;
	public String breakdownHour;
	public String breakdownHourEnd;
	private String breakdownReason;
	private String actionTakenAgainstBreakdown;
	private String breakdownDetails;
	public Map<String, String> getBreakdownMinuteMap() {
		return breakdownMinuteMap;
	}

	public void setBreakdownMinuteMap(Map<String, String> breakdownMinuteMap) {
		this.breakdownMinuteMap = breakdownMinuteMap;
	}

	public String getBreakdownMinute() {
		return breakdownMinute;
	}

	public void setBreakdownMinute(String breakdownMinute) {
		this.breakdownMinute = breakdownMinute;
	}

	public String getBreakdownMinuteEnd() {
		return breakdownMinuteEnd;
	}
	public void setBreakdownMinuteEnd(String breakdownMinuteEnd) {
		this.breakdownMinuteEnd = breakdownMinuteEnd;
	}
	public String getBreakdownHourEnd() {
		return breakdownHourEnd;
	}
	public void setBreakdownHourEnd(String breakdownHourEnd) {
		this.breakdownHourEnd = breakdownHourEnd;
	}
	public Map<String, String> getBreakdownHourMap() {
		return breakdownHourMap;
	}

	public void setBreakdownHourMap(Map<String, String> breakdownHourMap) {
		this.breakdownHourMap = breakdownHourMap;
	}

	public String getBreakdownHour() {
		return breakdownHour;
	}

	public void setBreakdownHour(String breakdownHour) {
		this.breakdownHour = breakdownHour;
	}
	

	public String getBreakdownReason() {
		return breakdownReason;
	}
	public void setBreakdownReason(String breakdownReason) {
		this.breakdownReason = breakdownReason;
	}


	public String getActionTakenAgainstBreakdown() {
		return actionTakenAgainstBreakdown;
	}
	public void setActionTakenAgainstBreakdown(String actionTakenAgainstBreakdown) {
		this.actionTakenAgainstBreakdown = actionTakenAgainstBreakdown;
	}


	public String getBreakdownDetails() {
		return breakdownDetails;
	}
	public void setBreakdownDetails(String breakdownDetails) {
		this.breakdownDetails = breakdownDetails;
	}


	private Map zoneMap;
	private Map siteMap;
	private Map contractMap;
	private Map rigMap;

	private String zoneCode;
	private String siteCode;
	private String contractCode;

	private String siteName;
	private String contractName;
	private String rigCode;

	public Map getZoneMap() {
		return zoneMap;
	}
	public void setZoneMap(Map zoneMap) {
		this.zoneMap = zoneMap;
	}
	public Map getSiteMap() {
		return siteMap;
	}
	public void setSiteMap(Map siteMap) {
		this.siteMap = siteMap;
	}
	public Map getContractMap() {
		return contractMap;
	}
	public void setContractMap(Map contractMap) {
		this.contractMap = contractMap;
	}
	public Map getRigMap() {
		return rigMap;
	}
	public void setRigMap(Map rigMap) {
		this.rigMap = rigMap;
	}
	public String getZoneCode() {
		return zoneCode;
	}
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getRigCode() {
		return rigCode;
	}
	public void setRigCode(String rigCode) {
		this.rigCode = rigCode;
	}
	private String rigName;
	private String rigNo;
	private String rigLocation;
	private String pileNo;

	public String getRigName() {
		return rigName;
	}
	public void setRigName(String rigName) {
		this.rigName = rigName;
	}
	public String getRigNo() {
		return rigNo;
	}
	public void setRigNo(String rigNo) {
		this.rigNo = rigNo;
	}
	public String getRigLocation() {
		return rigLocation;
	}
	public void setRigLocation(String rigLocation) {
		this.rigLocation = rigLocation;
	}
	public String getPileNo() {
		return pileNo;
	}
	public void setPileNo(String pileNo) {
		this.pileNo = pileNo;
	}	
	 
	public String boreLength;
	public String concreteVolume;
	public String concreteLength;
	public String emptyBore;

	public String getBoreLength() {
		return boreLength;
	}
	public void setBoreLength(String boreLength) {
		this.boreLength = boreLength;
	}
	public String getConcreteVolume() {
		return concreteVolume;
	}
	public void setConcreteVolume(String concreteVolume) {
		this.concreteVolume = concreteVolume;
	}
	public String getConcreteLength() {
		return concreteLength;
	}
	public void setConcreteLength(String concreteLength) {
		this.concreteLength = concreteLength;
	}
	public String getEmptyBore() {
		return emptyBore;
	}
	public void setEmptyBore(String emptyBore) {
		this.emptyBore = emptyBore;
	}
	
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dataDate;


	
	public Date getDataDate() {
		return dataDate;
	}
	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}


	private String contract_no;
	
	private String site_no;
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	public String getSite_no() {
		return site_no;
	}
	public void setSite_no(String site_no) {
		this.site_no = site_no;
	}
	
	private String rig_no;
	private String rig_name;
	public String getRig_no() {
		return rig_no;
	}
	public void setRig_no(String rig_no) {
		this.rig_no = rig_no;
	}
	public String getRig_name() {
		return rig_name;
	}
	public void setRig_name(String rig_name) {
		this.rig_name = rig_name;
	}
	
	private String pileName;
	public String getPileName() {
		return pileName;
	}
	public void setPileName(String pileName) {
		this.pileName = pileName;
	}
	
	
	
	// ///for multiple addition///////////

	List<IdleTime> idleTimes = new ArrayList<IdleTime>();
	public List<IdleTime> getIdleTimes() {
		return idleTimes;
	}
	public void setIdleTimes(List<IdleTime> idleTimes) {
		this.idleTimes = idleTimes;
	}
	List<BreakdownTime> breakdownTimes = new ArrayList<BreakdownTime>();
	public List<BreakdownTime> getBreakdownTimes() {
		return breakdownTimes;
	}
	public void setBreakdownTimes(List<BreakdownTime> breakdownTimes) {
		this.breakdownTimes = breakdownTimes;
	}

	List<MovementTime> movementTimes = new ArrayList<MovementTime>();
	public List<MovementTime> getMovementTimes() {
		return movementTimes;
	}
	public void setMovementTimes(List<MovementTime> movementTimes) {
		this.movementTimes = movementTimes;
	}
	
}
