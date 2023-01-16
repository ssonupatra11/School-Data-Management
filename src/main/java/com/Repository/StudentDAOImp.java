package com.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.entity.Student;
import com.util.ConnectionUtil;

public class StudentDAOImp {
	public void saveStudent(Student student) {
		try {
		Connection connection=ConnectionUtil.getConnection();	
		String sql="INSERT INTO student(name,phno,address,email,grades,class,parentPhno,password) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,student.getName());
		ps.setString(2,student.getPhno());
		ps.setString(3,student.getAddress());
		ps.setString(4,student.getEmail());
		ps.setString(5,student.getGrades());
		ps.setString(6,student.getStandard());
		ps.setString(7,student.getParentPho());
		ps.setString(8,student.getPassword());
		int res=ps.executeUpdate();
		System.out.println(res);
		ps.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		Student student=new Student();
//		student.setName("Binod kumar");
//		student.setPhno("8003267367");
//		student.setAddress("Kengeri,Bengaluru");
//		student.setEmail("kumar12@gmail.com");
//		student.setGrades("56.3%");
//		student.setStandard("10");
//		student.setParentPho("9742329323");
//		student.setPassword("9348");
//		StudentDAOImp dao4=new StudentDAOImp();
//		dao4.saveStudent(student);
//	}
}
