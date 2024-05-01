package etc_p;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateControl {

	private SimpleDateFormat sdf;
	private Date days;
	private String daysStr;
	
	/**그냥 생성하면 yyyy-MM-dd 형식으로 지정됩니다. 시간도 필요하면 매개변수 1개 있는 생성자를 이용하세요.
	 * 주의 할 점, 멤버변수값을 변경하는 메소드 호출할 경우 값이 유지 될 수 있습니다.
	 * ex) DateControl dc = new DateControl();
	 * 		dc.setMinusDate(7);
	 * 	
	 * 		7일 전으로 유지 됩니다.
	 * 		다시 현재 값으로 하고 싶으면 새롭게 인스턴스를 생성하여 사용하세요.
	 * */
	public DateControl() {
		this.sdf = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	/** yyyy-MM-dd hh:mm:ss 형식으로 넣어주셔야 제대로 된 값을 호출할 수 있습니다. 혹은 다른 형식으로 넣어도
	 * 무방하지만, 기본 형식을 따르는 것을 추천합니다. */
	public DateControl(String format) {
		this.sdf = new SimpleDateFormat(format);
	}
	
	/** 며칠을 뺄 것인지 숫자를 매개변수로 전달해주면 현재 일 기준 며칠 전으로 갑니다.
	 *	ex) setMinusDate(7) ==> 7일 전 날짜가 days에 저장*/
	public void setMinusDate(int whatDay) {
		Date today = new Date ();
		this.days = new Date(today.getTime ( ) - (long) ( 1000 * 60 * 60 * 24 * whatDay ) );
		this.daysStr = sdf.format(days);
	}
	
	/** 며칠을 더할 것인지 숫자를 매개변수로 전달해주면 현재 일기준 며칠 후로 갑니다.
	 *	ex) setPlusDate(7) ==> 7일 후 날짜가 days에 저장*/
	public void setPlusDate(int whatDay) {
		Date today = new Date ();
		this.days = new Date(today.getTime ( ) + (long) ( 1000 * 60 * 60 * 24 * whatDay ) );
		this.daysStr = sdf.format(days);
	}

	public Date getDays() {
		return days;
	}

	public String getDaysStr() {
		return daysStr;
	}

	
	
	
	
}
