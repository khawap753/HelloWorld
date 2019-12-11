package com.myweb.util;

import java.sql.*;

public class JdbcUtil {
	
	// 닫는 작업을 메서드로 분리
	public static void close(Connection conn, Statement pstmt, ResultSet rs) {
		
		try {
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
