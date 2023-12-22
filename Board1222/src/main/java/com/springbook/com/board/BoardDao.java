package com.springbook.com.board;

import java.util.List;

public interface BoardDao {
	List<BoardVO> getBoardList(String ch1, String ch2);
	void boardInsert(BoardVO vo);
	BoardVO boardEdit(BoardVO vo);
	void boardDelete(BoardVO vo);
	void boardRowCnt(BoardVO vo);
	void boardUpdate(BoardVO vo);
}
