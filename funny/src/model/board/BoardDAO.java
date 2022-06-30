package model.board;

import java.util.HashMap;
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
	HashMap<String, Object> datas = new HashMap<>();
	
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
	public List<BoardDTO> selectAll(int startRow, int endRow) {
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		
		List<BoardDTO> boardList = sqlsession.selectList("BoardSQL.selectAdmin");
		List<BoardDTO> boardListPaging = sqlsession.selectList("BoardSQL.selectSupporter", datas);

		for (BoardDTO v : boardListPaging) {
			boardList.add(v);
		}
		return boardList;
	}
	
	// 전체 글 개수
	public int selectCnt() {
		return sqlsession.selectOne("BoardSQL.selectSupporterCnt");
	}
	
	// 게시글 상세보기
	public BoardSet selectOne(BoardDTO data) {
		BoardSet bs = new BoardSet();
		bs.setBoard(sqlsession.selectOne("BoardSQL.selectOne", data));
		bs.setComments(sqlsession.selectList("BoardSQL.selectCom", bs.getBoard()));
		return bs;
	}

	// 키워드 검색 결과 조회
	public List<BoardDTO> selectSearch(String keyword, int startRow, int endRow) {
		datas.put("keyword", keyword);
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		
		List<BoardDTO> boardList = sqlsession.selectList("BoardSQL.selectAdmin");
		List<BoardDTO> datasSearch = sqlsession.selectList("BoardSQL.selectSearch", datas);
		for (BoardDTO v : datasSearch) {
			boardList.add(v);
		}
		return boardList;
	}

	// 검색 글 개수
	public int selectSearchCnt(String keyword) {
		return sqlsession.selectOne("BoardSQL.selectSearchCnt", keyword);
	}

	// 내가 작성한 글 조회
	public List<BoardDTO> selectMine(BoardDTO data, int startRow, int endRow) {
		datas.put("supporter_id", data.getSupporter_id());
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		
		List<BoardDTO> boardList = sqlsession.selectList("BoardSQL.selectAdmin");
		List<BoardDTO> datasMine = sqlsession.selectList("BoardSQL.selectMine", datas);
		for (BoardDTO v : datasMine) {
			boardList.add(v);
		}
		return boardList;
	}

	// 내 글 개수
	public int selectMineCnt(BoardDTO data) {
		return sqlsession.selectOne("BoardSQL.selectMineCnt", data);
	}
	
	// 댓글 순으로 결과 조회
	public List<BoardDTO> selectComCnt(int startRow, int endRow) {
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		
		List<BoardDTO> boardList = sqlsession.selectList("BoardSQL.selectAdmin");
		List<BoardDTO> datasComCnt = sqlsession.selectList("BoardSQL.selectComCnt", datas);
		
		for (BoardDTO v : datasComCnt) {
			boardList.add(v);
		}
		return boardList;
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
