package model.support;

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

	public boolean supportTEMRequest(SupportTEMDTO temdto) {

		boolean result = false;

		// 일시후원 데이터 insert
		if (sqlsession.insert("SupportSQL.supportTEMRequest", temdto) == 1) {
			result = true;
			System.out.println("일시후원 insert완료");
		} else {
			System.out.println("SupportTEMRequestDAO의 insert문에서 문제발생!");
		}

		return result;

	}
}
