package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardDao;
import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;

@Repository
public class BoardDaoImpl implements BoardDao {
	Connection conn = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	
	String BOARD_INSERT = "insert  into board (seq, title, writer, content)"
			           + " values((select max(seq)+1 from board),?,?,?)";
	
	String BOARD_SELECT = "select * from board  order  by  seq  desc";
	
	String BOARD_DELETE = "delete from board where seq ="
			            + " (select min(seq) from board)";
	String BOARD_SELECTSEQ = "select * from board where seq = ?"; 
	
	@Override
	public void insert(BoardVO vo) {		
		System.out.println("DAO.insert.Before...>>>>>>>>");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());			
			pstmt.executeUpdate();
			System.out.println("저장완료!!");
		} catch (SQLException e) {			
			System.out.println("저장실패!!");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<BoardVO> getBoardList() {
		System.out.println("DAO.List<BoardVO>.Before...>>>>>>>>");
		List<BoardVO> li = new ArrayList<>();
		System.out.println("getBoardList.DAO..AOP확인...>>>>>>>>");
		try {
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(BOARD_SELECT);		
		rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO	m = new BoardVO();
				m.setSeq(rs.getInt("seq"));
				m.setTitle(rs.getString("title"));
				m.setWriter(rs.getString("writer"));
				m.setContent(rs.getString("content"));
				m.setRegdate(rs.getDate("regDate"));
				m.setCnt(rs.getInt("cnt"));			
				li.add(m);
			} 
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return li;
	}

	@Override
	public void delete() {
		System.out.println("DAO.Delete.Before...>>>>>>>>");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.executeUpdate();
			System.out.println("삭제완료!!");
		} catch (SQLException e) {			
			System.out.println("삭제실패!!");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	}

	@Override
	public BoardVO getBoard(int seq) {
		System.out.println("DAO.getBoard.Before...>>>>>>>>");
		BoardVO m = new BoardVO();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_SELECTSEQ);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m.setSeq(rs.getInt("seq"));
				m.setTitle(rs.getString("title"));
				m.setWriter(rs.getString("writer"));
				m.setContent(rs.getString("content"));
				m.setRegdate(rs.getDate("regDate"));
				m.setCnt(rs.getInt("cnt"));			
			} 
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return m;
	}
}