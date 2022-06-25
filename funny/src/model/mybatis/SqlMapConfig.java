package model.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory factory;

	static {
		try {
			// config연결
			String resource = "model/mybatis/Config.xml";
			// driver연결체크
			if (resource.length() != 0) {
				System.out.println("driver 찾기 성공");
			} else {
				System.out.println("driver 찾기 실패");
			}

			Reader reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
