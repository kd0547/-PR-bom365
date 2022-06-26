package model.support;

public class SupportTEMDTO {
	private int temporary_number;
	private String supporter_id;
	private String temporary_amount;
	private String temporary_date;
	
	public int getTemporary_number() {
		return temporary_number;
	}
	public void setTemporary_number(int temporary_number) {
		this.temporary_number = temporary_number;
	}
	public String getSupporter_id() {
		return supporter_id;
	}
	public void setSupporter_id(String supporter_id) {
		this.supporter_id = supporter_id;
	}
	public String getTemporary_amount() {
		return temporary_amount;
	}
	public void setTemporary_amount(String temporary_amount) {
		this.temporary_amount = temporary_amount;
	}
	public String getTemporary_date() {
		return temporary_date;
	}
	public void setTemporary_date(String temporary_date) {
		this.temporary_date = temporary_date;
	}
	
	@Override
	public String toString() {
		return "supportTEMRequestVO [temporary_number=" + temporary_number + ", supporter_id=" + supporter_id
				+ ", temporary_amount=" + temporary_amount + ", temporary_date=" + temporary_date + "]";
	}

}
