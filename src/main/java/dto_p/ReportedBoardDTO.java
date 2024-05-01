package dto_p;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportedBoardDTO {
	private int reportNo, reportedBoard, process, novEpi;
	private String mId, title, content, rDateStr;
	private String boardTitle,boardWriter,boardRegDateStr,boardSubtitle,boardContent;
	private Date rDate,boardRegDate;
	private SimpleDateFormat sdf;
	private String answer;
	


	public ReportedBoardDTO() {
		sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	}
	
	public String getBoardContent() {
		return boardContent;
	}
	
	
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	
	
	public String getAnswer() {
		return answer;
	}
	
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	public int getNovEpi() {
		return novEpi;
	}


	public void setNovEpi(int novEpi) {
		this.novEpi = novEpi;
	}


	public String getBoardSubtitle() {
		return boardSubtitle;
	}


	public void setBoardSubtitle(String boardSubtitle) {
		this.boardSubtitle = boardSubtitle;
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
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardRegDateStr() {
		return boardRegDateStr;
	}
	public void setBoardRegDateStr(String boardRegDateStr) {
		this.boardRegDateStr = boardRegDateStr;
	}
	public Date getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(Date boardRegDate) {
		this.boardRegDateStr = sdf.format(boardRegDate);
		this.boardRegDate = boardRegDate;
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
	public int getReportedBoard() {
		return reportedBoard;
	}
	public void setReportedBoard(int reportedBoard) {
		this.reportedBoard = reportedBoard;
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
		this.rDateStr = sdf.format(rDate);
		this.rDate = rDate;
	}

}
