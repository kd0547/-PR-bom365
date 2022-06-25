package model.application;

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
}
