package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Service.AdminService;
import com.Service.AdminServiceImp;
import com.entity.Admin;
@WebServlet("/adminLogin")

//This class is used to validate admin
public class ValidateAdmin extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	AdminService adminService=new AdminServiceImp();
	Admin admin=adminService.validateAdmin(req.getParameter("name"),req.getParameter("password"));
	
	if(admin!=null) {
		HttpSession session=req.getSession();
		session.setAttribute("admin",admin);
		resp.sendRedirect("adminMenu.jsp");
	  }else{
		resp.sendRedirect("invalidAdmin.jsp");
	  }
}
}
