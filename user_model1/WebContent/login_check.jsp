<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sUserId=(String)session.getAttribute("sUserId");
	if(sUserId==null){
		response.sendRedirect("user_login_form.jsp");
		return;
	}
%>  