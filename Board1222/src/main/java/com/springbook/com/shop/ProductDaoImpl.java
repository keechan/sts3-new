package com.springbook.com.shop;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void productInsert(ProductVO vo) {
		mybatis.insert("ProductDao.Product_INSERT", vo);
	}

	@Override
	public void productUpdate(ProductVO vo) {
		mybatis.update("ProductDao.Product_UPDATE", vo);
	}

	@Override
	public void productDelete(ProductVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductVO getProductOne(ProductVO vo) {
		return mybatis.selectOne("ProductDao.Product_SELECTONE", vo);
	}

	@Override
	public List<ProductVO> getProductSelect(ProductVO vo) {
		return mybatis.selectList("ProductDao.Product_SELECT");
	}

}
