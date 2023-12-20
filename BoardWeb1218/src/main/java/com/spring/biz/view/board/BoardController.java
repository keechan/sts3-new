package com.spring.biz.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardServiceImpl;

@Controller
public class BoardController {

	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardServiceImpl service) throws Exception {
	   service.delete(vo);
	   return "getBoardList.do";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardServiceImpl service) throws Exception {
		service.insert(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardServiceImpl service) throws Exception {
	    service.update(vo);
	    return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardServiceImpl service, ModelAndView mav ) throws Exception {
		System.out.println("==> getBoard.do");
		mav.setViewName("getBoard");
		mav.addObject("m", service.getBoard(vo));
		return mav;
	}
	
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardServiceImpl service, ModelAndView mav) throws Exception {
		System.out.println("GetBoardListController....>");
		mav.setViewName("getBoardList");
		mav.addObject("li", service.getBoardList());
		return mav;
	}
}
