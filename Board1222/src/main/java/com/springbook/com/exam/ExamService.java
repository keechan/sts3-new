package com.springbook.com.exam;

import java.util.List;

public interface ExamService {
	List<ExamVO> getExamList(ExamVO vo);
	void examInsert(ExamVO vo);
}