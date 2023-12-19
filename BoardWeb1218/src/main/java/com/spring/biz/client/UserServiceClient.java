package com.spring.biz.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

public class UserServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) container.getBean("userService");
		UserVO vo = new UserVO();
		vo.setId("aaa");
		vo.setPassword("bbb");
		System.out.println("Client(vo) -------> "+vo);
		// boardService.insert(vo);
		UserVO user = userService.getUser(vo);
		System.out.println("Client(user) -------> "+user);		
		if (user != null) {
			System.out.println(user);
			System.out.println(user.getName() + "님 환영합니다.!");
		} else {
			System.out.println("아이디와 비밀번호를 확인하세요!");
		}
		container.close();
	}
}
