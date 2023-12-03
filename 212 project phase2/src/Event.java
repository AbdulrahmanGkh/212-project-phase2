import java.util.Date;
public class Event_ {
	public String eventTitle;
	public String dateAndTime;
	public String time;
	public String location;
	public boolean appointment;
	public EventList<Contact_> listContact;

	public Event_() {
		this.eventTitle=null;
		this.dateAndTime=null;
		this.time=null;
		this.location=null;
	}
	
	public Event_(String eventTitle,String dateAndTime,String location,boolean appointment) {
		this.eventTitle = eventTitle;
		this.dateAndTime=dateAndTime;
		this.location = location;
		this.appointment=appointment;
		listContact=new EventList<Contact_>();
	}

	
//setters and getters
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	
	public String getDateAndTime() {
		return dateAndTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isAppointment() {
		return appointment;
	}

	public void setAppointment(boolean appointment) {
		this.appointment = appointment;
	}
	

}
