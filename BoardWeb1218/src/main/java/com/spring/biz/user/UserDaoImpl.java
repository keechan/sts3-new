package com.spring.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	String USER_SELECT = "select * from users where id=? and password=? ";

	@Override
	public UserVO getUser(UserVO vo) {
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_SELECT, new UserRowMapper(), args);
	}
}
