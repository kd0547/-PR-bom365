package model.volunteer;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import controller.volunteer.component.VolunteerCal;
import model.mybatis.SqlMapConfig;
import model.volunteer.VolunteerDTO;

public class VolunteerDAO {
	/*
	volunteer
		ㆍ c :	insert				-	봉사신청
		ㆍ r :	select				-	봉사가능여부확인
		ㆍ d :	delete				-	신청취소
	*/
	
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;

	public VolunteerDAO() {
		// auto commit
		sqlsession = factory.openSession(true);
		System.out.println("factory값 가져오기 성공 (sqlsession과 dao연결성공)");
	}
	
	// 봉사신청
	public boolean insert(VolunteerDTO dto) { 
		boolean result=false;
		if(sqlsession.insert("VolunteerSQL.insert", dto)!=0) {
			result=true;
		}
		return result;
	}
	
	// 봉사가능여부확인
	public ArrayList<VolunteerCnt> select(VolunteerCal volCal) {
		ArrayList<VolunteerCnt> cnts = new ArrayList<VolunteerCnt>();
		String month = "" + volCal.getMonth();
		if (volCal.getMonth() < 10) {
			month = "0" + month;
		}

		for (int i = 1; i <= volCal.getLastday(); i++) {
			VolunteerCnt cnt = new VolunteerCnt();
			HashMap<String, String> pram = new HashMap<String, String>();

			String date = "" + i;
			if (i < 10) {
				date = "0" + date;
			}
			pram.put("volunteer_date", volCal.getYear() + "." + month + "." + date);
			cnt.setYymmdd(pram.get("yymmdd"));
			cnt.setDate(date);

			pram.put("volunteer_time", "오전");
			cnt.setCntAM(sqlsession.selectOne("VolunteerSQL.select", pram));

			pram.replace("volunteer_time", "오후");
			cnt.setCntPM(sqlsession.selectOne("VolunteerSQL.select", pram));

				
			if (cnt.getCntAM() >= 10 && cnt.getCntPM() >= 10) {
				cnt.setIsfull(true);
			} else {
				cnt.setIsfull(false);
			}

			cnts.add(cnt);
		}
		return cnts;
	}
	
	// 신청취소
	public boolean delete(VolunteerDTO dto) {
		boolean result=false;
		if(sqlsession.delete("VolunteerSQL.delete", dto)!=0) {
			result=true;
		}
		return result;
	}
}
