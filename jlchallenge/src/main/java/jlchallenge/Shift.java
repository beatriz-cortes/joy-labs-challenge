package jlchallenge;

public class Shift {
	
	private int guardId;
	private int sleepStarts;
	private int sleepEnds;
	private int sleepTime;
	
	public int getGuardId() {
		return this.guardId;
	}
	public int getSleepStarts() {
		return sleepStarts;
	}
	public int getSleepEnds() {
		return sleepEnds;
	}
	public int getSleepTime() {
		return sleepTime;
	}
	

	public void setGuardId(int guardId) {
		this.guardId = guardId;
	}
	public void setSleepStarts(int sleepStarts) {
		this.sleepStarts = sleepStarts;
	}
	public void setSleepEnds(int sleepEnds) {
		this.sleepEnds = sleepEnds;
		this.sleepTime = this.sleepEnds - this.sleepStarts;
	}

}

