package com.springbook.com.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao dao;

	@Override
	public void insert(MemberVO vo) {
		System.out.println("=====> MemberServiceImpl insert");
		dao.insert(vo);
	}

	@Override
	public void update(MemberVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(MemberVO vo) {
		dao.delete(vo);
	}

	@Override
	public MemberVO getSelectOne(MemberVO vo) {
		return dao.getSelectOne(vo);
	}

	@Override
	public List<MemberDao> getSelectAll(MemberVO vo) {
		return dao.getSelectAll(vo);
	}

	@Override
	public MemberVO getLoginOne(MemberVO vo) {
		return dao.getLoginOne(vo);
	}
}