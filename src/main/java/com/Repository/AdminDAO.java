package com.Repository;
import java.util.List;

import com.entity.Admin;
import com.entity.Student;
import com.entity.Teacher;

public interface AdminDAO {
	
	public void saveAdmin(Admin admin);
	public Admin validateAdmin(String name,String password);
	public void saveTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher);
	public void deleteTeacher(Long id);
	public Teacher viewTeacherById(Long id);
	public List<Teacher> viewAllTeacher();
	
	public void saveStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(Long id);
	public Student viewStudentById(Long id);
	public List<Student> viewAllStudent();
	
	
}
