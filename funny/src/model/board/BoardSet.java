package model.board;

import java.util.ArrayList;

public class BoardSet {
	// BoardVO 1개에 Board_commentVO N개가 붙어있는 형태

	private BoardDTO board;
	private ArrayList<Board_commentDTO> comments = new ArrayList<Board_commentDTO>();
	
	public BoardDTO getBoard() {
		return board;
	}
	public void setBoard(BoardDTO board) {
		this.board = board;
	}
	public ArrayList<Board_commentDTO> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Board_commentDTO> comments) {
		this.comments = comments;
	}
}
