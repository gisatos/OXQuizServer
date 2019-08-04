package com.myquiz.quiz.restController;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myquiz.quiz.domain.ReportQuizVO;
import com.myquiz.quiz.persistence.ReportQuizDao;

@Controller
@RequestMapping(value = "andReportQuiz")
public class ReportQuizRestController {

	@Inject
	ReportQuizDao reportQuizDao;
	
	@RequestMapping(value="reportQuiz", method=RequestMethod.POST)
	public void reportQuiz(@ModelAttribute ReportQuizVO reportQuizVO) {
		reportQuizDao.reportQuiz(reportQuizVO);
	}
}
