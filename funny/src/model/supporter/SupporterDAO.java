package model.supporter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.mybatis.SqlMapConfig;

import model.common.JDBCUtil;

public class SupporterDAO {
	/*
	 * supporter ㆍ c : insert - 회원가입 ㆍ c : selectLogin - 로그인
	 */

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	String sql_delete_info = "select supporter_id,supporter_password from supporter where supporter_id=? AND supporter_password=?";
	String sql_delete = "delete FROM supporter where supporter_id=?";
	String sql_update = "update supporter set supporter_name=?,supporter_password=?,phone_number=?,post_code=?,detailed_address=?  where supporter_id=?";
	

	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public SupporterDAO() {
		// auto commit
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공)");
	}

	// 회원가입
	public boolean insert(SupporterDTO dto) {
		boolean result = false;
		if (sqlsession.insert("SupporterSQL.insert", dto) == 0) {
			result = true;
		}
		return result;
	}

	// 로그인체크
	public SupporterDTO login(SupporterDTO dto) {
		SupporterDTO data = sqlsession.selectOne("SupporterSQL.selectSupporterCheck", dto);
		// rs에 데이터 없으면 로그인페이지 이동(아이디 없음)
		// pw비교 O→ 로그인완료 X→로그인페이지로 이동(패스워드 틀림)
		if(data == null) {
			return null;
		} else if (dto.getSupporter_password().equals(data.getSupporter_password())) {
			return data;
		}
		return null;
	}

	/*
	 * ID 중복을 검사하기 위해 DB에서 값을 SELECT 한다
	 * 
	 * param 중복 검사할 ID return true - 유저 있음, false - 유저 없음
	 */
	public boolean SupporterIdCheck(String supporter_id) {
		boolean result = false;
		SupporterDTO data = new SupporterDTO();
		data.setSupporter_id(supporter_id);
		data = sqlsession.selectOne("SupporterSQL.selectSupporterCheck", data);
		String idCheck = data.getSupporter_id();
		if (supporter_id.equals(idCheck)) {
			result = true;
		}
		return result;
	}

	// 마이페이지 회원정보 가져오기
	public SupporterDTO SupporterIdInfo(SupporterDTO dto) {
		SupporterDTO data = sqlsession.selectOne("SupporterSQL.selectSupporterCheck", dto);
		return data;
	}

	// 회원 정보 수정하기
	public boolean update(SupporterDTO dto) {
		boolean result = false;
		//
		//
		//
		//
		// 채우기
		//
		//
		//
		//
		//
		return result;
	}

	// 회원 탈퇴
	public boolean SupporterDelete(SupporterDTO dto) {
		String input_id = dto.getSupporter_id();
		String input_pwd = dto.getSupporter_password();
		String result_id = null;
		String result_pwd = null;
		boolean result = false;

		if (input_id != null && input_pwd != null) {
			// 유저 조회
			SupporterDTO resultDTO = sqlsession.selectOne("SupporterSQL.deleteInfo", dto);

			if (resultDTO != null) {
				result_id = resultDTO.getSupporter_id();
				result_pwd = resultDTO.getSupporter_password();
				System.out.println(resultDTO);

				// 유저 삭제
				if (result_id != null && result_pwd != null) {
					if (sqlsession.delete("SupporterSQL.delete", dto) != 0) {
						// 삭제 결과값 반환
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	public boolean SupporterUpdate(SupporterDTO vo) {
		
		boolean result = false;
		
		try {
			
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_update);
			
			pstmt.setString(1, vo.getSupporter_name());
			pstmt.setString(2, vo.getSupporter_password());
			pstmt.setString(3, vo.getPhone_number());
			pstmt.setString(4, vo.getPost_code());
			pstmt.setString(5, vo.getDetailed_address());
			pstmt.setString(6, vo.getSupporter_id());
			
			if(pstmt.executeUpdate() != 0) {
				
				result = true;
			} else {
				result = false;
			}

			
		} catch (SQLException e) {
			System.out.println("SupporterDAO의 SupporterUpdate()에서 문제발생!");
			e.printStackTrace();
			
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
	
		return result;
	}
	
}
