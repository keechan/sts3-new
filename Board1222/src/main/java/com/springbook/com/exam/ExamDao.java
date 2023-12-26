package com.springbook.com.exam;

import java.util.List;

public interface ExamDao {
	List<ExamVO> getExamList(ExamVO vo);
	void examInsert(ExamVO vo);
}
