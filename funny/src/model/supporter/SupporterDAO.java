package model.supporter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class SupporterDAO {
	/*
	supporter
		ㆍ c :	insert				-	회원가입
		ㆍ c :	selectLogin				-	로그인
	*/
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	String sql_insert = "insert into supporter values(?,?,?,?,?,?)";
	String sql_selectLoginCheck = "select * from supporter where supporter_id=?";
	String sql_idCheck = "select supporter_id from supporter where supporter_id=?";
	
	// 회원가입
	public boolean insert(SupporterVO vo) { 
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getSupporter_id());
			pstmt.setString(2, vo.getSupporter_name());
			pstmt.setString(3, vo.getSupporter_password());
			pstmt.setString(4, vo.getPhone_number());
			pstmt.setString(5, vo.getPost_code());
			pstmt.setString(6, vo.getDetailed_address());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SupporterDAO의 insert()에서 문제발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	// 로그인체크
	public SupporterVO login(SupporterVO vo) {
		SupporterVO data = null;
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_selectLoginCheck);
			pstmt.setString(1, vo.getSupporter_id());
			rs = pstmt.executeQuery();
			// rs에 데이터 없으면 로그인페이지 이동(아이디 없음)
			// pw비교 O→ 로그인완료 X→로그인페이지로 이동(패스워드 틀림)

			if (rs.next()) {
				if (vo.getSupporter_password().equals(rs.getString("supporter_password"))) {
					data = new SupporterVO();
					data.setSupporter_id(rs.getString("supporter_id"));
					data.setSupporter_name(rs.getString("supporter_name"));
				}
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("SupporterDAO의 login()에서 문제발생!");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	/*
	 * ID 중복을 검사하기 위해 DB에서 값을 SELECT 한다
	 * 
	 * param 중복 검사할 ID
	 * return true - 유저 있음, false - 유저 없음
	 */
	public boolean SupporterIdCheck(String SupporterId) {
		
		boolean result = false;
		
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_idCheck);
			pstmt.setString(1, SupporterId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("supporter_id").equals(SupporterId)) {
					//System.out.println(rs.getString("supporter_id"));
					return true;
				}
				
				
			}
			
		} catch (SQLException e) {
			System.out.println("SupporterDAO의 SupporterIdCheck()에서 문제발생!");
			e.printStackTrace();
			
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return result;
	}
}
