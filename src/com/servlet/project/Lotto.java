package com.servlet.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto")
public class Lotto extends HttpServlet {
	
	int[] num = new int[6];
	ArrayList<String> list = new ArrayList<String>();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		int value = Integer.parseInt(request.getParameter("num"));

		lottoCreate(value);

		out.println("<HTML>");
		out.println("<HEAD><TITLE>로또 번호</TITLE></HEAD>");
		out.println("<body><center>");
		out.println("<h2>생성 결과</h2><hr>");
		for (int i = 0; i < list.size(); i++) {
			out.println(i+1 + "회차 : " + list.get(i));
			out.println("<br><br>");
		}
		out.println("</body></html>");
	}
	
	public void lottoCreate(int value) {
		for (int i = 0; i < value; i++) {
			for (int j = 0; j < num.length; j++)
				num[j] = (int)(Math.random() * 46 + 1);
			
			list.add(num[0] + " " + num[1] + " " + num[2] + " " + num[3] + " " + num[4] + " " + num[5]);
		}
	}
}
