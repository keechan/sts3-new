package com.springbook.com.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	private ExamDaoMybatis dao;
	
	@Override
	public List<ExamVO> getExamList(ExamVO vo) {
		return dao.getExamList(vo);
	}

	@Override
	public void examInsert(ExamVO vo) {
		dao.examInsert(vo);		
	}
}
