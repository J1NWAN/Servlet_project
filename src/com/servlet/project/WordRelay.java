package com.servlet.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wordrelay")
public class WordRelay extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Cookie[] cookies = request.getCookies();
		PrintWriter out = response.getWriter();

		String word = request.getParameter("word");
		char lastword = 0;
		char firstword = 0;

		if (word.equals(""))
			out.println("텍스트창에 입력해주세요.");

		if (word.equals(word)) {
			lastword = word.charAt(word.length() - 1);
			Cookie valueCookie = new Cookie("word", String.valueOf(lastword));
			valueCookie.setPath("/wordrelay");
		}

		for(Cookie c : cookies) {
			if(c.getName().equals("word")) {
				firstword = c.getName().charAt(0);
			}
		}
		
		if(lastword == firstword)
			out.println("dddddddddddd");
	}

}
