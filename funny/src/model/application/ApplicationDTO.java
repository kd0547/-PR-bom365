package model.application;

public class ApplicationDTO {
	int application_number;
	int animal_number;
	String supporter_id;
	String application_title;
	String application_content;

	public int getApplication_number() {
		return application_number;
	}
	public void setApplication_number(int application_number) {
		this.application_number = application_number;
	}
	public int getAnimal_number() {
		return animal_number;
	}
	public void setAnimal_number(int animal_number) {
		this.animal_number = animal_number;
	}
	public String getSupporter_id() {
		return supporter_id;
	}
	public void setSupporter_id(String supporter_id) {
		this.supporter_id = supporter_id;
	}
	public String getApplication_title() {
		return application_title;
	}
	public void setApplication_title(String application_title) {
		this.application_title = application_title;
	}
	public String getApplication_content() {
		return application_content;
	}
	public void setApplication_content(String applicatoin_content) {
		this.application_content = applicatoin_content;
	}
	
	@Override
	public String toString() {
		return "ApplicationDTO [application_number=" + application_number + ", animal_number=" + animal_number
				+ ", supporter_id=" + supporter_id + ", application_title=" + application_title
				+ ", application_content=" + application_content + "]";
	}
}
