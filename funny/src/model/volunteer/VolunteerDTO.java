package model.volunteer;

public class VolunteerDTO {
	private int volunteer_number;
	private String supporter_id;
	private String volunteer_date;
	private String volunteer_time;
	
	public int getVolunteer_number() {
		return volunteer_number;
	}
	public void setVolunteer_number(int volunteer_number) {
		this.volunteer_number = volunteer_number;
	}
	public String getSupporter_id() {
		return supporter_id;
	}
	public void setSupporter_id(String supporter_id) {
		this.supporter_id = supporter_id;
	}
	public String getVolunteer_date() {
		return volunteer_date;
	}
	public void setVolunteer_date(String volunteer_date) {
		this.volunteer_date = volunteer_date;
	}
	public String getVolunteer_time() {
		return volunteer_time;
	}
	public void setVolunteer_time(String volunteer_time) {
		this.volunteer_time = volunteer_time;
	}
	
	@Override
	public String toString() {
		return "VolunteerDTO [volunteer_number=" + volunteer_number + ", supporter_id=" + supporter_id
				+ ", volunteer_date=" + volunteer_date + ", volunteer_time=" + volunteer_time + "]";
	}
}
