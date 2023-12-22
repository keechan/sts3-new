package com.springbook.view;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.com.board.BoardService;
import com.springbook.com.board.BoardVO;

@Controller
@SessionAttributes("m")
public class BoardController {
	@Autowired
	BoardService service;
	
	BoardController() {
		System.out.println("====> BoardController 생성자 확인 ");
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> ch1() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	@RequestMapping(value="boardGetBoardList.do")
	public String boardGetBoard(Model model, @RequestParam(value="ch1", defaultValue="TITLE", required=false) String ch1,
			                                 @RequestParam(value="ch2", defaultValue="", required=false) String ch2) {
		System.out.println("====> boardGetBoardList.do 확인");
		model.addAttribute("li", service.getBoardList(ch1, ch2));
		
		return "/board/board_list.jsp";
	}
	
	@RequestMapping(value="boardWrite.do", method=RequestMethod.GET)
	public String boardWrite() {
		System.out.println("====> boardGetBoardList.do 확인");
		
		//model.addAttribute("li",service.getBoardList(null, null));
		return "/board/board_write.jsp";
	}
	
	@RequestMapping(value="boardWrite.do", method=RequestMethod.POST)
	public String boardWrite(BoardVO vo) {
		System.out.println("====> boardGetBoardList.do 확인");
		//값변경시 setter해도 됨
		service.boardInsert(vo);
		//model.addAttribute("li",service.getBoardList(null, null));
		return "boardGetBoardList.do";
	}

	@RequestMapping(value="boardEdit.do")
	public String boardEdit(Model model, BoardVO vo) {
		System.out.println("====> boardEdit.do 확인");
		
		model.addAttribute("m", service.boardEdit(vo));
		return "/board/board_edit.jsp";
	}
	
	@RequestMapping(value="boardDelete.do")
	public String boardDelete(BoardVO vo) {
		System.out.println("====> boardDelete.do 확인");
		service.boardDelete(vo);
		return "boardGetBoardList.do";
	}
	
	@RequestMapping(value="updateBoard.do", method=RequestMethod.GET)
	public String updateBoard(@ModelAttribute("m") BoardVO vo) {
		System.out.println("====> updateBoard.do VO: " + vo);
		service.boardUpdate(vo);
		return "boardGetBoardList.do";
	}	
}