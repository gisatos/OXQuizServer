package com.myquiz.quiz.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myquiz.quiz.domain.MemberVO;

@Repository
public class MemberDao {
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.myquiz.quiz.member"; 
	
	public int loginCheck(MemberVO memberVO) {
		int check = 0;
		String password = sqlSession.selectOne(namespace+".loginCheck", memberVO);
		if(!(password == null || !memberVO.getPassword().equals(password))) {
			check = 1;
		}
		return check;
	}
}
