package com.springbook.biz.board.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container 
			= new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");
		BoardVO vo = new BoardVO();
		//vo.setSeq(207);
		vo.setTitle("지리산 방문7");
		vo.setWriter("둘리7");
		vo.setContent("7지리산 종주 합니다!");
		boardService.insert(vo);
		
		//delete
		BoardVO r = new BoardVO();
		int rowcnt = boardService.getCount(null);
		System.out.println("Client......." + rowcnt);
		System.out.println(rowcnt);
		if(rowcnt > 9) {
			r.setRowcnt(rowcnt);
			System.out.println("Delete BoardVO(By rowCnt) ====> " + rowcnt);
		} else {
			r.setSeq(12);
			System.out.println("Delete BoardVO(By Seq) ====> ");
		}
		boardService.delete(r);
		
		//select
		List<BoardVO> li = (List<BoardVO>) boardService.getBoardList();
		for (BoardVO m : li) {
			System.out.println("List BoardVO >>>>> " + m);
		}
		
		container.close();
	}
}