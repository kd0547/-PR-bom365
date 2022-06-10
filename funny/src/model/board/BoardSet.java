package model.board;

import java.util.ArrayList;

public class BoardSet {
	// BoardVO 1개에 Board_commentVO N개가 붙어있는 형태

	private BoardVO board;
	private ArrayList<Board_commentVO> comments = new ArrayList<Board_commentVO>();
	
	public BoardVO getBoard() {
		return board;
	}
	public void setBoard(BoardVO board) {
		this.board = board;
	}
	public ArrayList<Board_commentVO> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Board_commentVO> comments) {
		this.comments = comments;
	}
}
