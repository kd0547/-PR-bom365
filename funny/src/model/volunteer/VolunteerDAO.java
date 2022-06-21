package model.volunteer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.volunteer.component.VolunteerCal;
import model.common.JDBCUtil;
import model.volunteer.VolunteerDTO;

public class VolunteerDAO {
	/*
	volunteer
		ㆍ c :	insert				-	봉사신청
		ㆍ r :	select				-	봉사가능여부확인
		ㆍ d :	delete				-	신청취소
	*/
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_insert = "insert into volunteer values((select nvl(max(volunteer_number),0)+1 from volunteer),?,?,?)";
	String sql_select = "select count(*) cnt from volunteer where volunteer_date=? and volunteer_time=?";
	String sql_delete = "delete from volunteer where volunteer_number=?";
	
	// 봉사신청
	public boolean insert(VolunteerDTO dto) { 
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, dto.getSupporter_id());
			pstmt.setString(2, dto.getVolunteer_date());
			pstmt.setString(3, dto.getVolunteer_time());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("VolunteerDAO의 insert()에서 문제발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	// 봉사가능여부확인
	public ArrayList<VolunteerCnt> select(VolunteerCal volCal) {
		conn = JDBCUtil.connect();
		ArrayList<VolunteerCnt> cnts = new ArrayList<VolunteerCnt>();
		String month = "" + volCal.getMonth();
		if (volCal.getMonth() < 10) {
			month = "0" + month;
		}
		try {
			for (int i = 1; i <= volCal.getLastday(); i++) {
				VolunteerCnt cnt = new VolunteerCnt();
				
				String date = "" + i;
				if (i < 10) {
					date = "0" + date;
				}
				String yymmdd=volCal.getYear() + "." + month + "." + date;
				cnt.setYymmdd(yymmdd);
				cnt.setDate(date);
				
				pstmt = conn.prepareStatement(sql_select);
				pstmt.setString(1, yymmdd);
				pstmt.setString(2, "오전");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					cnt.setCntAM(rs.getInt("cnt"));
				} else {
					cnt.setCntAM(0);
				}

				pstmt = conn.prepareStatement(sql_select);
				pstmt.setString(1, yymmdd);
				pstmt.setString(2, "오후");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					cnt.setCntPM(rs.getInt("cnt"));
				} else {
					cnt.setCntPM(0);
				}
				if (cnt.getCntAM() >= 10 && cnt.getCntPM() >= 10) {
					cnt.setIsfull(true);
				}else {
					cnt.setIsfull(false);
				}
				
				cnts.add(cnt);
			}
		} catch (SQLException e) {
			System.out.println("VolunteerDAO의 select()에서 문제 발생!");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return cnts;
	}
	
	// 신청취소
	public boolean delete(VolunteerDTO dto) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, dto.getVolunteer_number());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("VolunteerDAO의 delete()에서 문제 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
