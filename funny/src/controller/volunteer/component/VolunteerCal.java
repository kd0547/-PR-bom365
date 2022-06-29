package controller.volunteer.component;

import java.util.Calendar;

public class VolunteerCal {
	
	Calendar cal = Calendar.getInstance();
	private int currentYear;
	private int year;
	private int beforeYear;
	private int afterYear;
	private int currentMonth;
	private int month;
	private int beforeMonth;
	private int afterMonth;
	private int currentDate;
	private int dayOfweek;
	private int lastday;
	
	public VolunteerCal() {}

	public VolunteerCal(int year, int month) {
		currentYear = cal.get(Calendar.YEAR);
		this.year = year;
		this.beforeYear = year;
		this.afterYear = year;
		
		currentMonth = cal.get(Calendar.MONTH)+1;
		this.month = month;
		if (month == 0) {
			this.year--;
			beforeYear--;
			this.month = 12;
			beforeMonth = 11;
		} else if (month == 1) {
			beforeYear--;
			beforeMonth = 12;
		} else {
			beforeMonth = month - 1;
		}
		
		if (month == 13) {
			this.year++;
			afterYear++;
			this.month = 1;
			afterMonth = 2;
		} else if (month == 12) {
			afterYear++;
			afterMonth = 1;
		} else {
			afterMonth = month + 1;
		}

		currentDate = cal.get(Calendar.DATE);
		cal.set(year, month-1, 1); // 년 , 월 , 1일
		dayOfweek = cal.get(Calendar.DAY_OF_WEEK); 		// 일:1 ~ 토:7
		lastday = cal.getActualMaximum(Calendar.DATE); 	// 출력 년월의 마지막 날짜
	}

	public int getCurrentYear() {
		return currentYear;
	}
	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getBeforeYear() {
		return beforeYear;
	}
	public void setBeforeYear(int beforeYear) {
		this.beforeYear = beforeYear;
	}
	public int getAfterYear() {
		return afterYear;
	}
	public void setAfterYear(int afterYear) {
		this.afterYear = afterYear;
	}
	public int getCurrentMonth() {
		return currentMonth;
	}
	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getBeforeMonth() {
		return beforeMonth;
	}
	public void setBeforeMonth(int beforeMonth) {
		this.beforeMonth = beforeMonth;
	}
	public int getAfterMonth() {
		return afterMonth;
	}
	public void setAfterMonth(int afterMonth) {
		this.afterMonth = afterMonth;
	}
	public int getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(int currentDate) {
		this.currentDate = currentDate;
	}
	public int getDayOfweek() {
		return dayOfweek;
	}
	public void setDayOfweek(int dayOfweek) {
		this.dayOfweek = dayOfweek;
	}
	public int getLastday() {
		return lastday;
	}
	public void setLastday(int lastday) {
		this.lastday = lastday;
	}

	@Override
	public String toString() {
		return "VolunteerCal [cal=" + cal + ", currentYear=" + currentYear + ", year=" + year + ", beforeYear="
				+ beforeYear + ", afterYear=" + afterYear + ", currentMonth=" + currentMonth + ", month=" + month
				+ ", beforeMonth=" + beforeMonth + ", afterMonth=" + afterMonth + ", currentDate=" + currentDate
				+ ", dayOfweek=" + dayOfweek + ", lastday=" + lastday + "]";
	}
}
