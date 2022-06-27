package model.supportRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.mybatis.SqlMapConfig;

public class SupportREGRequestDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public SupportREGRequestDAO() {
		// autocommit
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공(sqlsession과 dao연결성공):" + factory);
	}
	
	public boolean supportREGRequest(SupportREGRequestDTO regdto) {

		boolean result = false;

		// 정기후원 데이터 insert
		if (sqlsession.insert("SupportRequestSQL.supportREGRequest", regdto) != 0) {
			System.out.println("insert 해줄꺼임:"+ regdto);
			result = true;
		}
		System.out.println("SupportREGRequestDAO의 insert문에서 문제발생!");
		
		System.out.println("insert 완료 후 결과값넘겨줌:"+ result);
		return result;
	}

}
	    
