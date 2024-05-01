package dto_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NovelDTO {
	int novNo, novEpi, novCnt, novLike, novOpen, novTotEpi, novTotCnt, novTotLike;
	String mId, mNickname, novTitle, novImg, novIntro, novGenre, novSubtitle, novCont, serialDate;
	Date novRegdate;
	

	public String getNovSubtitle() {
		return novSubtitle;
	}
	public void setNovSubtitle(String novSubtitle) {
		this.novSubtitle = novSubtitle;
	}
	public String getmNickname() {
		return mNickname;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	public int getNovTotEpi() {
		return novTotEpi;
	}
	public void setNovTotEpi(int novTotEpi) {
		this.novTotEpi = novTotEpi;
	}
	public int getNovTotCnt() {
		return novTotCnt;
	}
	public void setNovTotCnt(int novTotCnt) {
		this.novTotCnt = novTotCnt;
	}
	public int getNovTotLike() {
		return novTotLike;
	}
	public void setNovTotLike(int novTotLike) {
		this.novTotLike = novTotLike;
	}
	public int getNovNo() {
		return novNo;
	}
	public void setNovNo(int novNo) {
		this.novNo = novNo;
	}
	public int getNovEpi() {
		return novEpi;
	}
	public void setNovEpi(int novEpi) {
		this.novEpi = novEpi;
	}
	public int getNovCnt() {
		return novCnt;
	}
	public void setNovCnt(int novCnt) {
		this.novCnt = novCnt;
	}
	public int getNovLike() {
		return novLike;
	}
	public void setNovLike(int novLike) {
		this.novLike = novLike;
	}
	
	public int getNovOpen() {
		return novOpen;
	}
	public void setNovOpen(int novOpen) {
		this.novOpen = novOpen;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getNovTitle() {
		return novTitle;
	}
	public void setNovTitle(String novTitle) {
		this.novTitle = novTitle;
	}
	public String getNovImg() {
		return novImg;
	}
	public void setNovImg(String novImg) {
		this.novImg = novImg;
	}
	public String getNovIntro() {
		return novIntro;
	}
	public void setNovIntro(String novIntro) {
		this.novIntro = novIntro;
	}
	public String getNovGenre() {
		return novGenre;
	}
	public void setNovGenre(String novGenre) {
		this.novGenre = novGenre;
	}
	public String getNovCont() {
		return novCont;
	}
	public void setNovCont(String novCont) {
		this.novCont = novCont;
	}
	public String getNovContBr() {
		return novCont.replaceAll("\n","<br/>") ;
	}
	public String getSerialDate() {
		return serialDate;
	}
	public void setSerialDate(String serialDate) {
		this.serialDate = serialDate;
	}
	public Date getNovRegdate() {
		return novRegdate;
	}
	public void setNovRegdate(Date novRegdate) {
		this.novRegdate = novRegdate;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public String getNovRegdateStr() {
		return sdf.format(novRegdate);
		
	}
	public void setNovRegdateStr(String novRegdate) {
		try {
			this.novRegdate = sdf.parse(novRegdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		
}
