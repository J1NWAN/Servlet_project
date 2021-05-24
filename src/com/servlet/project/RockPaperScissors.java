package com.servlet.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rps")
public class RockPaperScissors extends HttpServlet {
	String computer;
	String result;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		int computer_ = (int) (Math.random() * 3);
		String user = request.getParameter("value");

		if (computer_ == 0) {
			computer = "바위";
		} else if (computer_ == 1) {
			computer = "가위";
		} else if (computer_ == 2) {
			computer = "보";
		}

		out.println("<HTML>");
		out.println("<HEAD><TITLE>가위바위보 게임</TITLE></HEAD>");
		out.println("<body><center>");
		out.println("<h2>승부 결과</h2><hr>");
		out.println("<h3>컴퓨터 : " + computer + "<br>유저 : " + user + "</h3><br>");
		out.println(vs(computer, user));
		out.println("</body></html>");
	}

	public String vs(String computer, String user) {

		if(computer.equals(user)) {
			result = "비겼습니다.";
			
		} else if(computer.equals("바위")) {
			
			if(user.equals("가위")) {
				result = "컴퓨터가 이겼습니다.";
			} else {
				result = "당신이 이겼습니다.";
			}
			
		} else if(computer.equals("가위")) {
			
			if(user.equals("바위")) {
				result = "당신이 이겼습니다.";
			} else {
				result = "컴퓨터가 이겼습니다.";
			}
		} else {
			if(user.equals("바위")) {
				result = "컴퓨터가 이겼습니다.";
			} else {
				result = "당신이 이겼습니다.";
			}
		}

		return result;
	}

}
