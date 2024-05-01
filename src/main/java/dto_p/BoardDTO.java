package dto_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



	public class BoardDTO {
		
		int no, like,cnt;
		String type,content,title,img,mId;
		Date writeDay, WriteDayStr;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
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
		
		
		
		




