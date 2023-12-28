package com.springbook.view;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.com.shop.ProductService;
import com.springbook.com.shop.ProductVO;

@SessionAttributes("m")
@Controller
public class ProductController {

	@Autowired
	private ServletContext  servletContext;
	
	@Autowired
	private ProductService service;
	
	String path ="";
	String timeStr ="";
	// @PostConstruct 은 init() 메소드는 WAS 가 띄워질때 실행된다.
	@PostConstruct
	public  void init() {
	  path = servletContext.getRealPath("/shop/img/");
	  
	}
	
	@RequestMapping(value="productInsertOK.do")
	public  String productInsertOK(ProductVO  vo) throws IOException {
	
//		// D:\eclipse-workspace-sts3\.metadata\.plugins\org.eclipse.wst.server.core
//		//          \tmp0\wtpwebapps\SpringProject1222\psd\img\
//		
		System.out.println(" ====> path:"+ path);
		
		long time = System.currentTimeMillis();
		SimpleDateFormat daytime= new SimpleDateFormat("HHmmss");
		timeStr = daytime.format(time);
		// 시분초 : 120035
		System.out.println("timeStr:"+ timeStr);
		
		MultipartFile uploadFile = vo.getProduct_img();
		
		String fileName = uploadFile.getOriginalFilename();
		File f = new File(path+fileName);
		System.out.println("====> Controller Path : " + path+fileName);
		if (!uploadFile.isEmpty()) {
		 if (f.exists()) {
			String onlyFileName = fileName.substring(0,fileName.lastIndexOf("."));
			String extension = fileName.substring(fileName.lastIndexOf("."));
			fileName = onlyFileName + "_" + timeStr + extension;
		 }
		 uploadFile.transferTo(new File(path + fileName));
		}else {
			fileName ="space.png";
		}		
		vo.setProduct_imgStr(fileName);
		System.out.println("=====>Controller :" + vo);
		service.productInsert(vo);
		
		return "productList.do";		
	}

	@RequestMapping(value="productInsert.do")
	public  String productInsert() {
		return "/shop/product_insert.jsp";
	}
	
	@RequestMapping(value="productDelete.do")
	public  String productDelete(ProductVO  vo, Model model) {
		
	    File delF = new File(path + vo.getProduct_imgStr());	    
	    if (!vo.getProduct_imgStr().equals("space.png")) {
	    	delF.delete();  //  실제파일 삭제
	    }
	    System.out.println("=====> Controller -> productDelete.do" + vo);
		service.productDelete(vo);
		
		return "productList.do";		
	}
	
	
	@RequestMapping(value="productList.do")
	public  String psdList(ProductVO  vo, Model  model) {
		System.out.println("=====> productList.do : " + vo);
		System.out.println("=====> ch1 :" + vo.getCh1());		
		vo.setCh2("%"+vo.getCh2()+"%");
		System.out.println("=====> ch2 :" + vo.getCh2());
		model.addAttribute("li", service.getProductSelect(vo) );
		System.out.println("=====> Controller productList.do");
		
		return "/shop/product_list.jsp";
	}
	
	@RequestMapping(value="productEdit.do")
	public  String productEdit(ProductVO  vo, Model  model) {
//		service.cnt(vo);
		System.out.println("===> Controller productEdit.do");
//		
		model.addAttribute("m", service.getProductOne(vo) );
		
		return "/shop/product_edit.jsp";
	}
	
	@RequestMapping(value="productUpdateOK.do")
	public  String productUpdateOK(@ModelAttribute("m") ProductVO  vo, Model  model) 
			throws Exception {
	   System.out.println(" ====> path:"+ path);
	   
	   long time = System.currentTimeMillis();
	   SimpleDateFormat daytime= new SimpleDateFormat("HHmmss");
	   timeStr = daytime.format(time);

		MultipartFile uploadFile = vo.getProduct_img();
		String fileName = uploadFile.getOriginalFilename();
		File f = new File(path+fileName);
		
		if (!uploadFile.isEmpty()) {
			// 첨부파일이 있으면 ...    
	           // vo.getUploadFileStr(); 기존파일명
			  if (!vo.getProduct_imgStr().equals("space.png")) {
		         File delF = new File(path + vo.getProduct_imgStr());
		         delF.delete();
			  }
			  
			  if (f.exists()) {
				String onlyFileName = fileName.substring(0,fileName.lastIndexOf("."));
				String extension = fileName.substring(fileName.lastIndexOf("."));
				fileName = onlyFileName + "_" + timeStr + extension;
			  }
		 uploadFile.transferTo(new File(path + fileName));
		}else {
			// 첨부파일이 없으면
			System.out.println("첨부파일이 없으면:" + vo.getProduct_imgStr());
			fileName =vo.getProduct_imgStr();
		}		
		vo.setProduct_imgStr(fileName);
		System.out.println("........>  " + vo);
	   	service.productUpdate(vo);
	   return "productList.do";
	}
	
}