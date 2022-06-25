package model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.mybatis.SqlMapConfig;

public class BoardDAO {
	/*
	 * board ㆍ c : insert - 게시글 작성 ㆍ r : selectAll - 전체 게시글 목록 불러오기 selectOne - 상세
	 * 게시글 + 댓글 불러오기 → selectCom - 댓글 select 후 ArrayList에 담기 selectSearch - 게시글 검색결과
	 * selectMine - 내글보기 selectComCnt - 댓글순보기 ㆍ u : update - 게시글 수정하기 ㆍ d : delete -
	 * 게시글 삭제하기
	 */

	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public BoardDAO() {
		// auto commit
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공)");
	}

	// 게시글 작성
	public boolean insert(BoardDTO dto) {
		boolean result = false;
		boolean isAdmin = false;

		if (dto.getSupporter_id().equals("admin")) {
			isAdmin = true;
		}

		if (isAdmin) {
			dto.setCategory("공지");
		} else {
			dto.setCategory("일반");
		}
		if (sqlsession.insert("BoardSQL.insert", dto) != 0) {
			result = true;
		}
		return result;
	}

	// 전체 게시글 조회
	public List<BoardDTO> selectAll() {
		List<BoardDTO> datas = sqlsession.selectList("BoardSQL.selectAdmin");
		List<BoardDTO> datasSupporter = sqlsession.selectList("BoardSQL.selectSupporter");

		for (BoardDTO v : datasSupporter) {
			datas.add(v);
		}
		return datas;
	}

	// 게시글 상세보기
	public BoardSet selectOne(BoardDTO data) {
		BoardSet bs = new BoardSet();
		bs.setBoard(sqlsession.selectOne("BoardSQL.selectOne", data));
		bs.setComments(sqlsession.selectList("BoardSQL.selectCom", bs.getBoard()));
		return bs;
	}

	// 키워드 검색 결과 조회
	public List<BoardDTO> selectSearch(String keyword) {
		List<BoardDTO> datas = sqlsession.selectList("BoardSQL.selectAdmin");
		List<BoardDTO> datasSearch = sqlsession.selectList("BoardSQL.selectSearch", keyword);
		for (BoardDTO v : datasSearch) {
			datas.add(v);
		}
		return datas;
	}

	// 내가 작성한 글 조회
	public List<BoardDTO> selectMine(BoardDTO data) {
		List<BoardDTO> datas = sqlsession.selectList("BoardSQL.selectAdmin");
		List<BoardDTO> datasMine = sqlsession.selectList("BoardSQL.selectMine", data);
		for (BoardDTO v : datasMine) {
			datas.add(v);
		}
		return datas;
	}

	// 댓글 순으로 결과 조회
	public List<BoardDTO> selectComCnt() {
		List<BoardDTO> datas = sqlsession.selectList("BoardSQL.selectAdmin");
		List<BoardDTO> datasComCnt = sqlsession.selectList("BoardSQL.selectComCnt");
		for (BoardDTO v : datasComCnt) {
			datas.add(v);
		}
		return datas;
	}

	// 게시글 수정
	public boolean update(BoardDTO dto) {
		boolean result = false;
		if (sqlsession.update("BoardSQL.update", dto) != 0) {
			result = true;
		}
		return result;
	}

	// 게시글 삭제
	public boolean delete(BoardDTO dto) {
		boolean result = false;
		if (sqlsession.delete("BoardSQL.delete", dto) != 0) {
			result = true;
		}
		return result;
	}
}
