package model.board;

import java.util.ArrayList;

public class CommentSet {
	// BoardVO 1개에 Board_commentVO N개가 붙어있는 형태

	private BoardVO board;
	private ArrayList<Board_commentVO> comment = new ArrayList<Board_commentVO>();
	
	public BoardVO getBoard() {
		return board;
	}
	public void setBoard(BoardVO board) {
		this.board = board;
	}
	public ArrayList<Board_commentVO> getComment() {
		return comment;
	}
	public void setComment(ArrayList<Board_commentVO> comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "CommentSet [board=" + board + ", comment=" + comment + "]";
	}
}
