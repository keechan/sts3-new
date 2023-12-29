package com.springbook.com.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insert(MemberVO vo) {
		System.out.println("=====> MemberDaoImpl insert");
		mybatis.insert("MemberDao.INSERT", vo);
	}

	@Override
	public void update(MemberVO vo) {
		mybatis.update("MemberDao.UPDATE", vo);		
	}

	@Override
	public void delete(MemberVO vo) {
		mybatis.delete("MemberDao.DELETE", vo);		
	}

	@Override
	public MemberVO getSelectOne(MemberVO vo) {
		return mybatis.selectOne("MemberDao.SELECTONE", vo);
	}

	@Override
	public List<MemberDao> getSelectAll(MemberVO vo) {
		return mybatis.selectList("MemberDao.SELECTALL", vo);
	}

	@Override
	public MemberVO getLoginOne(MemberVO vo) {
		return mybatis.selectOne("MemberDao.LOGIN", vo);
	}
}
