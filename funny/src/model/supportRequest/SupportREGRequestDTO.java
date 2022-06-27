package model.supportRequest;

public class SupportREGRequestDTO {
	private int regular_number;
	private String supporter_id;
	private int regular_amount;
	private String regular_bank;
	private String regular_account;
	private int regular_date;
	
	public int getRegular_number() {
		return regular_number;
	}
	public void setRegular_number(int regular_number) {
		this.regular_number = regular_number;
	}
	public String getSupporter_id() {
		return supporter_id;
	}
	public void setSupporter_id(String supporter_id) {
		this.supporter_id = supporter_id;
	}
	
	public int getRegular_amount() {
		return regular_amount;
	}
	public void setRegular_amount(int regular_amount) {
		this.regular_amount = regular_amount;
	}
	public String getRegular_bank() {
		return regular_bank;
	}
	public void setRegular_bank(String regular_bank) {
		this.regular_bank = regular_bank;
	}
	public String getRegular_account() {
		return regular_account;
	}
	public void setRegular_account(String regular_account) {
		this.regular_account = regular_account;
	}
	public int getRegular_date() {
		return regular_date;
	}
	public void setRegular_date(int regular_date) {
		this.regular_date = regular_date;
	}
	@Override
	public String toString() {
		return "SupportREGRequestVO [regular_amount=" + regular_amount + ", regular_bank=" + regular_bank
				+ ", regular_account=" + regular_account + ", regular_date=" + regular_date + "]";
	}

	
	
	

}
