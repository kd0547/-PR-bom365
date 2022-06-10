package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class BoardDAO {
	/*
	board
		ㆍ c :	insert				-	게시글 작성
		ㆍ r :	selectAll			-	전체 게시글 목록 불러오기
					selectOne		-	상세 게시글 + 댓글 불러오기
						→ selectCom		-	댓글 select 후 ArrayList에 담기
					selectSearch	-	게시글 검색결과
					selectMine		-	내글보기
					selectComCnt	-	댓글순보기
		ㆍ u :	update			-	게시글 수정하기
		ㆍ d :	delete				-	게시글 삭제하기
	*/
	
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    
    String sql_insert = "insert into board values ((select nvl(max(board_number),0)+1 from board),?,to_char(sysdate, 'yyyy.mm.dd hh24:mi'),?,?,?,default)";
    String sql_selectAll = "select * from board order by board_number desc";
    String sql_selectOne = "select * from board where board_number=?";
    String sql_selectCom = "select * from board_comment where board_number=? order by comment_date";
    String sql_selectSearch = "select * from board where board_title like '%'||?||'%' or board_content like '%'||?||'%' order by board_number desc";
    String sql_selectMine = "select * from board where supporter_id=? order by board_number desc";
    String sql_selectComCnt = "select * from board order by board_commentCnt desc";
    String sql_update = "update board set board_title=?, board_content=? where board_number=?";
    String sql_delete = "delete from board where board_number=?";
	
    //게시글 작성
    public boolean insert(BoardVO vo) { 
        conn = JDBCUtil.connect();
        boolean isAdmin = false;
		if (vo.getSupporter_id().equals("admin")) {
			isAdmin = true;
		}
        try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getSupporter_id());
			pstmt.setString(2, vo.getBoard_title());
			pstmt.setString(3, vo.getBoard_content());
			if (isAdmin) {
				pstmt.setString(4, "공지");
			} else {
				pstmt.setString(4, "일반");
			}
			pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("BoardDAO의 insert()에서 문제 발생!");
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return true;
    }
    
    //전체 게시글 조회
    public ArrayList<BoardVO> selectAll() { 
        conn = JDBCUtil.connect();
        ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
        try {
            pstmt = conn.prepareStatement(sql_selectAll);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setBoard_number(rs.getInt("board_number"));
                vo.setSupporter_id(rs.getString("supporter_id"));
                vo.setBoard_date(rs.getString("board_date"));
                vo.setBoard_title(rs.getString("board_title"));
                vo.setBoard_commentCnt(rs.getInt("board_commentCnt"));
                System.out.println("dao : "+vo);
                datas.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("BoardDAO의 selectAll()에서 문제 발생!");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return datas;
    }
    
    //게시글 상세보기
    public BoardSet selectOne(BoardVO data) { 
        conn = JDBCUtil.connect();
        BoardSet bs = new BoardSet();
        try {
            pstmt = conn.prepareStatement(sql_selectOne);
            pstmt.setInt(1,data.getBoard_number());
            rs = pstmt.executeQuery();
            rs.next();
            BoardVO vo = new BoardVO();
            vo.setBoard_number(rs.getInt("board_number"));
            vo.setSupporter_id(rs.getString("supporter_id"));
            vo.setBoard_date(rs.getString("board_date"));
            vo.setBoard_title(rs.getString("board_title"));
            vo.setBoard_content(rs.getString("board_content"));
            vo.setBoard_commentCnt(rs.getInt("board_commentCnt"));
            bs.setBoard(vo);
            
            ArrayList<Board_commentVO> comments = new ArrayList<Board_commentVO>();
			pstmt = conn.prepareStatement(sql_selectCom);
			pstmt.setInt(1, vo.getBoard_number());
			ResultSet rs2 = pstmt.executeQuery();
			while (rs2.next()) {
				Board_commentVO bc = new Board_commentVO();
				bc.setComment_number(rs2.getString("comment_number"));
				bc.setSupporter_id(rs2.getString("supporter_id"));
				bc.setComment_content(rs2.getString("comment_content"));
				bc.setComment_date(rs2.getString("comment_date"));
				comments.add(bc);
			}
			bs.setComments(comments);
        } catch (SQLException e) {
            System.out.println("BoardDAO의 selectOne()에서 문제 발생!");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return bs;
    }
    
    //키워드 검색 결과 조회
    public ArrayList<BoardVO> selectSearch(String keyword) { 
        conn = JDBCUtil.connect();
        ArrayList<BoardVO> datas = new ArrayList<BoardVO>();

        try {
            pstmt = conn.prepareStatement(sql_selectSearch);
            pstmt.setString(1,keyword);
            pstmt.setString(2,keyword);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setBoard_number(rs.getInt("board_number"));
                vo.setSupporter_id(rs.getString("supporter_id"));
                vo.setBoard_date(rs.getString("board_date"));
                vo.setBoard_title(rs.getString("board_title"));
                vo.setBoard_commentCnt(rs.getInt("board_commentCnt"));
                System.out.println("dao : "+vo);
                datas.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("BoardDAO의 selectSearch()에서 문제 발생!");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return datas;
    }
    
    //내가 작성한 글 조회
    public ArrayList<BoardVO> selectMine(BoardVO data) { 
        conn = JDBCUtil.connect();
        ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
        try {
            pstmt = conn.prepareStatement(sql_selectMine);
            pstmt.setString(1,data.getSupporter_id());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setBoard_number(rs.getInt("board_number"));
                vo.setSupporter_id(rs.getString("supporter_id"));
                vo.setBoard_date(rs.getString("board_date"));
                vo.setBoard_title(rs.getString("board_title"));
                vo.setBoard_commentCnt(rs.getInt("board_commentCnt"));
                System.out.println("dao : "+vo);
                datas.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("BoardDAO의 selectMine()에서 문제 발생!");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return datas;
    }
    
    //댓글 순으로 결과 조회
    public ArrayList<BoardVO> selectComCnt() { 
        conn = JDBCUtil.connect();
        ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
        try {
            pstmt = conn.prepareStatement(sql_selectComCnt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setBoard_number(rs.getInt("board_number"));
                vo.setSupporter_id(rs.getString("supporter_id"));
                vo.setBoard_date(rs.getString("board_date"));
                vo.setBoard_title(rs.getString("board_title"));
                vo.setBoard_commentCnt(rs.getInt("board_commentCnt"));
                System.out.println("dao : "+vo);
                datas.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("BoardDAO의 selectComCnt()에서 문제 발생!");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return datas;
    }
    
    //게시글 수정
    public boolean update(BoardVO vo) { 
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_update);
            pstmt.setString(1, vo.getBoard_title());
            pstmt.setString(2, vo.getBoard_content());
            pstmt.setInt(3, vo.getBoard_number());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("BoardDAO의 update()에서 문제발생!");
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return true;
    }
    
    //게시글 삭제
    public boolean delete(BoardVO vo) { 
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_delete);
            pstmt.setInt(1, vo.getBoard_number());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("BoardDAO의 delete()에서 문제 발생!");
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return true;
    }
}
