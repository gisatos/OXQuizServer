package com.myquiz.quiz.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myquiz.quiz.domain.QuizVO;
import com.myquiz.quiz.persistence.QuizDao;

@Controller
@RequestMapping("quiz")
public class QuizController {
	
	@Inject
	QuizDao quizDao;
	
	@RequestMapping(value="/quizRegister", method=RequestMethod.GET)
	public String quizRegister() {
		return "quiz/quizRegister";
	}
	
	@RequestMapping(value="/quizRegister", method=RequestMethod.POST)
	public String quizRegister(@ModelAttribute QuizVO quizVO, HttpSession session) {
		String id = (String)session.getAttribute("id");
		quizVO.setM_id(id);
		quizDao.quizInsert(quizVO);
		return "redirect:/quiz/quizRegister";
	}
	
	@RequestMapping(value="/quizMain", method=RequestMethod.GET)
	public String quizMain(Model model) {
		List<QuizVO> list = quizDao.getQuizList();
		model.addAttribute("qList", list);
		return "quiz/quizMain";
	}
}
