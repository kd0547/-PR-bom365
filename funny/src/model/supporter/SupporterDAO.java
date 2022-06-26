package model.supporter;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.mybatis.SqlMapConfig;

public class SupporterDAO {

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
		/*
		 * insert() 리턴 타입
		 * 성공 - 업데이트 된 행의 개수
		 * 실패 - 업데이트 된 행의 개수(없으면 0)
		 */
		if (sqlsession.insert("SupporterSQL.insert", dto) != 0) {
			result = true;
		}
		
		return result;
	}

	// 로그인체크
	public SupporterDTO login(SupporterDTO dto) {
		SupporterDTO data = sqlsession.selectOne("SupporterSQL.selectSupporterCheck", dto);
		// rs에 데이터 없으면 로그인페이지 이동(아이디 없음)
		// pw비교 O→ 로그인완료 X→로그인페이지로 이동(패스워드 틀림)
		if (data == null) {
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
	public boolean idCheck(String supporter_id) {
		boolean result = false;
		SupporterDTO data = new SupporterDTO();
		data.setSupporter_id(supporter_id);
		
		/*
		 * 	DB에 값이 없으면 NULL 반환 
		 */
		data = sqlsession.selectOne("SupporterSQL.selectSupporterCheck", data);
		
		if(data != null ) {
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

		if (sqlsession.update("SupporterSQL.update", dto) != 0) {
			result = true;
		}

		return result;
	}

	// 회원 탈퇴
	public boolean delete(SupporterDTO dto) {
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
}
