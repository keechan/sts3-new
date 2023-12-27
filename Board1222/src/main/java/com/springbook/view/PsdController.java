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
import org.springframework.web.multipart.MultipartFile;

import com.springbook.com.psd.PsdService;
import com.springbook.com.psd.PsdVO;

@Controller
public class PsdController  {
	//@Autowired
	//private PsdDaoMybatis dao;
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private PsdService service;
	String path = "";

//	/@PostConstruct 은 init() 메소드는 WAS가 띄워질 때 실행된다.
	@PostConstruct
	public void init() {
		path = servletContext.getRealPath("/psd/img/");
	}
	
	@RequestMapping(value="psdInsert.do")
	public String psdInsert() {
		System.out.println("===> psdInsert.do");
		return "/psd/psd_insert.jsp";
	}
	
	@RequestMapping(value="psdInsertOK.do")
	public String psdInsertOK(PsdVO vo) throws IllegalStateException, IOException {
		System.out.println("===> psdInsertOK");
		//D:\eclipse-sts3\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\
		// wtpwebapps\Board1222\psd\img\
		
		//시분초 : 120100
		long time = System.currentTimeMillis();
		SimpleDateFormat daytime= new SimpleDateFormat("HHmmss");
		String timeStr = daytime.format(time);
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
	
	@RequestMapping(value="psdDelete.do")
	public String psdDelete(PsdVO vo) {
		//파일 삭제
		File delF = new File(path + vo.getUploadFileStr()); 
		if (!vo.getUploadFileStr().equals("space.PNG")) {
			System.out.println("=====>PsdController : 파일삭제");
			delF.delete();
		}
		//레코드 삭제
		service.delete(vo);
		return "psdList.do";
	}
	
	@RequestMapping(value="psdList.do")
	public String psdList(PsdVO vo, Model m) {
		System.out.println("===> psdList");
		m.addAttribute("li", service.getListAll());
		return "/psd/psd_list.jsp";
	}
	
	@RequestMapping(value="psdEdit.do")
	public String psdEdit(Model model, PsdVO vo) {
		System.out.println("====> psdEdit.do 확인");
		service.cnt(vo);
		model.addAttribute("m", service.getListOne(vo));
		
		return "/psd/psd_edit.jsp";
	}
	public String psdUpdateOK(@ModelAttribute("m") PsdVO vo, Model model) {
		System.out.println("=====> psdUpdateOK");
		
		service.update(vo);
		return "psdList.do";
	}
}
