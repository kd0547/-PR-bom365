package model.supporter;

public class SupporterVO {
	private String supporter_id;
	private String supporter_name;
	private String supporter_password;
	private String phone_number;
	private String post_code;
	private String detailed_address;

	public String getSupporter_id() {
		return supporter_id;
	}

	public void setSupporter_id(String supporter_id) {
		this.supporter_id = supporter_id;
	}

	public String getSupporter_name() {
		return supporter_name;
	}

	public void setSupporter_name(String supporter_name) {
		this.supporter_name = supporter_name;
	}

	public String getSupporter_password() {
		return supporter_password;
	}

	public void setSupporter_password(String supporter_password) {
		this.supporter_password = supporter_password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public String getDetailed_address() {
		return detailed_address;
	}

	public void setDetailed_address(String detailed_address) {
		this.detailed_address = detailed_address;
	}

	@Override
	public String toString() {
		return "SupporterDAO [supporter_id=" + supporter_id + ", supporter_name=" + supporter_name
				+ ", supporter_password=" + supporter_password + ", phone_number=" + phone_number + ", post_code="
				+ post_code + ", detailed_address=" + detailed_address + "]";
	}
}
