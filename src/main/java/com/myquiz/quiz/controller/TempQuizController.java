package com.myquiz.quiz.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myquiz.quiz.domain.TempQuizVO;
import com.myquiz.quiz.persistence.TempQuizDao;

@Controller
@RequestMapping("tempQuiz")
public class TempQuizController {

	@Inject
	TempQuizDao tempQuizDao;

	@RequestMapping(value = "quizRegister", method = RequestMethod.GET)
	public String quizRegister(Model model) {
		List<TempQuizVO> list = tempQuizDao.getTempList();
		model.addAttribute("tqList", list);
		return "tempQuiz/tempQuizRegister";
	}

	@RequestMapping(value = "quizRegister", method = RequestMethod.POST)
	public String quizRegister(@RequestParam int[] check) {
		for (int i = 0; i < check.length; i++) {
			TempQuizVO tqVO = tempQuizDao.getTqOne(check[i]);
			tempQuizDao.tqToQ(tqVO);
			tempQuizDao.deleteTq(check[i]);
		}
		return "redirect:/tempQuiz/quizRegister";
	}
	
	@RequestMapping(value = "insertTquiz", method=RequestMethod.POST)
	public void insertTquiz(@ModelAttribute TempQuizVO tqVO) {
		tempQuizDao.insertTquiz(tqVO);
	}
	
	@RequestMapping(value = "deleteTquiz", method=RequestMethod.POST)
	public String deleteTquiz(@RequestParam int[] check) {
		for(int i=0; i<check.length;i++) {
			tempQuizDao.deleteTq(check[i]);
		}
		return "redirect:/tempQuiz/quizRegister";
	}

}
