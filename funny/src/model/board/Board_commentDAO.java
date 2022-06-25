package model.board;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.mybatis.SqlMapConfig;

public class Board_commentDAO {
	/*
	comment
		ㆍ c :	insert		-	댓글 작성
						→ updateComUp		-	댓글 작성시 게시글의 댓글 수 컬럼 +1
		ㆍ d :	delete		-	댓글 삭제하기
						→ updateComDown	-	댓글 삭제시 게시글의 댓글 수 컬럼 -1
	*/
	
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public Board_commentDAO() {
		// auto commit
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공)");
	}
    
	// 댓글 작성
	public boolean insert(Board_commentDTO dto) {
		boolean result = false;
		if (sqlsession.insert("BoardSQL.insertCom", dto) != 0) {
			sqlsession.update("BoardSQL.updateComUp", dto);
			System.out.println("Board_commentDAO의 댓글수 +1 완료");
			result = true;
		}
		return result;
	}

	// 댓글 삭제
	public boolean delete(Board_commentDTO dto) {
		boolean result = false;
		if (sqlsession.delete("BoardSQL.deleteCom", dto) != 0) {
			sqlsession.update("BoardSQL.updateComDown", dto);
			System.out.println("Board_commentDAO의 댓글수 -1 완료");
			result = true;
		}
		return result;
	}
}
