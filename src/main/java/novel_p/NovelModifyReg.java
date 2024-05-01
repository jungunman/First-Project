package novel_p;

import java.io.IOException;

import dao_p.NovelDAO;
import dto_p.NovelDTO;
import etc_p.FileUp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NovelService;

public class NovelModifyReg implements NovelService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			NovelDTO dto = new NovelDTO();
	
			String novTitle = request.getParameter("novTitle");
			String newTitle = request.getParameter("newTitle");
			String novMid = request.getParameter("mId");
			
			String [] serialDateArr = request.getParameterValues("serialDate");
			String serialDate="";
			String upFileName = new FileUp(request).fileUpload(request.getPart("upFile"));
			String curFileName = request.getParameter("curFile");
			
			
//			System.out.println("1 : "+upFileName+" / "+curFileName);
			
			if(upFileName == null) {				
				dto.setNovImg(curFileName);	
//				System.out.println("2 ==null : "+upFileName+" / "+curFileName);
			}else {
				if(!curFileName.equals("cover_holder.jpg")) {					
					new FileUp(request).fileDelete(curFileName);
				}
				dto.setNovImg(upFileName);
//				System.out.println("2 ==else : "+upFileName+" / "+curFileName);
			}
			
			for(String sd : serialDateArr) {
				serialDate += sd+",";
			}
			
			
			dto.setmId(novMid);
			dto.setNovTitle(newTitle);
			dto.setNovGenre(request.getParameter("novGenre"));
			dto.setNovIntro(request.getParameter("novIntro"));
			dto.setSerialDate(serialDate.substring(0,serialDate.length()-1));
			
			new NovelDAO().novelModify(dto , novTitle);
			
//			System.out.println("소설모디reg 왔음" + novTitle + "/"+ request.getParameter("newTitle"));
	//		System.out.println(request.getParameter("novSubtitle"));
	//		System.out.println(request.getParameter("novCont"));
			
			request.setAttribute("msg", "수정되었습니다");
			request.setAttribute("move","NovelDetail?novTitle="+newTitle+"&novMid="+novMid);
			request.setAttribute("incUrl", "components/moveUrl.jsp");
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
