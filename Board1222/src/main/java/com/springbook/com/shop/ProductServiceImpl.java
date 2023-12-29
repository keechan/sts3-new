package com.springbook.com.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public void productInsert(ProductVO vo) {
		dao.productInsert(vo);		
	}

	@Override
	public void productUpdate(ProductVO vo) {
		dao.productUpdate(vo);
	}

	@Override
	public void productDelete(ProductVO vo) {
		dao.productDelete(vo);
	}

	@Override
	public ProductVO getProductOne(ProductVO vo) {
		return dao.getProductOne(vo);
	}

	@Override
	public List<ProductVO> getProductSelect(ProductVO vo) {
		System.out.println("======> ServiceImpl getProductSelect");
		return dao.getProductSelect(vo);
	}

	@Override
	public void shopBuyInsert(BuyVO vo) {
		dao.shopBuyInsert(vo);
	}
}