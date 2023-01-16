package com.Controller;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.AdminServiceImp;
import com.entity.Admin;
@WebServlet("/saveAdmin")
public class AdminController extends HttpServlet {
  @Override
  protected void doPost (HttpServletRequest req,HttpServletResponse resp) throws ServletException{
  String name=req.getParameter("name");
  String password=req.getParameter("password");
  Admin admin=new Admin();
  admin.setName(name);
  admin.setPassword(password);
  AdminServiceImp adminService=new AdminServiceImp();
  adminService.saveAdmin(admin);
  
  
}
}
