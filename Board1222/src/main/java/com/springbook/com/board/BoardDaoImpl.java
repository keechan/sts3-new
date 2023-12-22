package com.springbook.com.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {
	String Board_SELECT   = "select * from board order by seq desc";
	String Board_SELECTTITLE = "select * from board where title LIKE ?";
	String Board_SELECTWRITER = "select * from board where writer LIKE ?";
	String Board_INSERT = "insert into board (seq, title, writer, content) values"
			            + "                  ((select max(seq)+1 from board), ?, ?, ?) ";
	String Board_EDIT   = "select * from board where seq = ? ";
	String Board_DELETE = "delete from board where seq = ? ";
	String Board_ROWCNT = "update board set cnt = nvl(cnt, 0) + 1 where seq = ? ";
	String Board_UPDATE = "update board set title = ?, writer = ?, content = ? where seq = ? ";

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public List<BoardVO> getBoardList(String ch1, String ch2) {
		System.out.println("=====> ch1 : " + ch1);
		System.out.println("=====> ch2 : " + ch2);
		if (ch2.equals("")) {
			return jdbcTemplate.query(Board_SELECT, new BoardRowMapper());
		} else {
			System.out.println("======> ch1" + ch1);
			System.out.println("======> ch2" + ch2);
			if (ch1.equals("title")) {
				Object[] args1 = {"%" + ch2 + "%"};
				return jdbcTemplate.query(Board_SELECTTITLE, new BoardRowMapper(), args1);
			} else if (ch1.equals("writer")) {
				Object[] args2 = {"%" + ch2 + "%"};				
				return jdbcTemplate.query(Board_SELECTWRITER, new BoardRowMapper(), args2);
			}
		}		
		return null;
	}

	@Override
	public void boardInsert(BoardVO vo) {
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(Board_INSERT, args);
	}

	@Override
	public BoardVO boardEdit(BoardVO vo) {
		Object [] args = {vo.getSeq()};
		//queryForObject 레크드 1개 가져오기
		
		return jdbcTemplate.queryForObject(Board_EDIT, new BoardRowMapper(), args);
	}

	@Override
	public void boardDelete(BoardVO vo) {
		Object [] args = {vo.getSeq()};
		//queryForObject 레크드 1개 가져오기
		jdbcTemplate.update(Board_DELETE, args);		
	}

	@Override
	public void boardRowCnt(BoardVO vo) {
		Object [] args = {vo.getSeq()};
		//queryForObject 레크드 1개 가져오기
		jdbcTemplate.update(Board_ROWCNT, args);		
	}
	
	@Override
	public void boardUpdate(BoardVO vo) {
		Object [] args = {vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getSeq()};
		//queryForObject 레크드 1개 가져오기
		jdbcTemplate.update(Board_UPDATE, args);		
	}
}