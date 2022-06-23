package model.supporter;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.mybatis.SqlMapConfig;

public class SupporterDAO {
	/*
	supporter
		ㆍ c :	insert				-	회원가입
		ㆍ c :	selectLogin				-	로그인
	*/
	
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public SupporterDAO() {
		// auto commit
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공)");
	}
	
	// 회원가입
	public boolean insert(SupporterDTO dto) {
		boolean result=false;
		if(sqlsession.insert("SupporterSQL.insert", dto)==0) {
			result=true;
		}
		return result;
	}
	
	// 로그인체크
	public SupporterDTO login(SupporterDTO dto) {
		SupporterDTO data = sqlsession.selectOne("SupporterSQL.selectLoginCheck", dto);
			// rs에 데이터 없으면 로그인페이지 이동(아이디 없음)
			// pw비교 O→ 로그인완료 X→로그인페이지로 이동(패스워드 틀림)
		if (dto.getSupporter_password().equals(data.getSupporter_password())) {
			return data;
		}
		return null;
	}
	
	/*
	 * ID 중복을 검사하기 위해 DB에서 값을 SELECT 한다
	 * 
	 * param 중복 검사할 ID
	 * return true - 유저 있음, false - 유저 없음
	 */
	public boolean SupporterIdCheck(String SupporterId) {
		boolean result = false;
		String idCheck = sqlsession.selectOne("SupporterSQL.idCheck", SupporterId);
		if(SupporterId.equals(idCheck)) {
			result = true;
		}
		return result;
	}
}
