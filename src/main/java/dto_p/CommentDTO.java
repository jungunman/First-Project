package dto_p;

import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommentDTO {
	
	int cNoNovel, novNo;
	String cContentNovel,mIdNovel,novImg,novTitle,novEpi,novMid;
	Date cRegdateNovel; //등록일 sdf : yyyy-MM-dd HH:mm 까지 나오게 simpledateformat 적어주기
	
	int cNoBoard, boardNo;
	String cContentBoard,mIdBoard,boardTitle,boardType,boardWriter;
	Date cRegdateBoard;
	
	public String getNovMid() {
		return novMid;
	}

	public void setNovMid(String novMid) {
		this.novMid = novMid;
	}
	
	public String getNovImg() {
		return novImg;
	}

	public void setNovImg(String novImg) {
		this.novImg = novImg;
	}

	public String getNovTitle() {
		return novTitle;
	}

	public void setNovTitle(String novTitle) {
		this.novTitle = novTitle;
	}

	public String getNovEpi() {
		return novEpi;
	}

	public void setNovEpi(String novEpi) {
		this.novEpi = novEpi;
	}

	public int getcNoNovel() {
		return cNoNovel;
	}

	public void setcNoNovel(int cNoNovel) {
		this.cNoNovel = cNoNovel;
	}

	public int getNovNo() {
		return novNo;
	}

	public void setNovNo(int novNo) {
		this.novNo = novNo;
	}

	public String getcContentNovel() {
		return cContentNovel;
	}

	public void setcContentNovel(String cContentNovel) {
		this.cContentNovel = cContentNovel;
	}

	public String getmIdNovel() {
		return mIdNovel;
	}

	public void setmIdNovel(String mIdNovel) {
		this.mIdNovel = mIdNovel;
	}

	public Date getcRegdateNovel() {
		return cRegdateNovel;
	}

	public void setcRegdateNovel(Date cRegdateNovel) {
		this.cRegdateNovel = cRegdateNovel;
	}

	public int getcNoBoard() {
		return cNoBoard;
	}

	public void setcNoBoard(int cNoBoard) {
		this.cNoBoard = cNoBoard;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getcContentBoard() {
		return cContentBoard;
	}

	public void setcContentBoard(String cContentBoard) {
		this.cContentBoard = cContentBoard;
	}

	public String getmIdBoard() {
		return mIdBoard;
	}

	public void setmIdBoard(String mIdBoard) {
		this.mIdBoard = mIdBoard;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public Date getcRegdateBoard() {
		return cRegdateBoard;
	}

	public void setcRegdateBoard(Date cRegdateBoard) {
		this.cRegdateBoard = cRegdateBoard;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public String getcRegdateNovelStr() {
		System.out.println("sdf regNovel=get"+cRegdateNovel);
		return sdf.format(cRegdateNovel);
	}

	public void setcRegdateNovelStr(String cRegdateNovel) {
		try {
			this.cRegdateNovel = sdf.parse(cRegdateNovel);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getcRegdateBoardStr() {
		return sdf.format(cRegdateBoard);
	}

	public void setcRegdateBoardStr(String cRegdateBoard) {
		try {
			this.cRegdateBoard = sdf.parse(cRegdateBoard);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//cRegdateNovel sdf = yyyy-mm-dd hh:mm 까지 출력
	//cRegdateBoard sdf = yyyy-mm-dd hh:mm 까지 출력
	
	
}
