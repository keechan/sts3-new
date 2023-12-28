package com.springbook.com.shop;

import java.util.List;

public interface ProductService {
	void productInsert(ProductVO vo);
	void productUpdate(ProductVO vo);
	void productDelete(ProductVO vo);
	ProductVO getProductOne(ProductVO vo);
    List<ProductVO> getProductSelect(ProductVO vo);
}
