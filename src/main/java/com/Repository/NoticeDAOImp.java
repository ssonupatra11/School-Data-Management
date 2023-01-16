package com.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.entity.Notice;
import com.util.ConnectionUtil;

public class NoticeDAOImp implements NoticeDAO {
	
	public void saveNotice(Notice notice) {
		Connection connection=ConnectionUtil.getConnection();
		
		String sql="INSERT INTO notice(subject,message,producedBy,rsvp) VALUES (?,?,?,?)";
		try {
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setString(1,notice.getSubject());
		ps.setString(2,notice.getMessage());
		ps.setString(3,notice.getProducedBy());
		ps.setString(4,notice.getRsvp());
		int res=ps.executeUpdate();
		System.out.println(res);
		ps.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		Notice notice=new Notice();
//		notice.setSubject("Mock Test");
//		notice.setMessage("Dear, students it is to inform you that on moday there will be java mock at 10:00.");
//		notice.setProducedBy("HR");
//		notice.setRsvp("Jspider,Marathali");
//		NoticeDAOImp dao2=new NoticeDAOImp();
//		dao2.saveNotice(notice);
//	}
}
