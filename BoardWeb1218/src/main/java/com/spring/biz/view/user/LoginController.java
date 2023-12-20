package com.spring.biz.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserDaoImpl;
import com.spring.biz.user.UserVO;

@Controller
public class LoginController {
	@RequestMapping(value="/login.do")
	public String login(UserVO vo, UserDaoImpl userDao) throws Exception {
		System.out.println("==>login.do");
		
		System.out.println("ID===>"+vo.getId());
		System.out.println("PASSWORD===>"+vo.getId());
		UserVO user = userDao.getUser(vo);
		if (user != null) {
			System.out.println("getBoardList.do.........>");
			return "getBoardList.do";
		} else {
			System.out.println("login.jsp..........>");
			return "login.jsp";
		}
	}
}