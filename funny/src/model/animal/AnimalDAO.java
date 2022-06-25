package model.animal;

import model.mybatis.SqlMapConfig;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AnimalDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public AnimalDAO() {
		// auto commit
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공)");
	}

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
	
	public List<AnimalDTO> selectAll() {
		List<AnimalDTO> datas = sqlsession.selectList("AnimalSQL.selectAll");
		return datas;
	}
	
	public AnimalDTO selectOne(AnimalDTO dto) {
		AnimalDTO data = sqlsession.selectOne("AnimalSQL.selectOne", dto);
		return data;
	}
	
	public List<AnimalDTO> selectSearch(AnimalDTO dto) {
		List<AnimalDTO> AnimalSelectList = sqlsession.selectList("AnimalSQL.selectSearch", dto);
		return AnimalSelectList;
	}
}