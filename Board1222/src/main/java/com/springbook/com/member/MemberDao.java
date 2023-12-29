package com.springbook.com.member;

import java.util.List;

public interface MemberDao {
	void insert(MemberVO vo);
	void update(MemberVO vo);
	void delete(MemberVO vo);
	MemberVO getSelectOne(MemberVO vo);
	List<MemberDao> getSelectAll(MemberVO vo);
    MemberVO getLoginOne(MemberVO vo);	
}