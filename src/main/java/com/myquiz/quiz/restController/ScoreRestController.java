package com.myquiz.quiz.restController;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myquiz.quiz.domain.ScoreVO;
import com.myquiz.quiz.persistence.ScoreDao;

@Controller
@RequestMapping("andScore")
public class ScoreRestController {
	
	@Inject
	ScoreDao scoreDao;
		
	@RequestMapping(value = "registerScore", method=RequestMethod.POST)
	public @ResponseBody String getRank(@ModelAttribute ScoreVO svo) {
		scoreDao.deleteScore(svo.getId());
		scoreDao.insertScore(svo);
		return scoreDao.selectRank(svo.getId());
	}
}
