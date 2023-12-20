package com.spring.biz.user;

public class UserServiceImpl implements UserService {
	private UserDao dao;
	
	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}
}