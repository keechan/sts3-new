package com.spring.biz.board.impl;

import java.util.List;

import com.spring.biz.board.BoardDao;
import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

//@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	//@Autowired
	//private BoardDAOSpring boardDAO;
	private BoardDao dao;
	
	public BoardServiceImpl() {
		dao = new BoardDaoImpl();
		System.out.println("ServiceImpl 생성자..........");
	}
	
	@Override
	public void insert(BoardVO vo) {
		System.out.println("ServiceImpl insert before..........");
		//boardDAO.insert(vo);	
		dao.insert(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		System.out.println("ServiceImpl getBoardList before..........");
		//return boardDAO.getBoardList();
		return dao.getBoardList();
	}

	@Override
	public void delete() {
		System.out.println("ServiceImpl delete before..........");
		//boardDAO.delete();
		dao.delete();
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {		
		System.out.println("getBoard ServiceImpl before..........");
		//return boardDAO.getBoard(seq);
		return dao.getBoard(vo);
	}

	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);		
	}
}
