package model.volunteer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import controller.volunteer.component.VolunteerCal;
import model.mybatis.SqlMapConfig;
import model.supporter.SupporterDTO;
import model.volunteer.VolunteerDTO;

public class VolunteerDAO {
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
	
	// 해당 날짜에 봉사 가능한지 확인
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
			pram.put("volunteer_date", volCal.getYear() + "/" + month + "/" + date);
			cnt.setYymmdd(pram.get("volunteer_date"));
			cnt.setDate(date);

			pram.put("volunteer_time", "오전");
			cnt.setCntAM(sqlsession.selectOne("VolunteerSQL.selectIsFull", pram));

			pram.replace("volunteer_time", "오후");
			cnt.setCntPM(sqlsession.selectOne("VolunteerSQL.selectIsFull", pram));

				
			if (cnt.getCntAM() >= 10 && cnt.getCntPM() >= 10) {
				cnt.setIsfull(true);
			} else {
				cnt.setIsfull(false);
			}

			cnts.add(cnt);
		}
		return cnts;
	}
	
	// 신청 여부 확인
	public VolunteerDTO selectSupporter(VolunteerDTO dto) {
		VolunteerDTO data = sqlsession.selectOne("VolunteerSQL.selectIsDone", dto);
		return data;
	}
	
	// 신청취소
	public boolean delete(VolunteerDTO dto) {
		boolean result=false;
		if(sqlsession.delete("VolunteerSQL.delete", dto)!=0) {
			result=true;
		}
		return result;
	}
	
	// my page / 관리자 검색 ///////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<VolunteerDTO> selectSupporter(SupporterDTO dto) {
		List<VolunteerDTO> data = sqlsession.selectList("VolunteerSQL.selectSupporter", dto);
		return data;
	}
	
	
	
	
	
}
