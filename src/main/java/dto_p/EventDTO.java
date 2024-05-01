package dto_p;

import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventDTO {

	int eveNo;
	String eveTitle, eveContent, eveImg ,eveEndDateStr, eveRegDateStr;
	Date eveStartDate, eveEndDate, eveRegdate;
	SimpleDateFormat sdf;
	SimpleDateFormat sdf2;
	
	public EventDTO() {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	}
	
	
	public String getEveEndDateStr() {
		return eveEndDateStr;
	}
	public void setEveEndDateStr(String eveEndDateStr) {
		this.eveEndDateStr = eveEndDateStr;
		try {
			this.eveEndDate = sdf.parse(eveEndDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getEveNo() {
		return eveNo;
	}
	public void setEveNo(int eveNo) {
		this.eveNo = eveNo;
	}
	public String getEveTitle() {
		return eveTitle;
	}
	public void setEveTitle(String eveTitle) {
		this.eveTitle = eveTitle;
	}
	public String getEveContent() {
		return eveContent;
	}
	public void setEveContent(String eveContent) {
		this.eveContent = eveContent;
	}
	public String getEveImg() {
		return eveImg;
	}
	public void setEveImg(String eveImg) {
		this.eveImg = eveImg;
	}
	public Date getEveStartDate() {
		return eveStartDate;
	}
	public void setEveStartDate(Date eveStartDate) {
		this.eveStartDate = eveStartDate;
	}
	public Date getEveEndDate() {
		return eveEndDate;
	}
	public void setEveEndDate(Date eveEndDate) {
		
		this.eveEndDate = eveEndDate;
	}
	public Date getEveRegdate() {
		return eveRegdate;
	}
	public void setEveRegdate(Date eveRegdate) {
		this.eveRegdate = eveRegdate;
		this.eveRegDateStr = sdf2.format(eveRegdate);
	}


	public String getEveRegDateStr() {
		return eveRegDateStr;
	}


	public void setEveRegDateStr(String eveRegDateStr) {
		this.eveRegDateStr = eveRegDateStr;
	}
	


	//시작 등록일 sdf
	
	// 시작일
	public String getEveStartDateStr() {
		return sdf.format(eveStartDate);
	}
	public void setEveStartDateStr(String e_startDate) {
		try {
			this.eveStartDate = sdf.parse(e_startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//마감일
//	public String getEveEndDateStr() {
//		if(this.eveEndDate!=null) {
//			return sdf.format(this.eveEndDate);
//		}
//		return null;
//	}
//	public void setEveEndDateStr(String eveEndDate) {
//		if(eveEndDate!=null) {
//			try {
//				this.eveEndDate = sdf.parse(eveEndDate);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}	
//	}
	
	
	//등록일	
	//SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public String getEveRegdateStr() {
		return sdf2.format(eveRegdate);
	}
	public void setEveRegdateStr(String eveRegdate) {
		try {
			this.eveRegdate = sdf2.parse(eveRegdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public void setEveRegdateStr(Timestamp timestamp) {
	}
	
}
