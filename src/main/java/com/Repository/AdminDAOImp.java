package com.Repository;

import com.entity.Admin; 
import com.entity.Student;
import com.entity.Teacher;
import com.util.AppConstants;
import com.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImp implements AdminDAO {
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
	/*
	 * @ author S.Sonu Patra
	 * This method is used to add/save new admin
	 */
	public void saveAdmin(Admin admin) {
		
		try {
		String sql="INSERT INTO admin(name,password) VALUES (?,?)";
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,admin.getName());
		ps.setString(2,admin.getPassword());
		int res=ps.executeUpdate();
		System.out.println(res);
		ps.close();
		connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	/*
	 * @ author S.Sonu Patra
	 * This method is used to validate admin based on name and password
	 */
	public Admin validateAdmin(String name,String password) {
		Admin admin=null;
		try {			
		Connection connection=getConnection();
		String sql="SELECT * FROM admin where name=? and password=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2,password);
		ResultSet resultSet=ps.executeQuery();
		if(resultSet.next()) {
			admin=new Admin();
			admin.setId(resultSet.getLong(1));
			admin.setName(resultSet.getString(2));
			admin.setPassword(resultSet.getString(3));
			}
		ps.close();
		connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	@Override
	/*
	 * @ author S.Sonu Patra
	 * This method is used to add/save new teacher
	 */
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
		connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	/*
	 * @ author S.Sonu Patra
	 * This method is used to update teacher
	 */
	public void updateTeacher(Teacher teacher) {
		try {
			Connection connection=getConnection();			
			String sql="update teacher set name=?,phno=?,subject=?,sal=?,experience=?,qualification=?,email=?,classTeacher=?,address=?,password=? where id="+teacher.getId();
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
			connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	@Override
	/*
	 * @ author S.Sonu Patra
	 * This method is used to delete teacher data based on id
	 */
	public void deleteTeacher(Long id) {
		try {
			Connection connection=ConnectionUtil.getConnection();	
			String sql="delete from teacher where id="+id;
			Statement statement=connection.createStatement();
			int res=statement.executeUpdate(sql);
			System.out.println(res);
			statement.close();
			connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	@Override
	/*
	 * @ author S.Sonu Patra
	 * This method is used to view teacher data based on id
	 */
	public Teacher viewTeacherById(Long id) {
		Teacher teacher=new Teacher();
		try {
			Connection connection=ConnectionUtil.getConnection();	
			String sql="select * from student where id="+id;
			Statement statement=connection.createStatement();
			ResultSet res=statement.executeQuery(sql);
			while(res.next()) {
				teacher.setId(res.getLong("id"));
				teacher.setName(res.getString("name"));
				teacher.setPhno(res.getString("phno"));
				teacher.setSubject(res.getString("subject"));
				teacher.setSalary(res.getLong("sal"));
				teacher.setExperience(res.getDouble("experience"));
				teacher.setQualification(res.getString("qualification"));
				teacher.setEmail(res.getString("email"));
				teacher.setClassTeacher(res.getString("classTeacher"));
				teacher.setAddress(res.getString("address"));
				teacher.setPassword(res.getString("password"));
			}
			statement.close();
			connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return teacher;
	}
	
	@Override
	/*
	 * @ author S.Sonu Patra
	 * This method is used to view all teachers data
	 */
	public List<Teacher> viewAllTeacher() {
		List<Teacher> listTeacher=new ArrayList<>();
		try {
			Connection connection=getConnection();	
			String sql="select * from teacher";
			Statement statement=connection.createStatement();
			ResultSet res=statement.executeQuery(sql);
			while(res.next()) {
				Teacher teacher=new Teacher();
				teacher.setId(res.getLong("id"));
				teacher.setName(res.getString("name"));
				teacher.setPhno(res.getString("phno"));
				teacher.setSubject(res.getString("subject"));
				teacher.setSalary(res.getLong("sal"));
				teacher.setExperience(res.getDouble("experience"));
				teacher.setQualification(res.getString("qualification"));
				teacher.setEmail(res.getString("email"));
				teacher.setClassTeacher(res.getString("classTeacher"));
				teacher.setAddress(res.getString("address"));
				teacher.setPassword(res.getString("password"));
				listTeacher.add(teacher);
			}
			statement.close();
			connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
		return listTeacher;
	}
	
	@Override
	/*
	 * @ author S.Sonu Patra
	 * This method is used to add/save new student
	 */
	public void saveStudent(Student student) {
		Connection connection=ConnectionUtil.getConnection();
		
		String sql="INSERT INTO student(name,phno,address,email,grades,class,parentPhno,password) VALUES (?,?,?,?,?,?,?,?)";
		try {
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
		connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	/*
	 * @ author S.Sonu Patra
	 * This method is used to update student
	 */
	public void updateStudent(Student student) {
		try {
			Connection connection=ConnectionUtil.getConnection();	
			String sql="update student set name=?,phno=?,address=?,email=?,grades=?,standard=?,parentPhno=?,password=? where id="+student.getId();
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
			connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	@Override
	/*
	 * @ author S.Sonu Patra
	 * This method is used to delete student data based on id
	 */
	public void deleteStudent(Long id) {
		try {
			Connection connection=ConnectionUtil.getConnection();	
			String sql="delete from student where id="+id;
			Statement statement=connection.createStatement();
			int res=statement.executeUpdate(sql);
			System.out.println(res);
			statement.close();
			connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
	}
	@Override
	/*
	 * @ author S.Sonu Patra
	 * This method is used to view student data based on id
	 */
	public Student viewStudentById(Long id) {
		Student student=new Student();
		try {
			Connection connection=ConnectionUtil.getConnection();	
			String sql="select * from student where id="+id;
			Statement statement=connection.createStatement();
			ResultSet res=statement.executeQuery(sql);
			while(res.next()) {
				student.setId(res.getLong("id"));
				student.setName(res.getString("name"));
				student.setPhno(res.getString("phno"));
				student.setAddress(res.getString("address"));
				student.setEmail(res.getString("email"));
				student.setGrades(res.getString("grades"));
				student.setStandard(res.getString("class"));
				student.setParentPho(res.getString("parentPhno"));
				student.setPassword(res.getString("password"));
			}
			statement.close();
			connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return student;
	}
	
	
	@Override
	/*
	 * @ author S.Sonu Patra
	 * This method is used to view all students data
	 */
	public List<Student> viewAllStudent() {
		List<Student> listStudent=new ArrayList<>();
		try {
			Connection connection=ConnectionUtil.getConnection();	
			String sql="select * from student";
			Statement statement=connection.createStatement();
			ResultSet res=statement.executeQuery(sql);
			while(res.next()) {
				Student student=new Student();
				student.setId(res.getLong("id"));
				student.setName(res.getString("name"));
				student.setPhno(res.getString("phno"));
				student.setAddress(res.getString("address"));
				student.setEmail(res.getString("email"));
				student.setGrades(res.getString("grades"));
				student.setStandard(res.getString("class"));
				student.setParentPho(res.getString("parentPhno"));
				student.setPassword(res.getString("password"));
				listStudent.add(student);
			}
			statement.close();
			connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
		return listStudent;
	}
	
}
