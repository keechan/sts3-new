package com.springbook.com.psd;

import java.util.List;

public interface PsdDao {
	void insert(PsdVO vo);
	List<PsdVO> getListAll();
	//String getUploadFileStr(PsdVO vo);
	void delete(PsdVO vo);
	PsdVO getListOne(PsdVO vo);
	void update(PsdVO vo);
	void cnt(PsdVO vo);
}
