package dto_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InquiryDTO {

	String iTitle, iContent, iCategory, manager, iAnswer, mId, iImg, aTitle; 
	int iNo;
	Date iTime, answerTime;
	
	//1:1 문의 관련 getter,setter
		public String getiTitle() {
			return iTitle;
		}
		public String getaTitle() {
			return aTitle;
		}
		public void setaTitle(String aTitle) {
			this.aTitle = aTitle;
		}
		public void setiTitle(String iTitle) {
			this.iTitle = iTitle;
		}
		public String getiImg() {
			return iImg;
		}
		public void setiImg(String iImg) {
			this.iImg = iImg;
		}
		public String getiContent() {
			return iContent;
		}
		public String getiContentBr() {
			return iContent.replaceAll("\n","<br/>") ;
		}
		public void setiContent(String iContent) {
			this.iContent = iContent;
		}
		public String getiCategory() {
			return iCategory;
		}
		public void setiCategory(String iCategory) {
			this.iCategory = iCategory;
		}
		public String getManager() {
			return manager;
		}
		public void setManager(String manager) {
			this.manager = manager;
		}
		public String getiAnswer() {
			return iAnswer;
		}
		public String getiAnswerBr() {
			return iAnswer.replaceAll("\n","<br/>") ;
		}
		
		public void setiAnswer(String iAnswer) {
			this.iAnswer = iAnswer;
		}
		public int getiNo() {
			return iNo;
		}
		public void setiNo(int iNo) {
			this.iNo = iNo;
		}
		
		public Date getiTime() {
			return iTime;
		}
		public void setiTime(Date iTime) {
			this.iTime = iTime;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		public String getiTimeStr() {
			return sdf.format(iTime);
		}
		public void setiTimeStr(String iTime) {
			try {
				this.iTime = sdf.parse(iTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Date getAnswerTime() {
			return answerTime;
		}
		public void setAnswerTime(Date answerTime) {
			this.answerTime = answerTime;
		}	
		public String getAnswerTimeStr() {
			return sdf.format(answerTime);
		}
		public void setAnswerTimeStr(String answerTime) {
			try {
				this.answerTime = sdf.parse(answerTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public String getmId() {
			return mId;
		}
		public void setmId(String mId) {
			this.mId = mId;
		}
		
}
