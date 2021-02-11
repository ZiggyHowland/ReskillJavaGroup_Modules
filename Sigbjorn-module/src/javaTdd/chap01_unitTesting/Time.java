package javaTdd.chap01_unitTesting;

public class Time {
	private int secondsSinceMidnight;
	
	private static final int SECONDS_PER_MINUTE = 60;
	//private static final int SECONDS_PER_HOUR = 360; BUG 2
	private static final int SECONDS_PER_HOUR = 3600;

	// Constructors.
	public Time() {
		this.secondsSinceMidnight = 0;
	}

	public Time(int hours, int minutes, int seconds) {
		this.secondsSinceMidnight = toSeconds(hours, minutes, seconds);
	}
	
	// Accessor methods.
	public int getHour() { //
		return this.secondsSinceMidnight / SECONDS_PER_HOUR;
	}
	
	public int getMinute() {
		int secondsIntoHour = this.secondsSinceMidnight % SECONDS_PER_HOUR;
		return secondsIntoHour / SECONDS_PER_MINUTE;
	}
	
	public int getSecond() {
		// BUG 3
		//int secondsIntoHour = this.secondsSinceMidnight % SECONDS_PER_HOUR;
		//return secondsIntoHour / SECONDS_PER_MINUTE;
		return this.secondsSinceMidnight - toSeconds(this.getHour(), this.getMinute(), 0);

	}

	// Math method.
	public void add(int hours, int minutes, int seconds) {
		this.secondsSinceMidnight += toSeconds(hours, minutes, seconds);
	}

	public void subtract(Time time) {
		if (this.equals(time)) {
			this.secondsSinceMidnight = 0;
		}
		else if (toSeconds(this.getHour(), this.getMinute(), this.getSecond()) < toSeconds(time.getHour(), time.getMinute(), time.getSecond())  ) {
			throw new IndexOutOfBoundsException();
		}
		else {
			this.secondsSinceMidnight -= toSeconds(time.getHour(), time.getMinute(), time.getSecond());
		}

	}


	
	// Overrides from Object.
	@Override
	public boolean equals(Object other) {
		if (other instanceof Time) {
			Time otherTime = (Time)other;
			return this.secondsSinceMidnight == otherTime.secondsSinceMidnight;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return this.secondsSinceMidnight;
	} // hash?


	@Override
	public String toString() {
		//BUG 1: return String.format("%d:%d:%d", this.getHour(), this.getMinute(), this.getMinute());
		return String.format("%02d:%02d:%02d", this.getHour(), this.getMinute(), this.getSecond());
	}


	// Internal helper methods...
	private static int toSeconds(int hours, int minutes, int seconds) {
		//return hours * SECONDS_PER_HOUR + minutes * SECONDS_PER_MINUTE + seconds; // BUG 1
		return (hours * SECONDS_PER_HOUR) + (minutes * SECONDS_PER_MINUTE) + seconds;
	}
}
