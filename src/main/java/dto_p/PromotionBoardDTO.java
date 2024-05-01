package dto_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PromotionBoardDTO {

	int no, like,cnt, novNo;
	String type,content,title,img,mId;
	Date writeDay, writeDayStr;
	String mNickname,nTitle,nImg,novDateStr, novGenre, serialDate,novAuthor, novIntro;
	private int novLike,novCnt, novMaxEpi;
	private Date novDate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	
	public int getNovMaxEpi() {
		return novMaxEpi;
	}
	public void setNovMaxEpi(int novMaxEpi) {
		this.novMaxEpi = novMaxEpi;
	}
	public String getNovAuthor() {
		return novAuthor;
	}
	public void setNovAuthor(String novAuthor) {
		this.novAuthor = novAuthor;
	}
	public String getNovIntro() {
		return novIntro;
	}
	public void setNovIntro(String novIntro) {
		this.novIntro = novIntro;
	}
	public String getNovDateStr() {
		return novDateStr;
	}
	public void setNovDateStr(String novDateStr) {
		this.novDateStr = novDateStr;
	}
	public String getNovGenre() {
		return novGenre;
	}
	public void setNovGenre(String novGenre) {
		this.novGenre = novGenre;
	}
	public String getSerialDate() {
		return serialDate;
	}
	public void setSerialDate(String serialDate) {
		this.serialDate = serialDate;
	}
	public int getNovLike() {
		return novLike;
	}
	public void setNovLike(int novLike) {
		this.novLike = novLike;
	}
	public int getNovCnt() {
		return novCnt;
	}
	public void setNovCnt(int novCnt) {
		this.novCnt = novCnt;
	}
	public Date getNovDate() {
		return novDate;
	}
	public void setNovDate(Date novDate) {
		this.novDateStr = sdf.format(novDate);
		this.novDate = novDate;
	}
	public String getmNickname() {
		return mNickname;
	}
	public int getNovNo() {
		return novNo;
	}
	public void setNovNo(int novNo) {
		this.novNo = novNo;
	}
	public String getnImg() {
		return nImg;
	}
	public void setnImg(String nImg) {
		this.nImg = nImg;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public Date getWriteDay() {
		return writeDay;
	}
	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}

	
	public String getWriteDayStr() {
		return sdf.format(writeDay);
	}
	
	public void setWriteDayStr(String writeDay) {
		try {
			this.writeDay =sdf.parse(writeDay);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
}
