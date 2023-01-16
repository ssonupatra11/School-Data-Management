package com.Controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Service.AdminService;
import com.Service.AdminServiceImp;
import com.entity.Teacher;
@WebServlet("/showTeachers")
public class ShowTeachers extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		AdminService adminService=new AdminServiceImp();
		List<Teacher> viewTeacher=adminService.viewAllTeacher();
		
		if(viewTeacher!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("viewTeachers",viewTeacher);
			resp.sendRedirect("showTeachers.jsp");
		  }else{
			resp.sendRedirect("invalidAdmin.jsp");
		  }
	}
}
