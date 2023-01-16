package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static Connection connection=null;
	private ConnectionUtil() {
		
	}
	public static Connection getConnection() {
		if(connection==null) {
			try {
				Class.forName(AppConstants.DRIVER_NAME);
				FileInputStream fileInputStream=new FileInputStream(AppConstants.DB_INFO);
				Properties properties=new Properties();
				properties.load(fileInputStream);
				connection=DriverManager.getConnection(AppConstants.URL,properties);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
