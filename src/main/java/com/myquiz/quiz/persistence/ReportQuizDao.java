package com.myquiz.quiz.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myquiz.quiz.domain.QuizVO;
import com.myquiz.quiz.domain.ReportQuizVO;

@Repository
public class ReportQuizDao {
	@Inject
	private SqlSession sqlSession;
	private final static String namespace = "com.myquiz.quiz.reportQuiz";
	
	public List<QuizVO> getRqList(){
		List<QuizVO> list = sqlSession.selectList(namespace+".selectRqList");
		return list;
	}
	
	public void reportQuiz(ReportQuizVO reportQuizVO) {
		sqlSession.insert(namespace+".insertReportQuiz", reportQuizVO);
	}
	
	public void deleteReport(int id) {
		sqlSession.delete(namespace+".deleteReport", id);
	}
	public void deleteQuiz(int id) {
		sqlSession.delete(namespace+".deleteQuiz", id);
	}
	public void switchAnswer(int id) {
		sqlSession.update(namespace+".switchAnswer", id);
	}
	
	public int selectReportType1(int id) {
		return sqlSession.selectOne(namespace+".selectReportType1", id);
	}
	public int selectReportType2(int id) {
		return sqlSession.selectOne(namespace+".selectReportType2", id);
	}
	public int selectReportType3(int id) {
		return sqlSession.selectOne(namespace+".selectReportType3", id);
	}
}