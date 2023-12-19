package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardDao;
import com.spring.biz.board.BoardVO;

@Repository
public class BoardDAOSpring implements BoardDao {

	public BoardDAOSpring() {
		System.out.println("===> BoardDAOSpring 객체생성 ");
	}
	/*
	String BOARD_INSERT ="insert  into board (seq, title, writer, content)"
		              	+ " values((select max(seq)+1 from board),?,?,?)";
	*/
	
	
	String BOARD_INSERT ="insert  into board (seq, title, writer, content)"
			+ " values(?,?,?,?)";
	
	String BOARD_SELECT ="select * from board  order  by  seq  desc";

	String BOARD_EDIT ="select * from board  where seq=?";
	
	String BOARD_DELETE ="delete from board where seq ="
			           + " (select min(seq) from board)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(BoardVO vo) {
		Object[] args = { vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent() };
		jdbcTemplate.update(BOARD_INSERT, args);
		
	}

	@Override
	public void delete() {
		jdbcTemplate.update(BOARD_DELETE);
		
	}

	@Override
	public List<BoardVO> getBoardList() {
		return jdbcTemplate.query(BOARD_SELECT, new BoardRowMapper());
	}

	@Override
	public BoardVO getBoard(int seq) {
		Object [] args = { seq };
		
		return jdbcTemplate.queryForObject(BOARD_EDIT, new BoardRowMapper(), args);
	}
}
