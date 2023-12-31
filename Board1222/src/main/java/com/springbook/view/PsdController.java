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

import com.springbook.com.psd.PsdService;
import com.springbook.com.psd.PsdVO;

@SessionAttributes("m")
@Controller
public class PsdController {

	@Autowired
	private ServletContext  servletContext;
	
	@Autowired
	private PsdService service;
	
	String path ="";
	String timeStr ="";
	// @PostConstruct 은 init() 메소드는 WAS 가 띄워질때 실행된다.
	@PostConstruct
	public  void init() {
	  path = servletContext.getRealPath("/psd/img/");
	  
	}	
	
	@RequestMapping(value="psdInsertOK.do")
	public  String psdInsertOK(PsdVO  vo) throws IOException {
	
		// D:\eclipse-workspace-sts3\.metadata\.plugins\org.eclipse.wst.server.core
		//          \tmp0\wtpwebapps\SpringProject1222\psd\img\
		
		System.out.println(" ====> path:"+ path);
		
		long time = System.currentTimeMillis();
		SimpleDateFormat daytime= new SimpleDateFormat("HHmmss");
		timeStr = daytime.format(time);
		// 시분초 : 120035
		System.out.println("timeStr:"+ timeStr);
		
		MultipartFile uploadFile = vo.getUploadFile();
		
		String fileName = uploadFile.getOriginalFilename();
		File f = new File(path+fileName);
		
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
		vo.setUploadFileStr(fileName);
		service.insert(vo);
		
		return "psdList.do";		
	}

	@RequestMapping(value="psdInsert.do")
	public  String examInsert() {
		return "/psd/psd_insert.jsp";		
	}
	
	@RequestMapping(value="psdDelete.do")
	public  String psdDelete(PsdVO  vo) {
		
	    File delF = new File(path + vo.getUploadFileStr());
	    
	    if (!vo.getUploadFileStr().equals("space.png")) {
	    	delF.delete();  //  실제파일 삭제
	    }		
	    
		service.delete(vo);
		
		return "psdList.do";		
	}
	
	
	@RequestMapping(value="psdList.do")
	public  String psdList(PsdVO  vo, Model  model) {
		
		model.addAttribute("li", service.getListAll() );
		
		return "/psd/psd_list.jsp";		
	}
	
	@RequestMapping(value="psdEdit.do")
	public  String psdEdit(PsdVO  vo, Model  model) {
		
		service.cnt(vo);
		
		model.addAttribute("m", service.getListOne(vo) );
		
		return "/psd/psd_edit.jsp";		
	}
		
	
	@RequestMapping(value="psdUpdateOK.do")
	public  String psdUpdateOK(@ModelAttribute("m") PsdVO  vo, Model  model) 
			throws Exception {
	   System.out.println(" ====> path:"+ path);
	   
	   long time = System.currentTimeMillis();
	   SimpleDateFormat daytime= new SimpleDateFormat("HHmmss");
	   timeStr = daytime.format(time);

		MultipartFile uploadFile = vo.getUploadFile();		
		String fileName = uploadFile.getOriginalFilename();
		File f = new File(path+fileName);
		
		if (!uploadFile.isEmpty()) {
			// 첨부파일이 있으면 ...    
	           // vo.getUploadFileStr(); 기존파일명
			  if (!vo.getUploadFileStr().equals("space.png")) {
		         File delF = new File(path + vo.getUploadFileStr() );
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
			System.out.println("첨부파일이 없으면:" + vo.getUploadFileStr());
			fileName =vo.getUploadFileStr();
		}		
		vo.setUploadFileStr(fileName);
		System.out.println("........>  " + vo);
	   	service.update(vo); 		
	   return "psdList.do";		
	}
	
}