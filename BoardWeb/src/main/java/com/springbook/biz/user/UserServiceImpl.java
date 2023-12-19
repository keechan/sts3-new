package com.springbook.biz.user;

public class UserServiceImpl implements UserService {

	private UserDao dao;
	
//	public void setDao(UserDao dao) {
//		this.dao = dao;
//	}

	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}
//
//	public UserServiceImpl(UserDao dao) {
//		this.dao = dao;
//	}

	public UserServiceImpl(UserDao dao) {
		super();
		this.dao = dao;
	}
}