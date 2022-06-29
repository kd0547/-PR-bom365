package model.support;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.mybatis.SqlMapConfig;
import model.supporter.SupporterDTO;

public class SupportREGDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public SupportREGDAO() {
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공)");
	}

	// 정기후원 중 중복 신청 불가
	public List<SupportREGDTO> supportREGEndCheck(String supporter_id) {
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
		boolean result = false;

		if (sqlsession.update("SupportSQL.setREGEnd", supporter_id) != 0) {
			sqlsession.commit();
		} else {
			System.out.println("SupportREGRequestDAO의 setEnd문에서 문제발생!");
			sqlsession.close();
		}
		return result;
	}

	// 마이페이지 정기후원 목록 불러오기
	public List<SupportREGDTO> mypage(SupporterDTO dto) {
		System.out.println("정기후원목록메서드진입 성공");
		List<SupportREGDTO> datas = sqlsession.selectList("SupportSQL.mypageREG", dto);
		return datas;
	}

	// 관리자 페이지 용 ///////////////////////////////////////////////////////////////////////////////////////////////////////
	// 관리자페이지 정기후원 목록 불러오기
	public List<SupportREGDTO> adminREGSelectAll() {
		System.out.println("AdminREGSelectAll메서드진입성공");
		List<SupportREGDTO> datas = sqlsession.selectList("SupportSQL.AdminREGSelectAll");
		return datas;
	}

	// 관리자페이지 정기후원내역 금액순 정렬
	public List<SupportREGDTO> adminREGAmountSelectAll() {
		System.out.println("AdminREGAmountSelectAll메서드진입성공");
		List<SupportREGDTO> datas = sqlsession.selectList("SupportSQL.AdminREGAmountSelectAll");
		return datas;
	}
}
