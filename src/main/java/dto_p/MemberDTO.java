package dto_p;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberDTO {
	Date regDate;
	String mId, mName, mPwd, generation,  mProfile, email, mTel, mNickname, frontNum, backNum;
	int mNo, gender, field;
	private String regDateStr;
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public String getRegDateStr() {
		return regDateStr;
	}
	public void setRegDateStr(String regDate) {
			try {
				this.regDateStr = regDate;
				this.regDate = sdf.parse(regDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDateStr = sdf.format(regDate);
		this.regDate = regDate;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmPwd() {
		return mPwd;
	}
	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	public String getmProfile() {
		return mProfile;
	}
	public void setmProfile(String mProfile) {
		this.mProfile = mProfile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getmTel() {
		return mTel;
	}
	public void setmTel(String mTel) {
		this.mTel = mTel;
	}
	public String getmNickname() {
		return mNickname;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	public String getFrontNum() {
		return frontNum;
	}
	public void setFrontNum(String frontNum) {
		this.frontNum = frontNum;
	}
	public String getBackNum() {
		return backNum;
	}
	public void setBackNum(String backNum) {
		this.backNum = backNum;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getField() {
		return field;
	}
	public void setField(int field) {
		this.field = field;
	}
	
	
	
}
