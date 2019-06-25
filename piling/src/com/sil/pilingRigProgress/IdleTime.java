package com.sil.pilingRigProgress;

public class IdleTime {
	private String idleHourStart;
	private String idleMinuteStart;
	private String idleHourEnd;
	private String idleMinuteEnd;
	
	public IdleTime(String idleHourStart,String idleMinuteStart,String idleHourEnd,String idleMinuteEnd){
		this.idleHourStart=idleHourStart;
		this.idleMinuteStart=idleMinuteStart;
		this.idleHourEnd=idleHourEnd;
		this.idleMinuteEnd=idleMinuteEnd;
		
		
}

	public String getIdleHourStart() {
		return idleHourStart;
	}

	public void setIdleHourStart(String idleHourStart) {
		this.idleHourStart = idleHourStart;
	}

	public String getIdleMinuteStart() {
		return idleMinuteStart;
	}

	public void setIdleMinuteStart(String idleMinuteStart) {
		this.idleMinuteStart = idleMinuteStart;
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
}