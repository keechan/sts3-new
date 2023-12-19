package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

public class BoardDaoImpl implements BoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String BOARD_INSERT 
	   = "insert into board (seq, title, writer, content) "
	   + "values ((select max(seq)+1 from board), ?, ?, ?) ";
	String BOARD_SELECT
	   = "select seq, title, writer, content, regdate, cnt from board ";
	String BOARD_DELETE
	   = "delete from board where seq = ? ";
	String BOARD_DELETECNT
	   = "delete from board where seq in ( "
	   + "select seq from board "
	   + "minus "
	   + "select seq from board where rownum < 10) ";
	String BOARD_ROWCNT
	   = "select count(*) rowcnt from board ";
	
	@Override
	public void insert(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			//pstmt.setInt(1, vo.getSeq());
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> li = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_SELECT);
			rs = pstmt.executeQuery();
			BoardVO vo = null;			
			while (rs.next()) {
				vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getDate("regDate"));
				vo.setCnt(rs.getInt("cnt"));
				li.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,  pstmt, conn);
		}
				
		return li;
	}

	@Override
	public void delete(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			if(vo.getRowcnt() > 9) {
				pstmt = conn.prepareStatement(BOARD_DELETECNT);
			} else {
				pstmt = conn.prepareStatement(BOARD_DELETE);
				pstmt.setInt(1, vo.getSeq());
			}
//			pstmt.setString(1, vo.getTitle());
//			pstmt.setString(2, vo.getWriter());
//			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	@Override
	public int getCount(BoardVO vo) {
		int rowcnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_ROWCNT);
//			pstmt.setInt(1, vo.getSeq());
//			pstmt.setString(1, vo.getTitle());
//			pstmt.setString(2, vo.getWriter());
//			pstmt.setString(3, vo.getContent());
			rs = pstmt.executeQuery();
			System.out.println("1111");
			if(rs.next()) {
				System.out.println("2222");
				rowcnt = rs.getInt("rowcnt");
				System.out.println("DaoImpl......." + rowcnt);
			} else {
				rowcnt = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return rowcnt;
	}
}
