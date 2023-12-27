package com.springbook.com.psd;

import java.util.List;

public interface PsdService {
	void insert(PsdVO vo);
	List<PsdVO> getListAll();
	//String getUploadFileStr(PsdVO vo);
	void delete(PsdVO vo);
	PsdVO getListOne(PsdVO vo);
	void update(PsdVO vo);
	void cnt(PsdVO vo);
}
