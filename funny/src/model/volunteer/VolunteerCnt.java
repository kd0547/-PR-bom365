package model.volunteer;

public class VolunteerCnt {
	private String yymmdd;
	private String date;
	private int cntAM;
	private int cntPM;
	private boolean isfull;
	
	public String getYymmdd() {
		return yymmdd;
	}
	public void setYymmdd(String yymmdd) {
		this.yymmdd = yymmdd;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCntAM() {
		return cntAM;
	}
	public void setCntAM(int cntAM) {
		this.cntAM = cntAM;
	}
	public int getCntPM() {
		return cntPM;
	}
	public void setCntPM(int cntPM) {
		this.cntPM = cntPM;
	}
	public boolean isIsfull() {
		return isfull;
	}
	public void setIsfull(boolean isfull) {
		this.isfull = isfull;
	}
	@Override
	public String toString() {
		return "VolunteerCnt [yymmdd=" + yymmdd + ", date=" + date + ", cntAM=" + cntAM + ", cntPM=" + cntPM
				+ ", isfull=" + isfull + "]";
	}
}
