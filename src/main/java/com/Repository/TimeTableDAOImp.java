package com.Repository;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.entity.TimeTable;
import com.util.ConnectionUtil;

public class TimeTableDAOImp {
	public void saveTimeTable(TimeTable timetable) {
		Connection connection=ConnectionUtil.getConnection();
		
		String sql="INSERT INTO time_table(subject,day,teacher,standard,period) VALUES (?,?,?,?,?)";
		try {
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,timetable.getSubject());
		ps.setString(2,timetable.getDay());
		ps.setString(3,timetable.getTeacher());
		ps.setString(4,timetable.getStandard());
		ps.setString(5,timetable.getPeriod());
		int res=ps.executeUpdate();
		System.out.println(res);
		ps.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		TimeTable timetable=new TimeTable();
//		timetable.setSubject("Science");
//		timetable.setDay("Monday");
//		timetable.setTeacher("Divya");
//		timetable.setStandard("2");
//		timetable.setPeriod("3rd");
//		TimeTableDAOImp dao3=new TimeTableDAOImp();
//		dao3.saveTimeTable(timetable);
//	}
}
