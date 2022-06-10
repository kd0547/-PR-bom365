package model.board;

public class Board_commentVO {
	private String comment_number;
	private int board_number;
	private String supporter_id;
	private String comment_content;
	private String comment_date;
	
	public String getComment_number() {
		return comment_number;
	}
	public void setComment_number(String comment_number) {
		this.comment_number = comment_number;
	}
	public int getBoard_number() {
		return board_number;
	}
	public void setBoard_number(int board_number) {
		this.board_number = board_number;
	}
	public String getSupporter_id() {
		return supporter_id;
	}
	public void setSupporter_id(String supporter_id) {
		this.supporter_id = supporter_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}
	
	@Override
	public String toString() {
		return "board_commentVO [comment_number=" + comment_number + ", board_number=" + board_number
				+ ", supporter_id=" + supporter_id + ", comment_content=" + comment_content + ", comment_date="
				+ comment_date + "]";
	}
}
