package model.animal;

import model.mybatis.SqlMapConfig;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AnimalDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;
	HashMap<String, Object> datas = new HashMap<>();

	public AnimalDAO() {
		// auto commit
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공)");
	}

	// 초기 데이터 설정
	public boolean insertAll(List<AnimalDTO> datas) {
		boolean result = false;
		int cnt = 0;
		for (AnimalDTO data : datas) {
			if (sqlsession.insert("AnimalSQL.insert", data) != 0) {
				cnt++;
			}
		}
		if (datas.size() == cnt) {
			result = true;
		}
		return result;
	}

	// 전체 목록 불러오기
	public List<AnimalDTO> selectAll(int startRow, int endRow) {
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<AnimalDTO> AnimalList = sqlsession.selectList("AnimalSQL.selectAll", datas);
		return AnimalList;
	}
	
	// 전체 동물 수
	public int selectCnt() {
		return sqlsession.selectOne("AnimalSQL.selectCnt");
	}

	// 상세 정보 보기
	public AnimalDTO selectOne(AnimalDTO dto) {
		AnimalDTO data = sqlsession.selectOne("AnimalSQL.selectOne", dto);
		return data;
	}

	// 필터 검색
	public List<AnimalDTO> selectSearch(AnimalDTO dto, int startRow, int endRow) {
		datas.put("animal_name", dto.getAnimal_name());
		datas.put("animal_species", dto.getAnimal_species());
		datas.put("animal_gender", dto.getAnimal_gender());
		datas.put("animal_weight_over", dto.getAnimal_weight_over());
		datas.put("animal_weight_under", dto.getAnimal_weight_under());
		datas.put("animal_age_more", dto.getAnimal_age_more());
		datas.put("animal_age_less", dto.getAnimal_age_less());
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<AnimalDTO> AnimalSelectList = sqlsession.selectList("AnimalSQL.selectSearch", datas);
		return AnimalSelectList;
	}
	
	// 필터 검색 개수
	public int selectSearchCnt(AnimalDTO dto) {
		return sqlsession.selectOne("AnimalSQL.selectSearchCnt", dto);
	}

	// 관리자 페이지 용
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////
	// 입양 채택
	public boolean update(String supporter_id, int animal_number) {
		boolean result = false;
		HashMap<String, Object> updateSet = new HashMap<>();
		updateSet.put("supporter_id", supporter_id);
		updateSet.put("animal_number", animal_number);

		if (sqlsession.update("AnimalSQL.update", updateSet) != 0) {
			result = true;
		}
		return result;
	}
}