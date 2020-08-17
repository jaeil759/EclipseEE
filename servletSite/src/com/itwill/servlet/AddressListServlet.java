package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressSevice;


/**
 * Servlet implementation class AddressListServlet
 */
@WebServlet("/address_list.do")
public class AddressListServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
		PrintWriter out=response.getWriter();
		AddressSevice addressService = new AddressSevice(); 
		ArrayList<Address> addressList = addressService.selectAll();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>[주소록리스트]</h1><hr>");
		out.println("<div>");
		out.println("	<a href='address_insert_form.html'>[주소록쓰기폼]</a>");
		out.println("</div>");
		out.println("<div>");
		out.println("	<ul>");
		//out.println("		<li><a href='address_detail.do?no=1'>1 KIM </a></li>");
		for(Address address:addressList) {
			out.println("<li><a href='address_detail.do?no="+address.getNo()+"'>["+address.getNo()+"]"+address.getName()+"</a></li>");
		}
		//out.println("		<li><a href='address_detail.do?no=7'>7 KIM </a></li>");
		out.println("	</ul>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("address_error.html");
		}
	}

}
