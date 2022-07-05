package model.application;

public class ApplicationDTO {
	private int application_number;
	private int animal_number;
	private String supporter_id;
	private String application_title;
	private String application_content;
	private String application_date;
	
	private String animal_name;
	private String adoptionSupporter_id;

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
	public String getApplication_date() {
		return application_date;
	}
	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}
	
	public String getAnimal_name() {
		return animal_name;
	}
	public void setAnimal_name(String animal_name) {
		this.animal_name = animal_name;
	}
	public String getAdoptionSupporter_id() {
		return adoptionSupporter_id;
	}
	public void setAdoptionSupporter_id(String adoptionSupporter_id) {
		this.adoptionSupporter_id = adoptionSupporter_id;
	}
	
	@Override
	public String toString() {
		return "ApplicationDTO [application_number=" + application_number + ", animal_number=" + animal_number
				+ ", supporter_id=" + supporter_id + ", application_title=" + application_title
				+ ", application_content=" + application_content + ", application_date=" + application_date
				+ ", animal_name=" + animal_name + ", adoptionsupporter_id=" + adoptionSupporter_id + "]";
	}
}
