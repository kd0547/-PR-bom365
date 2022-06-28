package model.support;

public class SupportREGDTO {
	private int regular_number;
	private String supporter_id;
	private String regular_amount;
	private String regular_bank;
	private String regular_account;
	private String regular_paymentDate;
	private String regular_date;
	private String regular_end;
	
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
	public String getRegular_amount() {
		return regular_amount;
	}
	public void setRegular_amount(String regular_amount) {
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
	public String getRegular_paymentDate() {
		return regular_paymentDate;
	}
	public void setRegular_paymentDate(String regular_paymentDate) {
		this.regular_paymentDate = regular_paymentDate;
	}
	public String getRegular_date() {
		return regular_date;
	}
	public void setRegular_date(String regular_date) {
		this.regular_date = regular_date;
	}
	public String getRegular_end() {
		return regular_end;
	}
	public void setRegular_end(String regular_end) {
		this.regular_end = regular_end;
	}

	@Override
	public String toString() {
		return "SupportREGDTO [regular_number=" + regular_number + ", supporter_id=" + supporter_id
				+ ", regular_amount=" + regular_amount + ", regular_bank=" + regular_bank + ", regular_account="
				+ regular_account + ", regular_paymentDate=" + regular_paymentDate + ", regular_date=" + regular_date
				+ ", regular_end=" + regular_end + "]";
	}
}
