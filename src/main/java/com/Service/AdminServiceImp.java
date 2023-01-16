	package com.Service;
	
	import java.util.List;

import com.Repository.AdminDAO;
	import com.Repository.AdminDAOImp;
	import com.entity.Admin;
import com.entity.Student;
import com.entity.Teacher;
	
	public class AdminServiceImp implements AdminService{
		public AdminDAO adminDAO; 
		public AdminServiceImp() {
			adminDAO=new AdminDAOImp();
		}
		public void saveAdmin(Admin admin) {
			adminDAO.saveAdmin(admin);
		}
		@Override
		public Admin validateAdmin(String name,String password) {
			return adminDAO.validateAdmin(name,password);
		}
		@Override
		public void saveTeacher(Teacher teacher) {
			adminDAO.saveTeacher(teacher);
			
		}
		@Override
		public void updateTeacher(Teacher teacher) {
			adminDAO.updateTeacher(teacher);
			
		}
		@Override
		public void deleteTeacher(Long id) {
			adminDAO.deleteTeacher(id);
			
		}
		@Override
		public Teacher viewTeacherById(Long id) {
			return adminDAO.viewTeacherById(id);
		}
		@Override
		public List<Teacher> viewAllTeacher() {
			return adminDAO.viewAllTeacher();
		}
		@Override
		public void saveStudent(Student student) {
			adminDAO.saveStudent(student);
			
		}
		@Override
		public void updateStudent(Student student) {
			adminDAO.updateStudent(student);
			
		}
		@Override
		public void deleteStudent(Long id) {
			adminDAO.deleteStudent(id);
			
		}
		@Override
		public Student viewStudentById(Long id) {
			return adminDAO.viewStudentById(id);
		}
		@Override
		public List<Student> viewAllStudent() {
			return adminDAO.viewAllStudent();
		}
	}
