package model.support;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.mybatis.SqlMapConfig;

public class SupportTEMDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public SupportTEMDAO() {
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공):");
	}

	// 일시후원 데이터 insert
	public boolean insert(SupportTEMDTO temdto) {
		boolean result = false;

		if (sqlsession.insert("SupportSQL.insertTEM", temdto) == 1) {
			result = true;
			System.out.println("일시후원 insert완료");
		} else {
			System.out.println("SupportTEMRequestDAO의 insert문에서 문제발생!");
		}
		return result;
	}

	// 마이페이지 일시후원 목록 불러오기
	public List<SupportTEMDTO> MypageTEM(String supporter_id) {
		System.out.println("일시후원목록메서드진입 성공");
		List<SupportTEMDTO> datas = sqlsession.selectList("SupportSQL.mypageTEM", supporter_id);
		return datas;

	}

	// 관리자 페이지 용 /////////////////////////////////////////////////////////////////////////////////////////////////////////
	//관리자페이지 일시후원 목록 불러오기
	public List<SupportTEMDTO> AdminTEMSelectAll() {
		System.out.println("TEM메서드진입성공");
		List<SupportTEMDTO> datas = sqlsession.selectList("SupportSQL.AdminTEMSelectAll");
		return datas;
	}

	//관리자페이지 금액순 정렬
	public List<SupportTEMDTO> AdminTEMAmountSelectAll() {
		System.out.println("AdminTEMAmountSelectAll메서드진입성공");
		List<SupportTEMDTO> datas = sqlsession.selectList("SupportSQL.AdminTEMAmountSelectAll");
		return datas;
	}
}
