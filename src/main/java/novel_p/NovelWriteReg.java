package novel_p;

import java.io.IOException;

import dao_p.NovelDAO;
import dto_p.NovelDTO;
import etc_p.FileUp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NovelService;

public class NovelWriteReg implements NovelService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("novEpi"));
		NovelDTO dto = new NovelDTO();
		
		String novTitle = request.getParameter("novTitle");
		String mId = request.getParameter("mId");
		
		String [] serialDateArr = request.getParameterValues("serialDate");
		String serialDate="";
		
		for(String sd : serialDateArr) {
			serialDate += sd+",";
		}
		
//		System.out.println(serialDate.substring(0,serialDate.length()-1));
		int epiNo = Integer.parseInt(request.getParameter("novEpi"));
		
		
		
		if(epiNo == 1) {
			try {
				String upFileName = new FileUp(request).fileUpload(request.getPart("upFile"));
				dto.setNovImg(upFileName);
				
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			dto.setNovImg(request.getParameter("novImg"));			
		}
		
		dto.setNovTitle(novTitle);
		dto.setmId(mId);
		dto.setNovGenre(request.getParameter("novGenre"));
		dto.setNovIntro(request.getParameter("novIntro"));
		dto.setSerialDate(serialDate.substring(0,serialDate.length()-1));		
		dto.setNovEpi(epiNo);
		dto.setNovSubtitle(request.getParameter("novSubtitle"));
		dto.setNovCont(request.getParameter("novCont"));
		dto.setNovOpen(Integer.parseInt(request.getParameter("novOpen")));
		
		
		new NovelDAO().novelWrite(dto);
		
		request.setAttribute("msg", "작성되었습니다");
		request.setAttribute("move","NovelDetail?novTitle="+novTitle+"&novMid="+mId);
		request.setAttribute("incUrl", "components/moveUrl.jsp");

	}

	private char[] removeLastChar(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
