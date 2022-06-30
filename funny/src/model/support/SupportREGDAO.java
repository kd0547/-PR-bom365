package model.support;

import java.util.HashMap;
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
	//전체페이지 수 확인
	public int AdminREGCntOne() {
		return sqlsession.selectOne("SupportSQL.AdminREGCntOne");
	}
	
	// 관리자페이지 정기후원 목록 불러오기
	public List<SupportREGDTO> AdminREGSelectList(int startRow, int endRow) {
		System.out.println("AdminREGSelectAll메서드진입성공");
		HashMap<String, Integer> maps = new HashMap<>();
		maps.put("startRow",startRow);
		maps.put("endRow",endRow);
		List<SupportREGDTO> datas = sqlsession.selectList("SupportSQL.AdminREGSelectList",maps);
		return datas;
	}

	//관리자페이지 정기후원내역 금액순 정렬(내림차순)
	public List<SupportREGDTO> AdminREGAmountDownSelectList(int startRow, int endRow){
		System.out.println("AdminREGAmountDownSelectList메서드진입성공~!");
		HashMap<String, Integer> maps = new HashMap<>();
		maps.put("startRow",startRow);
		maps.put("endRow",endRow);
		List<SupportREGDTO> datas = sqlsession.selectList("SupportSQL.AdminREGAmountDownSelectList",maps);
		return datas;
	}
	
	//관리자페이지 정기후원내역 금액순 정렬(오름차순)
	public List<SupportREGDTO> AdminREGAmountUpSelectList(int startRow, int endRow){
		System.out.println("AdminREGAmountUpSelectList메서드진입성공~!");
		HashMap<String, Integer> maps = new HashMap<>();
		maps.put("startRow",startRow);
		maps.put("endRow",endRow);
		List<SupportREGDTO> datas = sqlsession.selectList("SupportSQL.AdminREGAmountUpSelectList",maps);
		return datas;
	}

	//관리자페이지 정기후원내역 상황순정렬(종료)
	public List<SupportREGDTO> AdminREGEndtSelectAll(int startRow, int endRow){
		System.out.println("AdminREGEndtSelectAll메서드진입성공");
		HashMap<String, Integer> maps = new HashMap<>();
		maps.put("startRow",startRow);
		maps.put("endRow",endRow);
		List<SupportREGDTO> datas = sqlsession.selectList("SupportSQL.AdminREGEndtSelectAll",maps);
		return datas;
	}	

	//관리자페이지 페이징처리 페이징수(종료)
		public int TotalCountSituationEnd() {
			return sqlsession.selectOne("SupportSQL.TotalCountSituationEnd");
		}
	
	//관리자페이지 정기후원내역 상황순정렬(진행중)
	public List<SupportREGDTO> AdminREGIngtSelectAll(int startRow, int endRow){
		System.out.println("AdminREGIngtSelectAll메서드진입성공");
		HashMap<String, Integer> maps = new HashMap<>();
		maps.put("startRow",startRow);
		maps.put("endRow",endRow);
		List<SupportREGDTO> datas = sqlsession.selectList("SupportSQL.AdminREGIngtSelectAll",maps);
		return datas;
	}

	//관리자페이지 페이징처리 페이징수(진행중)
	public int TotalCountSituationIng() {
		return sqlsession.selectOne("SupportSQL.TotalCountSituationIng");
	}
	
	//아이디검색기능
	public List<SupportREGDTO> AdminREGSearchSelectAll(int startRow,int endRow, String supporter_id) {
		System.out.println("AdminREGSearchSelectAll메서드진입성공~!");
		HashMap<String, Object> maps = new HashMap<>();
		maps.put("startRow",startRow);
		maps.put("endRow",endRow);
		maps.put("supporter_id", supporter_id);
		List<SupportREGDTO> datas = sqlsession.selectList("SupportSQL.AdminREGSearchSelectAll",maps);
		return datas;
	}
	//아이디검색기능 페이징처리 페이징수	
	public int AdminREGSearchCntOne(String supporter_id) {
		return sqlsession.selectOne("SupportSQL.AdminREGSearchCntOne",supporter_id);
	}
}
