package com.servlet.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int result;
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String operator = request.getParameter("operator");
		
		result = calc(num1, num2, operator);
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>계산기</TITLE></HEAD>");
		out.println("<body><center>");
		out.println("<h2>계산 결과</h2><hr>");
		out.println(num1 + " " + operator + " " + num2 + " = " + result);
		out.println("</body></html>");
	}
	
	int calc(int num1, int num2, String operator) {
		
		if(operator.equals("+")) {
			return num1 + num2;
		} else if(operator.equals("-")) {
			return num1 - num2;
		} else if(operator.equals("*")) {
			return num1 * num2;
		} else if(operator.equals("/")) {
			return num1 / num2;
		}
		
		return 0;
	}

}
