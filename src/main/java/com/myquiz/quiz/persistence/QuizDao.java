package com.myquiz.quiz.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myquiz.quiz.domain.QuizVO;

@Repository
public class QuizDao {
	
	@Inject
	private SqlSession sqlSession;
	private final static String namespace = "com.myquiz.quiz.quiz";
	
	public void quizInsert(QuizVO quizVO) {
		sqlSession.insert(namespace+".quizInsert", quizVO);
	}
	
	public void addAnsCount(int id) {
		sqlSession.update(namespace+".updateQuizAnsCount", id);
	}
	
	public void addCount(int id) {
		sqlSession.update(namespace+".updateQuizCount", id);
	}
	
	public int getCount() {
		return sqlSession.selectOne(namespace + ".selectQuizCount");
	}
	
	public QuizVO getQuiz(int randomNum) {
		return sqlSession.selectOne(namespace + ".selectQuizForRest", randomNum);
	}
	
	public List<QuizVO> getQuizList(){
		return sqlSession.selectList(namespace+".selectQuizList");
	}
}
