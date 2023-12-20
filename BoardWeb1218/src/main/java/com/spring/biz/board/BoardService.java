package com.spring.biz.board;

import java.util.List;

public interface BoardService {
	public void insert(BoardVO vo);
	public void update(BoardVO vo);
	public List<BoardVO> getBoardList();
	public void delete();
	public void delete(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
}