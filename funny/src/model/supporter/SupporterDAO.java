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
	String sql_idInfo = "select * from supporter where supporter_id=?";
	String sql_delete_info = "select supporter_id,supporter_password from supporter where supporter_id=? AND supporter_password=?";
	String sql_delete = "delete FROM supporter where supporter_id=?";
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
			
			rs.close();
		} catch (SQLException e) {
			System.out.println("SupporterDAO의 SupporterIdCheck()에서 문제발생!");
			e.printStackTrace();
			
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return result;
	}
	public SupporterVO SupporterIdInfo(String SupporterId) {
		SupporterVO supporterVO = null;
		
		
		if(SupporterId != null) {
			try {
				conn = JDBCUtil.connect();
				pstmt = conn.prepareStatement(sql_idInfo);
				pstmt.setString(1, SupporterId);
				
				rs = pstmt.executeQuery();
				
				supporterVO = new SupporterVO();
				
					if (rs.next()) {
						
						supporterVO.setSupporter_id(rs.getString("supporter_id"));
						supporterVO.setSupporter_name(rs.getString("supporter_name"));
						supporterVO.setSupporter_password(rs.getString("supporter_password"));
						supporterVO.setPhone_number(rs.getString("phone_number"));
						supporterVO.setPost_code(rs.getString("post_code"));
						supporterVO.setDetailed_address(rs.getString("detailed_address"));
					} 
		
				
				rs.close();
			} catch (SQLException e) {
				System.out.println("SupporterDAO의 SupporterIdInfo()에서 문제발생!");
				e.printStackTrace();
				
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		} else {
			return supporterVO;
		}
		
		
		
		return supporterVO;
	}
	
	/*
	 * 	executeUpdate()의 반환값 	- 삭제 완료	
	 * 	0 						- 비밀번호 다름 
	 *
	 * -1 						- 오류 
	 * **'-1'은 executeUpdate()의 CREATE DROP반환값과 겹치지만 DELETE를 사용하기 때문에 사용해도 괜찮다고 생각함	**
	 */
	public int SupporterDelete(String id, String pwd) {
		
		String result_id = null;
		String result_pwd = null;
		int result = 0;
		
		if(id !=null && pwd != null) {
			try {
				conn = JDBCUtil.connect();
				pstmt = conn.prepareStatement(sql_delete_info);
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				
				rs = pstmt.executeQuery();
				//유저 조회
				if(rs.next()) {
					result_id = rs.getString("supporter_id");
					result_pwd = rs.getString("supporter_password");
				}
				//유저 삭제
				if(result_id != null && result_pwd != null) {
					
					if(result_id.equals(id) && result_pwd.equals(pwd) ) {
						pstmt = conn.prepareStatement(sql_delete);
						pstmt.setString(1, id);
						
						//삭제 결과값 반환
						result = pstmt.executeUpdate();
					}
				} else {
					// 아이디는 세션을 쓰기 때문에 대부분 일치하겠지만 
					// 혹시 모를 경우에 대비해서 넣어놨음 
					result = 0;
				}
				
				rs.close();
			} catch (SQLException e) {
				System.out.println("SupporterDAO의 SupporterDelete()에서 문제발생!");
				e.printStackTrace();
				
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		} else {
			//입력값이 없으면 에러로 처리 
			result = -1;
		}
		
		
		return result;
	}
	
	
}
