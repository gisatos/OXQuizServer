package com.myquiz.quiz.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myquiz.quiz.domain.MemberVO;
import com.myquiz.quiz.persistence.MemberDao;

@Controller
@RequestMapping("member")
public class MemberController {
	@Inject
	private MemberDao memberDao;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginCheck(@ModelAttribute MemberVO memberVO, HttpSession session) {
		int check = memberDao.loginCheck(memberVO);
		if(check == 1) {
			session.setAttribute("id", memberVO.getId());
			return "redirect:/";
		} else {
			return "redirect:/";
		}
	}
	
}
