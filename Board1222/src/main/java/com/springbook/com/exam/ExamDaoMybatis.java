package com.springbook.com.exam;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExamDaoMybatis implements ExamDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<ExamVO> getExamList(ExamVO vo) {
		System.out.println("===> Mybatis(Select)");
//		ExamVO vo = new ExamVO();
//		vo.setCh1(ch1);
//		vo.setCh2(ch2);
		System.out.println("=====> ch1 : " + vo.getCh1());
		System.out.println("=====> ch2 : " + vo.getCh2());

		return mybatis.selectList("ExamDao.Exam_SELECT", vo);

	}

	@Override
	public void examInsert(ExamVO vo) {
		System.out.println("===> Mybatis(Insert)");
		mybatis.insert("ExamDao.Exam_INSERT", vo);
	}

	@Override
	public void examDelete(ExamVO vo) {
		System.out.println("===> Mybatis(Delete)");
		mybatis.delete("ExamDao.Exam_DELETE", vo);		
	}

}