package dto_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeDTO {
	String mId, nTitle, nContent, iTitle, iContent, iCategory, manager, iAnswer, mImg; 
	int nNo,iNo;
	Date nTime, iTime, answerTime;
	

	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public String getnContentBr() {
		return nContent.replaceAll("\n","<br/>") ;
	}
	
	public String getmImg() {
		return mImg;
	}
	public void setmImg(String mImg) {
		this.mImg = mImg;
	}
	public int getnNo() {
		return nNo;
	}
	public void setnNo(int nNo) {
		this.nNo = nNo;
	}
	public Date getnTime() {
		return nTime;
	}
	public void setnTime(Date nTime) {
		this.nTime = nTime;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public String getnTimeStr() {
		return sdf.format(nTime);
	}
	public void setnTimeStr(String nTime) {
		try {
			this.nTime = sdf.parse(nTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
