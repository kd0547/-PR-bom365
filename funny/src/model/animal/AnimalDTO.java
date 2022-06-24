package model.animal;

public class AnimalDTO {
	private int animal_number;
	private String supporter_id;
	private String animal_name;
	private String animal_species;
	private String animal_type;
	private String animal_gender;
	private String animal_age;
	private double animal_age_num;
	private double animal_age_more;
	private double animal_age_less;
	private double animal_weight;
	private int animal_weight_over;
	private int animal_weight_under;
	private String animal_image;
	private String isAdoption;
	
	public AnimalDTO() {}
	
	public AnimalDTO(String animal_name, String animal_species, String animal_type,
			String animal_gender, String animal_age, double animal_weight, String animal_image) {

		this.animal_name = animal_name;
		this.animal_species = animal_species;
		this.animal_type = animal_type;
		this.animal_gender = animal_gender;
		this.animal_age = animal_age;
		this.animal_weight = animal_weight;
		this.animal_image = animal_image;
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
	public double getAnimal_age_num() {
		return animal_age_num;
	}
	public void setAnimal_age_num(double animal_age_num) {
		this.animal_age_num = animal_age_num;
	}
	public double getAnimal_age_more() {
		return animal_age_more;
	}
	public void setAnimal_age_more(double animal_age_more) {
		this.animal_age_more = animal_age_more;
	}
	public double getAnimal_age_less() {
		return animal_age_less;
	}
	public void setAnimal_age_less(double animal_age_less) {
		this.animal_age_less = animal_age_less;
	}
	public double getAnimal_weight() {
		return animal_weight;
	}
	public void setAnimal_weight(double animal_weight) {
		this.animal_weight = animal_weight;
	}
	public int getAnimal_weight_over() {
		return animal_weight_over;
	}
	public void setAnimal_weight_over(int animal_weight_over) {
		this.animal_weight_over = animal_weight_over;
	}
	public int getAnimal_weight_under() {
		return animal_weight_under;
	}
	public void setAnimal_weight_under(int animal_weight_under) {
		this.animal_weight_under = animal_weight_under;
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
		return "AnimalDTO [animal_number=" + animal_number + ", supporter_id=" + supporter_id + ", animal_name="
				+ animal_name + ", animal_species=" + animal_species + ", animal_type=" + animal_type
				+ ", animal_gender=" + animal_gender + ", animal_age=" + animal_age + ", animal_age_num="
				+ animal_age_num + ", animal_age_more=" + animal_age_more + ", animal_age_less=" + animal_age_less
				+ ", animal_weight=" + animal_weight + ", animal_weight_over=" + animal_weight_over
				+ ", animal_weight_under=" + animal_weight_under + ", animal_image=" + animal_image + ", isAdoption="
				+ isAdoption + "]";
	}
}