package com.springbook.view;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.com.member.BCrypt;
import com.springbook.com.member.MemberService;
import com.springbook.com.member.MemberVO;

@Controller
@SessionAttributes("m")
public class MemberController {

	@Autowired
	MemberService service;
	
	MemberController() {
		System.out.println("====> MemberController 생성자 확인 ");
	}
	
//	@ModelAttribute("conditionMap")
//	public Map<String, String> ch1() {
//		Map<String, String> conditionMap = new HashMap<String, String>();
//		conditionMap.put("제목", "TITLE");
//		conditionMap.put("내용", "CONTENT");
//		return conditionMap;
//	}

	@RequestMapping(value="memberList.do")
	public String boardGetBoard(Model model) {
		System.out.println("====> memberList.do 확인");
		//MemberVO vo = new MemberVO();
		model.addAttribute("li", service.getSelectAll(null));
		
		return "/member/member_list.jsp";
	}
	
	@RequestMapping(value="memberLogin.do", method=RequestMethod.GET)
	public String memberLogin() {
		System.out.println("====> memberLogin.do GET 확인");
		
		//model.addAttribute("li",service.getBoardList(null, null));
		return "/member/member_login.jsp";
	}

	@RequestMapping(value="memberLogin.do", method=RequestMethod.POST)
	public String memberLogin(MemberVO vo, HttpSession session) {		
		System.out.println("====> memberLogin.do POST 확인");
		//값변경시 setter해도 됨
		//String Bpwd = BCrypt.hashpw(vo.getPwd(), BCrypt.gensalt());
		//vo.setPwd(Bpwd);
		
		MemberVO m = service.getLoginOne(vo);
		if (m != null) {
			System.out.println("===> m is not null..");
			Boolean b = BCrypt.checkpw(vo.getPwd(), m.getPwd());
			if (b) {
				System.out.println("===> member_success");
				session.setAttribute("sessionMemberId", vo.getMemberid());
				session.setAttribute("sessionName", vo.getName());
				session.setAttribute("sessionPwd", vo.getPwd());
				return "/member/member_success.jsp";
			} else {
				System.out.println("===> member_list1");
				return "";
			}
		} else {
			System.out.println("===> member_list2");
			return "/member/member_list.jsp";
		}
	}
	@RequestMapping(value="memberLogout.do")
	public String memberLogout(HttpSession session) {
		session.invalidate(); //세션의 모든 속성 제거
		return "/member/member_login.jsp";
	}
	@RequestMapping(value="memberForm.do", method=RequestMethod.GET)
	public String memberWrite() {
		System.out.println("====> memberForm.do GET 확인");
		
		//model.addAttribute("li",service.getBoardList(null, null));
		return "/member/member_write.jsp";
	}

	@RequestMapping(value="memberForm.do", method=RequestMethod.POST)
	public String memberWrite(MemberVO vo) {		
		System.out.println("====> memberForm.do POST 확인");
		//값변경시 setter해도 됨
		String Bpwd = BCrypt.hashpw(vo.getPwd(), BCrypt.gensalt());
		vo.setPwd(Bpwd);
		//String address = vo.getSample6_postcode() ;
		//private String vo.getSample6_address();
		//private String sample6_detailAddress;
		//private String sample6_extraAddress;
		vo.setAddress(vo.getSample6_address());
		service.insert(vo);
		//model.addAttribute("li",service.getBoardList(null, null));
		return "memberList.do";
	}
//
//	@RequestMapping(value="boardEdit.do")
//	public String boardEdit(Model model, BoardVO vo) {
//		System.out.println("====> boardEdit.do 확인");
//		
//		model.addAttribute("m", service.boardEdit(vo));
//		return "/board/board_edit.jsp";
//	}
//	
//	@RequestMapping(value="boardDelete.do")
//	public String boardDelete(BoardVO vo) {
//		System.out.println("====> boardDelete.do 확인");
//		service.boardDelete(vo);
//		return "boardGetBoardList.do";
//	}
//	
//	@RequestMapping(value="updateBoard.do", method=RequestMethod.GET)
//	public String updateBoard(@ModelAttribute("m") BoardVO vo) {
//		System.out.println("====> updateBoard.do VO: " + vo);
//		service.boardUpdate(vo);
//		return "boardGetBoardList.do";
//	}
}
