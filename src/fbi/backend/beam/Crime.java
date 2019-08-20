package fbi.backend.beam;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Crime implements Serializable {

	
	private static final long serialVersionUID = -5833063323688166339L;
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

	public String[] toStringArray() {

		String[] data = new String[4];

		data[0] = criminal.getFiscalCode();
		SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		data[1] = fmt.format(dateTime.getTime());
		data[2] = description;		
		data[3] = location;


		return data;
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
