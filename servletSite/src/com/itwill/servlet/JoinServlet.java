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
		String address= request.getParameter("address");
		//String hobby=request.getParameter("hobby");
		String[] hobbies=request.getParameterValues("hobby");
		
		/*
		 * 2.Service객체 메소드 호출
		 */ 
		 
		/*
		 * 3.클라이언트에 결과전송
		 */
		out.println("<table cellspacing = '0' width = '350px' border = '1'");
		out.println("<tr>");
		out.println("<td>아이디 :\"+ id + \"</td>");
//		out.println("<ul>");
//		out.println("<li><tr>아이디 :"+ id + "</li>");
//		out.println("<li>이름 :"+ name + "</li>");
//		out.println("<li>성별 :"+ gender + "</li>");
//		out.println("<li>주소 :"+ address + "</li>");
//		out.println("</ul>");
//		out.println("<li>성별:"+gender+"</li>");
//		for (int i = 0; i < hobbies.length; i++) {
//			out.println("<li>취미:"+hobbies[i]+"</li>");
//		}
//		out.println("</ul>");
	}

}
