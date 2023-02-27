package cookie.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/goodmorning")
public class CookieS2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int gcount=0;//모든 컴퓨터로 방문하는 횟수 총합, 전역변수로 선언

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 쿠키를 읽는다.
		Cookie[] cookies = request.getCookies();
		boolean isCount = false;// true: count쿠키 있다. false:count쿠키가 없다.
		boolean isFirst = false;// true: count쿠키 있다. false:count쿠키가 없다.
		int count = 1;// 첫 번째 방문 초기값 설정
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("first")) {
					isFirst=true;
				}
				if (cookie.getName().equals("count")) {// 해당하는 쿠키가 있으면
					isCount = true;
					count = Integer.parseInt(cookie.getValue());// 쿠키에서 보내중 방문횟수 읽기
					// 위의 원래 스트링을 인티저로 바꿔줌
					cookie.setValue(++count + "");// 옆에 ""를 추가하면 인트가 스트링으로 변환
					cookie.setMaxAge(60*60*24);// 쿠키 유지 시간
					response.addCookie(cookie);// 위의 쿠키값 업데이트해서 보내줌
				}
			} // for끝

		}
		
		if (isCount == false) {// 해당 쿠키가 없으면-최초접속이라는 의미(쿠기가 null이거나 쿠기는 있지만 count가 없을때)
			Cookie cookie = new Cookie("count", "1");//쿠키를 새로 만들어서
			cookie.setMaxAge(60 * 60 * 24);// 하루
			
			Cookie fcookie = new Cookie("first", "1");//최초접속시만 만들어주는 쿠키
			fcookie.setMaxAge(30);// 30초
			
			response.addCookie(cookie);
			response.addCookie(fcookie);
		}
		String url = "/welcome2.jsp";
		if(count==10 && isFirst) {//count가 위에서 증가하니까 11일때 10번째 방문이다.
			url="/win.jsp";//10번째 방문
			}
		
		//페이지 이동	
		
		request.setAttribute("count", count);//브라우저별 개별 방문횟수
		request.setAttribute("gcount", ++gcount);//모든 사용자들의 방문횟수
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
		
		// 2-1. 해당하는 쿠키가 없으면 새로 생성
		// 2-2. 쿠키가 있으면
		// 2-3. 쿠키값을 읽어서 화면에 보내주고
		// 2-4. 쿠키값에 +1을 해서 다시 쿠키 값 변경
		// 2-5. 쿠키값이 10이라면 당첨페이지로 그렇지 않으면 일반 페이지로

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
