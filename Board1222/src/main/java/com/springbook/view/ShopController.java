package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.com.shop.BuyVO;
import com.springbook.com.shop.ProductService;
import com.springbook.com.shop.ProductVO;

@SessionAttributes("m")
@Controller
public class ShopController {
//	@Autowired
//	private ServletContext  servletContext;
	
	@Autowired
	private ProductService service;
	
	//String path ="";
	String timeStr ="";
	// @PostConstruct 은 init() 메소드는 WAS 가 띄워질때 실행된다.
//	@PostConstruct
//	public  void init() {
//	  path = servletContext.getRealPath("/shop/img/");
//	}
	
	@RequestMapping(value="Shopbuy.do")
	public  String Shopbuy(BuyVO  vo1, ProductVO vo2) {
		System.out.println("=====> 구매물건 확인");
		ProductVO m1 = service.getProductOne(vo2);
		vo1.setProduct_name(m1.getProduct_name());
		service.shopBuyInsert(vo1);
		
		return "productList.do";
	}
}
