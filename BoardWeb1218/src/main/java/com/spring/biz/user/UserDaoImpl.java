package com.spring.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.spring.biz.common.JDBCUtil;

public class UserDaoImpl implements UserDao {
	
	String USER_SELECT = "select * from users where id=? and password=? ";
	Connection conn = null;
	PreparedStatement pstmt = null;
    ResultSet rs = null;
	public UserVO getUser(UserVO vo) {
		UserVO m = new UserVO();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_SELECT);
			pstmt.setString(1,  vo.getId());
			pstmt.setString(2,  vo.getPassword());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
}
