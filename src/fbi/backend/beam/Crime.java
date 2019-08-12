package fbi.backend.beam;

import java.util.GregorianCalendar;

public class Crime {

	private Criminal criminal;
	private GregorianCalendar dateTime;
	private String description;
	private String location;
	
	
	
	public Crime(Criminal criminal, GregorianCalendar dateTime, String description, String location) {
		super();
		this.criminal = criminal;
		this.dateTime = dateTime;
		this.description = description;
		this.location = location;
	}
	public Criminal getCriminal() {
		return criminal;
	}
	public void setCriminal(Criminal criminal) {
		this.criminal = criminal;
	}
	public GregorianCalendar getDateTime() {
		return dateTime;
	}
	public void setDateTime(GregorianCalendar dateTime) {
		this.dateTime = dateTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
