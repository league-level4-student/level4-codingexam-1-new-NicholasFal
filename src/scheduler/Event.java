package scheduler;

public class Event {
	public String describer;
	public int time;
	public Days day;
	
	public Event(String describer, int time, Days day) {
		this.describer = describer;
		this.time = time;
		this.day = day;
	}
	
	public String getDescriber() {
		return describer;
	}
	public void setDescriber(String describer) {
		this.describer = describer;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Days getDay() {
		return day;
	}
	public void setDay(Days day) {
		this.day = day;
	}
	public enum Days {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	}
	
}
