package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class Board_commentDAO {
	/*
	comment
		ㆍ c :	insert		-	댓글 작성
						→ updateComUp		-	댓글 작성시 게시글의 댓글 수 컬럼 +1
		ㆍ d :	delete		-	댓글 삭제하기
						→ updateComDown	-	댓글 삭제시 게시글의 댓글 수 컬럼 -1
	*/
	
    Connection conn;
    PreparedStatement pstmt;

    String sql_insert = "insert into board_comment values (?||'_'||((select nvl(COUNT(comment_number),0)+1 from board_comment WHERE board_number=?)), ?, ?, ?, to_char(sysdate, 'yyyy.mm.dd hh24:mi'))";
    String sql_delete = "delete from board_comment where comment_number=?";
    String sql_updateComUp = "update board set board_commentCnt=board_commentCnt+1 where board_number=?";
    String sql_updateComDown = "update board set board_commentCnt=board_commentCnt-1 where board_number=?";
    
    //댓글 작성
    public boolean insert(Board_commentVO vo) { 
        conn = JDBCUtil.connect();
        try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setInt(1, vo.getBoard_number());
			pstmt.setInt(2, vo.getBoard_number());
			pstmt.setInt(3, vo.getBoard_number());
			pstmt.setString(4, vo.getSupporter_id());
			pstmt.setString(5, vo.getComment_content());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql_updateComUp);
			pstmt.setInt(1, vo.getBoard_number());
			pstmt.executeUpdate();
			System.out.println("Board_commentDAO의 댓글수 +1 완료");
        } catch (SQLException e) {
            System.out.println("Board_commentDAO의 insert()에서 문제 발생!");
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return true;
    }
    
    //댓글 삭제
    public boolean delete(Board_commentVO vo) { 
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_delete);
            pstmt.setString(1, vo.getComment_number());
            pstmt.executeUpdate();
            
			pstmt = conn.prepareStatement(sql_updateComDown);
			pstmt.setInt(1, vo.getBoard_number());
			pstmt.executeUpdate();
			System.out.println("Board_commentDAO의 댓글수 -1 완료");
        } catch (SQLException e) {
            System.out.println("Board_commentDAO의 delete()에서 문제 발생!");
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return true;
    }
}
