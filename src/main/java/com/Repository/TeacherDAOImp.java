package com.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.entity.Teacher;
import com.util.AppConstants;

public class TeacherDAOImp implements TeacherDAO{
	
	public Connection getConnection() {
		Connection connection=null;
			try {
				Class.forName(AppConstants.DRIVER_NAME);
				connection=DriverManager.getConnection(AppConstants.URL,"root","root");
			} catch (ClassNotFoundException |  SQLException e) {
				e.printStackTrace();
			}
		return connection;
	}
	
	@Override
	public void saveTeacher(Teacher teacher) {

		try {
		Connection connection=getConnection();			
		String sql="INSERT INTO teacher(name,phno,subject,sal,experience,qualification,email,classTeacher,address,password) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,teacher.getName());
		ps.setString(2,teacher.getPhno());
		ps.setString(3,teacher.getSubject());
		ps.setLong(4,teacher.getSalary());
		ps.setDouble(5,teacher.getExperience());
		ps.setString(6,teacher.getQualification());
		ps.setString(7,teacher.getEmail());
		ps.setString(8,teacher.getClassTeacher());
		ps.setString(9,teacher.getAddress());
		ps.setString(10,teacher.getPassword());
		int res=ps.executeUpdate();
		System.out.println(res);
		ps.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		Teacher teacher=new Teacher();
//		teacher.setName("Legain");
//		teacher.setPhno("9853546227");
//		teacher.setAddress("Marathalli");
//		teacher.setEmail("legain@gmail.com");
//		teacher.setQualification("BTech");
//		teacher.setExperience(5.5);
//		teacher.setClassTeacher("Class 4");
//		teacher.setSalary(540000l);
//		teacher.setSubject("Science");
//		teacher.setPassword("3444");
//		TeacherDAOImp dao1=new TeacherDAOImp();
//		dao1.saveTeacher(teacher);
//	}
}
