package com.springbook.com.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoMybatis implements BoardDao {

	@Autowired
	private SqlSessionTemplate mybatis; 
	
	@Override
	public List<BoardVO> getBoardList(String ch1, String ch2) {
		System.out.println("===> Mybatis(Select)");
		BoardVO vo = new BoardVO();
		vo.setCh1(ch1);
		vo.setCh2(ch2);
		System.out.println("====>ch1 " + ch1);
		System.out.println("====>ch2 " + ch2);
		
		/*if (ch2.equals("")) {
			System.out.println("====>BoardDao.Board_SELECT list");
			return mybatis.selectList("BoardDao.Board_SELECT");
		} else if (ch1.equals("title")) {
			System.out.println("====>BoardDao.Board_SELECT title");
			return mybatis.selectList("BoardDao.Board_SELECTTITLE", vo);
		} else if (ch1.equals("writer")) {
			System.out.println("====>BoardDao.Board_SELECT writer");
			return mybatis.selectList("BoardDao.Board_SELECTWRITER", vo);
		}*/
		return mybatis.selectList("BoardDao.Board_SELECT_CH", vo);
	}

	@Override
	public void boardInsert(BoardVO vo) {
		System.out.println("===> Mybatis(Insert)");
		mybatis.insert("BoardDao.Board_INSERT", vo);
	}

	@Override
	public BoardVO boardEdit(BoardVO vo) {
		System.out.println("===> Mybatis(Edit)");
		return mybatis.selectOne("BoardDao.Board_EDIT", vo);
	}

	@Override
	public void boardDelete(BoardVO vo) {
		System.out.println("===> Mybatis(Delete)");
		mybatis.delete("BoardDao.Board_DELETE", vo);		
	}

	@Override
	public void boardRowCnt(BoardVO vo) {
		System.out.println("===> Mybatis(RowCnt)");
		mybatis.update("BoardDao.Board_ROWCNT", vo);
	}

	@Override
	public void boardUpdate(BoardVO vo) {
		System.out.println("===> Mybatis(Update)");
		int updatecnt = mybatis.update("BoardDao.Board_UPDATE", vo);
		System.out.println(Integer.toString(updatecnt) + "건 업데이트되었습니다.");
	}

}
