package com.springbook.com.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardVO> getBoardList(String ch1, String ch2) {
		return dao.getBoardList(ch1, ch2);
	}

	@Override
	public void boardInsert(BoardVO vo) {
		dao.boardInsert(vo);		
	}

	@Override
	public BoardVO boardEdit(BoardVO vo) {
		dao.boardRowCnt(vo);
		return dao.boardEdit(vo);
	}

	@Override
	public void boardDelete(BoardVO vo) {
		dao.boardDelete(vo);
	}

	@Override
	public void boardRowCnt(BoardVO vo) {
		dao.boardRowCnt(vo);
	}

	@Override
	public void boardUpdate(BoardVO vo) {
		dao.boardUpdate(vo);
	}
}
