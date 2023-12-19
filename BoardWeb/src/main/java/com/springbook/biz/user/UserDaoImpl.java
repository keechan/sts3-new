package com.springbook.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.springbook.biz.common.JDBCUtil;

public class UserDaoImpl implements UserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String USER_SELECT = "select * from users where id=? and password=? ";

	@Override
	public UserVO getUser(UserVO vo) {
		UserVO m = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_SELECT);
			pstmt.setString(1, vo.getId());
			System.out.println("UserDaoImpl.............>" + vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m = new UserVO();
				m.setId(rs.getString("id"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,  pstmt, conn);
		}
		return m;
	}	
}
