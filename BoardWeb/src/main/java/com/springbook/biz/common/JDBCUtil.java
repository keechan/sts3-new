package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static Connection getConnection() {
//H2 DB 설정
//		Connection conn = DriverManager.getConnection
//		 ("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
//		String url="jdbc:h2:tcp://localhost/./test";
//		String id="sa";
//		String pwd="1234";
		
		String url="jdbc:oracle:thin:@//localhost:1521/xe";
		String id="system";
		String pwd="1234";

		try {
			//Class.forName("org.h2.Driver");
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(url, id, pwd);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) {
			try {
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		
		if(pstmt != null) {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		
		if(conn != null) {
			try {
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}		
		
	}
	public static void close(PreparedStatement pstmt, Connection conn) {
		if(pstmt != null) {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		
		if(conn != null) {
			try {
				if(conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}		
		
	}	
}
