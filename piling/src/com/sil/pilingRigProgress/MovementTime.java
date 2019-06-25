package com.sil.pilingRigProgress;

public class MovementTime {

	private String movementHourStart;
	private String movementMinuteStart;
	private String movementHourEnd;
	private String movementMinuteEnd;
	private String from_pile;
	private String to_pile;
	public MovementTime(String movementHourStart,String movementMinuteStart,String movementHourEnd,String movementMinuteEnd,String from_pile,String to_pile){
		
		this.movementHourStart=movementHourStart;
		this.movementMinuteStart=movementMinuteStart;
		this.movementHourEnd=movementHourEnd;
		this.movementMinuteEnd=movementMinuteEnd;
		this.from_pile=from_pile;
		this.to_pile=to_pile;
		
}

	public String getMovementHourStart() {
		return movementHourStart;
	}

	public void setMovementHourStart(String movementHourStart) {
		this.movementHourStart = movementHourStart;
	}

	public String getMovementMinuteStart() {
		return movementMinuteStart;
	}

	public void setMovementMinuteStart(String movementMinuteStart) {
		this.movementMinuteStart = movementMinuteStart;
	}

	public String getMovementHourEnd() {
		return movementHourEnd;
	}

	public void setMovementHourEnd(String movementHourEnd) {
		this.movementHourEnd = movementHourEnd;
	}

	public String getMovementMinuteEnd() {
		return movementMinuteEnd;
	}

	public void setMovementMinuteEnd(String movementMinuteEnd) {
		this.movementMinuteEnd = movementMinuteEnd;
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
	
	
}