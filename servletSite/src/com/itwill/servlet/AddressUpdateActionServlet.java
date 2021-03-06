package com.itwill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import com.itwill.address.Address;
import com.itwill.address.AddressSevice;

/**
 * Servlet implementation class AddressUpdateActionServlet
 */
@WebServlet("/address_update_action.do")
public class AddressUpdateActionServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, 
			             HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("address_main.html");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			  0.요청객체 encoding설정
			  1.파라메타 바끼(no,id,name,phone,address)
			  3.파라메타데이타로 Address객체생성
			  2.AddressService객체생성
			  4.AddressService.update()메쏘드실행
			  5.adress_view.do로 redirection
		 */
		try {
			request.setCharacterEncoding("UTF-8");
			String noStr=request.getParameter("no");
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			Address updateAddress=new Address(Integer.parseInt(noStr),id,name, phone, address);
			AddressSevice addressSevice=new AddressSevice();
			int updateRowCount = addressSevice.update(updateAddress);
			response.sendRedirect("address_detail.do? no="+noStr);
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("address_error.html");
		}
		
	}

}
