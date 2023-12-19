package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceImpl implements BoardService{

	private BoardDao dao;

	//생성자
	public BoardServiceImpl(BoardDao dao) {
		this.dao = dao;
	}

	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);		
	}

	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);
	}

	@Override
	public int getCount(BoardVO vo) {
		System.out.println("ServiceImpl.......");
		return dao.getCount(vo);
	}
}
