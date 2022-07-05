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
	HashMap<String, Object> datas = new HashMap<>();

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
		String month = String.format("%02d", volCal.getMonth());
		
		for (int i = 1; i <= volCal.getLastday(); i++) {
			VolunteerCnt cnt = new VolunteerCnt();

			String date = String.format("%02d", i);

			datas.put("volunteer_date", volCal.getYear() + "/" + month  + "/" + date);
			cnt.setYyyyMMdd(""+datas.get("volunteer_date"));
			cnt.setDate(String.format("%02d", i));

			datas.put("volunteer_time", "오전");
			cnt.setCntAM(sqlsession.selectList("VolunteerSQL.selectDate", datas).size());

			datas.replace("volunteer_time", "오후");
			cnt.setCntPM(sqlsession.selectList("VolunteerSQL.selectDate", datas).size());

				
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
	
	// my page  ///////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<VolunteerDTO> mypage(SupporterDTO dto) {	// my page  겸용
		List<VolunteerDTO> data = sqlsession.selectList("VolunteerSQL.mypage", dto);
		return data;
	}

	// 관리자 페이지 ///////////////////////////////////////////////////////////////////////////////////////////////////////
	// 해당 봉사자의 봉사신청 리스트 조회
	public List<VolunteerDTO> selectSearch(SupporterDTO dto, int startRow, int endRow) {
		datas.put("supporter_id", dto.getSupporter_id());
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		
		List<VolunteerDTO> volList = sqlsession.selectList("VolunteerSQL.selectSearch", datas);
		return volList;
	}
	
	// 검색 글 개수
	public int selectSearchCnt(SupporterDTO dto) {
		return sqlsession.selectOne("VolunteerSQL.selectSearchCnt", dto);
	}
	
	// 날짜별 신청명단 보기 - AM
	public List<VolunteerDTO> selectDateAM(String yyyyMMdd) {	
		datas.put("volunteer_date", yyyyMMdd);
		datas.put("volunteer_time", "오전");
		return sqlsession.selectList("VolunteerSQL.selectDate", datas);
	}
	
	// 날짜별 신청명단 보기 - PM
	public List<VolunteerDTO> selectDatePM(String yyyyMMdd) {	
		datas.put("volunteer_date", yyyyMMdd);
		datas.put("volunteer_time", "오후");
		return sqlsession.selectList("VolunteerSQL.selectDate", datas);
	}
	
	
	
	
	
	
}
