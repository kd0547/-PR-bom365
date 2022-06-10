package model.board;

public class BoardVO {
	private int board_number;
	private String supporter_id;
	private String board_date;
	private String board_title;
	private String board_content;
	private String category;
	private int board_commentCnt;
	
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
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getBoard_commentCnt() {
		return board_commentCnt;
	}
	public void setBoard_commentCnt(int board_commentCnt) {
		this.board_commentCnt = board_commentCnt;
	}

	@Override
	public String toString() {
		return "BoardVO [board_number=" + board_number + ", supporter_id=" + supporter_id + ", board_date=" + board_date
				+ ", board_title=" + board_title + ", board_content=" + board_content + ", category=" + category
				+ ", board_commentCnt=" + board_commentCnt + "]";
	}
}
