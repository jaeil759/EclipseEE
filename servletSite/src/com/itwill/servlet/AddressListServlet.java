package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddressListServlet
 */
@WebServlet("/address_list.do")
public class AddressListServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>[주소록리스트]</h1><hr>");
		out.println("<div>");
		out.println("	<a href=''>[주소록쓰기]</a>");
		out.println("</div>");
		out.println("<div>");
		out.println("	<ul>");
		out.println("		<li><a href='address_detail.do?no=1'>1 KIM </a></li>");
		out.println("		<li><a href='address_detail.do?no=3'>3 LEE </a></li>");
		out.println("		<li><a href='address_detail.do?no=7'>7 KIM </a></li>");
		out.println("	</ul>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
