package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.com.board.BoardVO;
import com.springbook.com.exam.ExamService;
import com.springbook.com.exam.ExamVO;

/**
 * Servlet implementation class ExamController
 */
@Controller
public class ExamController {

	@Autowired
	ExamService service;
	
	ExamController() {
		System.out.println("====> ExamController 생성자 확인 ");
    }

	@RequestMapping(value="examList.do")
	public String examGetBoard(Model model, String ch1, String ch2) {
		System.out.println("====> examGetBoardList.do 확인");
		ExamVO vo  = new ExamVO();
		vo.setCh1(ch1);
		vo.setCh2(ch2);
		System.out.println("=======>ch1 : " + ch1);
		System.out.println("=======>ch2 : " + ch2);
		model.addAttribute("li", service.getExamList(vo));
		
		return "/exam/exam_list.jsp";
	}
	
	@RequestMapping(value="examInsert.do", method=RequestMethod.GET)
	public String examInsert() {
		System.out.println("====> examInsert.do GET 확인");
		
		//model.addAttribute("li",service.getBoardList(null, null));
		return "/exam/exam_insert.jsp";
	}
	
	@RequestMapping(value="examInsert.do", method=RequestMethod.POST)
	public String examInsert(ExamVO vo) {
		System.out.println("====> examInsert.do POST 확인");
		//값변경시 setter해도 됨
		System.out.println("----> vo " + vo);
		service.examInsert(vo);
		//model.addAttribute("li",service.getBoardList(null, null));
		return "examList.do";
	}

}
