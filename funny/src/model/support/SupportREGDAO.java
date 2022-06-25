package model.support;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.mybatis.SqlMapConfig;

public class SupportREGDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public SupportREGDAO() {
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공):");
	}
	
	// 정기후원 중 중복 신청 불가
	public List<SupportREGDTO> SupportREGEndCheck(String supporter_id) {
		
		System.out.println("정기후원여부확인 메서드 입장성공");
		return sqlsession.selectList("SupportSQL.SupportREGEndCheck", supporter_id);
		
	}

	// 정기후원 신청
	public boolean insert(SupportREGDTO regdto) {
		boolean result = false;
		if (sqlsession.insert("SupportSQL.insertREG", regdto) != 0) {
			result = true;
			System.out.println("dao에서 insert성공");
		}
		return result;
	}

	// 정기후원 종료
	public boolean setEnd(String supporter_id) {
		System.out.println("dao안의 id: " + supporter_id);
		boolean result = false;

		if (sqlsession.update("SupportSQL.supportREGEnd", supporter_id) != 0) {
			sqlsession.commit();
		} else {
			System.out.println("SupportREGRequestDAO의 update문에서 문제발생!");
			sqlsession.close();
		}
		return result;
	}

	// Mypage 정기후원 목록 불러오기(select)
	public List<MytableREGDTO> selectAll(String support_id) {
		System.out.println("메서드진입 성공");
		return sqlsession.selectList("SupportSQL.Mytable", support_id);
	}

}
