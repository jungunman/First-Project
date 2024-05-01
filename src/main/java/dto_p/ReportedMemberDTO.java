package dto_p;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportedMemberDTO {
	private int reportNo,reportedMember,reportMember, process;
	private String reportMemberId,MemberName ,mId, title, content, reportedMemberMId, rDateStr, reportedMemberNickname;
	private Date rDate;
	private String answer;
	
	
	public String getMemberName() {
		return MemberName;
	}
	
	
	public String getReportMemberId() {
		return reportMemberId;
	}


	public void setReportMemberId(String reportMemberId) {
		this.reportMemberId = reportMemberId;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public String getReportedMemberNickname() {
		return reportedMemberNickname;
	}
	public void setReportedMemberNickname(String reportedMemberNickname) {
		this.reportedMemberNickname = reportedMemberNickname;
	}
	public int getProcess() {
		return process;
	}
	public void setProcess(int process) {
		this.process = process;
	}
	public String getrDateStr() {
		return rDateStr;
	}
	public void setrDateStr(String rDateStr) {
		this.rDateStr = rDateStr;
	}
	public int getReportMember() {
		return reportMember;
	}
	public void setReportMember(int reportMember) {
		this.reportMember = reportMember;
	}
	public int getReportedMember() {
		return reportedMember;
	}
	public void setReportedMember(int reportedMember) {
		this.reportedMember = reportedMember;
	}
	public String getReportedMemberMId() {
		return reportedMemberMId;
	}
	public void setReportedMemberMId(String reportedMemberMId) {
		this.reportedMemberMId = reportedMemberMId;
	}
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.rDateStr = sdf.format(rDate);
		this.rDate = rDate;
	}

	

}
