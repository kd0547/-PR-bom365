package model.supportRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.mybatis.SqlMapConfig;

public class SupportTEMRequestDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public SupportTEMRequestDAO() {
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공(sqlsession과 dao연결성공):" + factory);
	}

	public boolean supportTEMRequest(SupportTEMRequestDTO temdto) {

		boolean result = false;

		// 일시후원 데이터 insert
		if (sqlsession.insert("SupportRequestSQL.supportTEMRequest", temdto) != 0) {
			result = true;
		}
		System.out.println("SupportTEMRequestDAO의 insert문에서 문제발생!");
		return result;
	}

}
	    

	
