package com.myquiz.quiz.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myquiz.quiz.domain.ScoreVO;

@Repository
public class ScoreDao {
	
	@Inject
	SqlSession sqlSession;
	final static String namespace = "com.myquiz.quiz.score";
	
	public void insertScore(ScoreVO scoreVO) {
		sqlSession.insert(namespace+".insertScore", scoreVO);
	}
	
	public String selectRank(String id) {
		return sqlSession.selectOne(namespace+".selectRank", id);
	}
	//중복 관리용.. 어떻게 할 것인가..
	public int selectScore(String id) {
		return sqlSession.selectOne(namespace+".selectScore", id);
	}
	public void deleteScore(String id) {
		sqlSession.delete(namespace+".deleteScore", id);
	}
	
}
