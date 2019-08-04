package com.myquiz.quiz.restController;

import java.util.Random;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.myquiz.quiz.domain.QuizVO;
import com.myquiz.quiz.persistence.QuizDao;

// @RestController가 스프링3 이후 지원이어서 ..

@Controller
@RequestMapping(value = "andQuiz")
public class QuizRestController {
	// random 객체를 요청이 올때마다 만드는 것보다 만들어 놓고 쓰는게 나을 것 같다
	Random random = new Random();
	Gson gson = new Gson();

	@Inject
	QuizDao quizDao;

	@RequestMapping(value = "/andGetQuiz", produces = "text/plain; charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody String getQuiz(@RequestParam(value = "a", required = false) int[] a) {
		// TODO 증복문제 방지를 위하여 클라이언트 측으로부터 출제된 문제 리스트나 배열을 받을 필요가 있음
		int num = quizDao.getCount();
		int randomNum = random.nextInt(num) + 1;
		if (a != null) {
			for (int i = 0; i < a.length; i++) {
				if (randomNum == a[i]) {
					i = 0;
					randomNum = random.nextInt(num) + 1;
				} else {
					break;
				}
			}
		}
		QuizVO quizVO = quizDao.getQuiz(randomNum);
		quizDao.addCount(randomNum);
		return gson.toJson(quizVO);
	}
	
	@RequestMapping(value = "/addAnsCount", method=RequestMethod.POST)
	public void addAnsCount(int id) {
		quizDao.addAnsCount(id);
	}
}
