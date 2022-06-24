package model.board;

import java.util.List;

public class BoardSet {
	// BoardVO 1개에 Board_commentVO N개가 붙어있는 형태

	private BoardDTO board;
	private List<Board_commentDTO> comments;
	
	public BoardDTO getBoard() {
		return board;
	}
	public void setBoard(BoardDTO board) {
		this.board = board;
	}
	public List<Board_commentDTO> getComments() {
		return comments;
	}
	public void setComments(List<Board_commentDTO> comments) {
		this.comments = comments;
	}
}
