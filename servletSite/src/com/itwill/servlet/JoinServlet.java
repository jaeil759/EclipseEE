package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		/*******************************************
		  1.요청시에 전송되는 파라메타바끼
		     - 파라메타이름은 input element의 name속성과일치
		      	<input type="text" name="xxx">
		     - join.do?xxx=java
		     - request.getParameter("xxx")
		     
		    << POST방식 파라메타 값 한글인코딩 >>
		      - 요청객체에 문자인코딩설정
		        request.setCharacterEncoding("UTF-8");
		          
		 **************************************************/
		
		/*
		 * 1.파라메타바끼
		 */
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address= request.getParameter("addr");
		String job= request.getParameter("job");
		//String hobby=request.getParameter("hobby");
		String[] hobbies=request.getParameterValues("hobby");
		
		/*
		 * 2.Service객체 메소드 호출
		 */ 
		 
		/*
		 * 3.클라이언트에 결과전송
		 */
		out.println("<tr>");
		out.println("<td style='text-align:center' colspan='2'>"+name+"님 가입정보</td>");
		out.println("</tr>");
		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td>" + "아이디" + "</td>");
		out.println("<td>" + id + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "이름" + "</td>");
		out.println("<td>" + name + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "성별" + "</td>");
		out.println("<td>" + gender + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "주소" + "</td>");
		out.println("<td>" + address + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + "직업" + "</td>");
		out.println("<td>" + job + "</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		if (hobbies == null) {
			out.println("<td>취미</td>");
			out.print("<td>없음</td>");
			out.println("</tr>");
		}
		out.println("<td rowspan="+hobbies.length+">취미</td>");
		for (int i = 0; i < hobbies.length; i++) {
			out.println("<td>취미:"+hobbies[i]+"</td>");
			out.println("</tr>");
		}
	}

}
