package com.sil.pilingRigProgress;

public class BreakdownTime {
	private String breakdownHourStart;
	private String breakdownMinuteStart;
	private String breakdownHourEnd;
	private String breakdownMinuteEnd;
	
	public BreakdownTime(String breakdownHourStart,String breakdownMinuteStart,String breakdownHourEnd,String breakdownMinuteEnd){
		this.breakdownHourStart=breakdownHourStart;
		this.breakdownMinuteStart=breakdownMinuteStart;
		this.breakdownHourEnd=breakdownHourEnd;
		this.breakdownMinuteEnd=breakdownMinuteEnd;
		
}

	public String getBreakdownHourStart() {
		return breakdownHourStart;
	}

	public void setBreakdownHourStart(String breakdownHourStart) {
		this.breakdownHourStart = breakdownHourStart;
	}

	public String getBreakdownMinuteStart() {
		return breakdownMinuteStart;
	}

	public void setBreakdownMinuteStart(String breakdownMinuteStart) {
		this.breakdownMinuteStart = breakdownMinuteStart;
	}

	public String getBreakdownHourEnd() {
		return breakdownHourEnd;
	}

	public void setBreakdownHourEnd(String breakdownHourEnd) {
		this.breakdownHourEnd = breakdownHourEnd;
	}

	public String getBreakdownMinuteEnd() {
		return breakdownMinuteEnd;
	}

	public void setBreakdownMinuteEnd(String breakdownMinuteEnd) {
		this.breakdownMinuteEnd = breakdownMinuteEnd;
	}
	
}
