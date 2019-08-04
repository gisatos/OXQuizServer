package com.myquiz.quiz.persistence;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myquiz.quiz.domain.TempQuizVO;

@Repository
public class TempQuizDao {
	@Inject
	private SqlSession sqlSession;
	private final static String namespace = "com.myquiz.quiz.tempQuiz";
	
	public List<TempQuizVO> getTempList(){
		List<TempQuizVO> list = sqlSession.selectList(namespace+".tquizSelect");
		return list;
	}
	
	public TempQuizVO getTqOne(int id) {
		TempQuizVO tqVO = sqlSession.selectOne(namespace+".tqOne", id);
		return tqVO;
	}
	
	public void tqToQ(TempQuizVO tqVO) {
		sqlSession.insert(namespace+".tqToQ", tqVO);
	}
	
	public void deleteTq(int id) {
		sqlSession.delete(namespace+".tqdOne", id);
	}
	
	public void insertTquiz(TempQuizVO tqVO) {
		sqlSession.insert(namespace+".insertTquiz", tqVO);
	}
}
