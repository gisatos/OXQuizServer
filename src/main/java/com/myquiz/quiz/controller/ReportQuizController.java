package com.myquiz.quiz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myquiz.quiz.domain.QuizVO;
import com.myquiz.quiz.domain.ReportTypeVO;
import com.myquiz.quiz.persistence.ReportQuizDao;

@Controller
@RequestMapping("reportQuiz")
public class ReportQuizController {
	@Inject
	ReportQuizDao rqDao;

	@RequestMapping(value = "/reportQuizMain", method = RequestMethod.GET)
	public String report_main(Model model) {
		List<QuizVO> list = rqDao.getRqList();
		model.addAttribute("rqList", list);
		List<ReportTypeVO> rlist = new ArrayList<ReportTypeVO>();
		for(int i=0; i<list.size(); i++) {
			ReportTypeVO rvo = new ReportTypeVO();
			rvo.setWrongAnswer(rqDao.selectReportType1(list.get(i).getId()));
			rvo.setUnAcceptable(rqDao.selectReportType1(list.get(i).getId()));
			rvo.setEtc(rqDao.selectReportType3(list.get(i).getId()));
			rlist.add(rvo);
		}
		model.addAttribute("rTypeList" ,rlist);
		return "reportQuiz/reportQuizMain";
	}

	@RequestMapping(value = "/reportToZero", method=RequestMethod.POST)
	public String deleteReport(@RequestParam(value="quizId") List<Integer> quizId) {
		for(int i=0; i<quizId.size(); i++) {
			rqDao.deleteReport(quizId.get(i));
		}
		return "redirect:reportQuizMain";

	}
	@RequestMapping(value = "/deleteQuiz", method=RequestMethod.POST)
	public String deleteQuiz(@RequestParam(value="quizId") List<Integer> quizId) {
		for (int i = 0; i < quizId.size(); i++) {
			rqDao.deleteQuiz(quizId.get(i));
		}
		return "redirect:reportQuizMain";

	}
	@RequestMapping(value = "/toggleQuiz", method=RequestMethod.POST)
	public String switchToYes(@RequestParam(value="quizId") List<Integer> quizId) {
		for (int i = 0; i < quizId.size(); i++) {
			rqDao.switchAnswer(quizId.get(i));
			rqDao.deleteReport(quizId.get(i));
		}
		return "redirect:reportQuizMain";

	}
	
}