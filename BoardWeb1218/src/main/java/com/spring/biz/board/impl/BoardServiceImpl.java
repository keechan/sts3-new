package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardDao;
import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOSpring boardDAO;
	//private BoardDao dao;

	
	@Override
	public void insert(BoardVO vo) {
		System.out.println("ServiceImpl insert before..........");
		boardDAO.insert(vo);	
		//boardDAO.insert(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		System.out.println("ServiceImpl getBoardList before..........");
		return boardDAO.getBoardList();
	}

	@Override
	public void delete(BoardVO vo) {
		System.out.println("ServiceImpl delete before..........");
		boardDAO.delete();
	}

	@Override
	public BoardVO getBoard(int seq) {		
		System.out.println("getBoard ServiceImpl before..........");
		return boardDAO.getBoard(seq);
	}
}
