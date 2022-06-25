package model.application;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.animal.AnimalDTO;
import model.mybatis.SqlMapConfig;

public class ApplicationDAO {
	
	SqlSession sqlsession;
	SqlSessionFactory factory = SqlMapConfig.getFactory();

	public ApplicationDAO() {
		// auto commit
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공)");
	}

	// 해당 동물 정보 가져오기
	public AnimalDTO selectAnimal(AnimalDTO dto) {
		AnimalDTO data = sqlsession.selectOne("ApplicationSQL.selectAnimal", dto);
		if(data != null) {
			return data;
		}
		return null;
	}
	
	// 입양신청하기
	public boolean insert(ApplicationDTO dto) {
		boolean result = false;
		if(sqlsession.insert("ApplicationSQL.insert", dto) == 1) {
			result = true;
		}
		return result;
	}	
	
	
	public List<ApplicationDTO> selectApplication( int startRow, int endRow ) {
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		List<ApplicationDTO> ApplicationList = sqlsession.selectList("ApplicationSQL.selectApplication", datas);
		return ApplicationList;
	}
	public int getApplicationCnt() {
		return sqlsession.selectOne("ApplicationSQL.selectCnt");
	}
}
