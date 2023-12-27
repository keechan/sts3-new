package com.springbook.com.psd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsdServiceImpl implements PsdService{

	@Autowired
	private PsdDaoImpl dao;
	
	@Override
	public void insert(PsdVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<PsdVO> getListAll() {
		return dao.getListAll();
	}

//	@Override
//	public String getUploadFileStr(PsdVO vo) {
//		return dao.getUploadFileStr(vo);
//	}

	@Override
	public void delete(PsdVO vo) {
		dao.delete(vo);
	}

	@Override
	public PsdVO getListOne(PsdVO vo) {
		return dao.getListOne(vo);
	}

	@Override
	public void update(PsdVO vo) {
		dao.update(vo);
	}

	@Override
	public void cnt(PsdVO vo) {
		dao.cnt(vo);
	}
}
