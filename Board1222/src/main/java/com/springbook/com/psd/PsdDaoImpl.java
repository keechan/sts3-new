package com.springbook.com.psd;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PsdDaoImpl implements PsdDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<PsdVO> getListAll() {
		System.out.println("===> Mybatis(Select)");

		return mybatis.selectList("PsdDao.Psd_SELECT");
	}

	@Override
	public void insert(PsdVO vo) {
		System.out.println("===> Mybatis(Insert)");
		mybatis.insert("PsdDao.Psd_INSERT", vo);
	}

//	@Override
//	public String getUploadFileStr(PsdVO vo) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void delete(PsdVO vo) {
		mybatis.delete("PsdDao.Psd_DELETE", vo);		
	}

	@Override
	public PsdVO getListOne(PsdVO vo) {
		return mybatis.selectOne("PsdDao.Psd_SELECTONE", vo);
	}

	@Override
	public void update(PsdVO vo) {
		mybatis.update("PsdDao.Psd_UPDATE", vo);
	}

	@Override
	public void cnt(PsdVO vo) {
		mybatis.update("PsdDao.Psd_CNT", vo);
	}
}
