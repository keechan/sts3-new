package com.spring.biz.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

public class BoardServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container 
			= new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("BoardService");
		BoardVO vo = new BoardVO();
		vo.setSeq(207);
		vo.setTitle("지리산 방문8");
		vo.setWriter("둘리8");
		vo.setContent("8한라산 종주 합니다!");
		boardService.insert(vo);

		// select
		List<BoardVO> li = (List<BoardVO>) boardService.getBoardList();
		for (BoardVO m : li) {
			System.out.println("List BoardVO >>>>> " + m);
		}

		// select by seq		
		BoardVO vv = (BoardVO) boardService.getBoard(10);
		System.out.println("BoardVO >>>>> vv  " + vv);
		
		
		container.close();
	}
}
