package model.support;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.mybatis.SqlMapConfig;
import model.supporter.SupporterDTO;

public class SupportTEMDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public SupportTEMDAO() {
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공)");
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
	public List<SupportTEMDTO> mypage(SupporterDTO dto) {
		System.out.println("일시후원목록메서드진입 성공");
		List<SupportTEMDTO> datas = sqlsession.selectList("SupportSQL.mypageTEM", dto);
		return datas;

	}

	// 관리자 페이지 용 ///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 관리자페이지 일시후원 목록 불러오기
	// 전체페이지 수 확인(페이지네이션)
	public int AdminTEMCntOne() {
		return sqlsession.selectOne("SupportSQL.AdminTEMCntOne");
	}

// 일시후원 전체목록 불러오기
	public List<SupportTEMDTO> AdminTEMSelectList(int startRow, int endRow) {
		System.out.println("AdminTEMSelectList메서드진입성공");
		HashMap<String, Integer> maps = new HashMap<>();
		maps.put("startRow", startRow);
		maps.put("endRow", endRow);
		List<SupportTEMDTO> datas = sqlsession.selectList("SupportSQL.AdminTEMSelectList", maps);
		return datas;
	}

//관리자페이지 일시후원내역 금액순 정렬(오름차순)
	public List<SupportTEMDTO> AdminTEMAmountUpSelectList(int startRow, int endRow) {
		System.out.println("AdminTEMAmountUpSelectList메서드진입성공~!");
		HashMap<String, Integer> maps = new HashMap<>();
		maps.put("startRow", startRow);
		maps.put("endRow", endRow);
		List<SupportTEMDTO> datas = sqlsession.selectList("SupportSQL.AdminTEMAmountUpSelectList", maps);
		return datas;
	}

//관리자페이지 일시후원내역 금액순 정렬(내림차순)
	public List<SupportTEMDTO> AdminTEMAmountDownSelectList(int startRow, int endRow) {
		System.out.println("AdminTEMAmountDownSelectList메서드진입성공~!");
		HashMap<String, Integer> maps = new HashMap<>();
		maps.put("startRow", startRow);
		maps.put("endRow", endRow);
		List<SupportTEMDTO> datas = sqlsession.selectList("SupportSQL.AdminTEMAmountDownSelectList", maps);
		return datas;
	}

//아이디검색기능
	public List<SupportTEMDTO> AdminTEMSearchSelectAll(int startRow, int endRow, String supporter_id) {
		System.out.println("AdminTEMSearchSelectAll메서드진입성공~!");
		HashMap<String, Object> maps = new HashMap<>();
		maps.put("startRow", startRow);
		maps.put("endRow", endRow);
		maps.put("supporter_id", supporter_id);
		List<SupportTEMDTO> datas = sqlsession.selectList("SupportSQL.AdminTEMSearchSelectAll", maps);
		return datas;
	}

	// 아이디검색기능 페이징처리 페이징수
	public int AdminTEMSearchCntOne(String supporter_id) {
		return sqlsession.selectOne("SupportSQL.AdminTEMSearchCntOne", supporter_id);
	}
}
