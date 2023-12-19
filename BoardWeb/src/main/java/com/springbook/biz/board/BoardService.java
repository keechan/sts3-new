package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	public void insert(BoardVO vo);
	public List<BoardVO> getBoardList();
	public void delete(BoardVO vo);
	public int getCount(BoardVO vo);
}
