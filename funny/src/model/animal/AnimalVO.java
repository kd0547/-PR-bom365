package model.animal;

public class AnimalVO {
	private int animal_number;
	private String supporter;
	private String animal_name;
	private String animal_species;
	private String animal_type;
	private String animal_gender;
	private String animal_age;
	private double animal_weight;
	private String animal_image;
	private String isAdoption;
	
	public AnimalVO() {
		
	}
	
	public AnimalVO(String animal_name, String animal_species, String animal_type,
			String animal_gender, String animal_age, double animal_weight, String animal_image, String isAdoption) {

		this.animal_name = animal_name;
		this.animal_species = animal_species;
		this.animal_type = animal_type;
		this.animal_gender = animal_gender;
		this.animal_age = animal_age;
		this.animal_weight = animal_weight;
		this.animal_image = animal_image;
		this.isAdoption = isAdoption;
	}
	
	public int getAnimal_number() {
		return animal_number;
	}
	public void setAnimal_number(int animal_number) {
		this.animal_number = animal_number;
	}
	public String getSupporter() {
		return supporter;
	}
	public void setSupporter(String supporter) {
		this.supporter = supporter;
	}
	public String getAnimal_name() {
		return animal_name;
	}
	public void setAnimal_name(String animal_name) {
		this.animal_name = animal_name;
	}
	public String getAnimal_species() {
		return animal_species;
	}
	public void setAnimal_species(String animal_species) {
		this.animal_species = animal_species;
	}
	public String getAnimal_type() {
		return animal_type;
	}
	public void setAnimal_type(String animal_type) {
		this.animal_type = animal_type;
	}
	public String getAnimal_gender() {
		return animal_gender;
	}
	public void setAnimal_gender(String animal_gender) {
		this.animal_gender = animal_gender;
	}
	public String getAnimal_age() {
		return animal_age;
	}
	public void setAnimal_age(String animal_age) {
		this.animal_age = animal_age;
	}
	public double getAnimal_weight() {
		return animal_weight;
	}
	public void setAnimal_weight(double animal_weight) {
		this.animal_weight = animal_weight;
	}
	public String getAnimal_image() {
		return animal_image;
	}
	public void setAnimal_image(String animal_image) {
		this.animal_image = animal_image;
	}
	public String getIsAdoption() {
		return isAdoption;
	}
	public void setIsAdoption(String isAdoption) {
		this.isAdoption = isAdoption;
	}

	@Override
	public String toString() {
		return "ProductVO [animal_number=" + animal_number + ", supporter=" + supporter + ", animal_name=" + animal_name
				+ ", animal_species=" + animal_species + ", animal_type=" + animal_type + ", animal_gender="
				+ animal_gender + ", animal_age=" + animal_age + ", animal_weight=" + animal_weight + ", animal_image="
				+ animal_image + ", isAdoption=" + isAdoption + "]";
	}
}