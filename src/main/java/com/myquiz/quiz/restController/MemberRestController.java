package com.myquiz.quiz.restController;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myquiz.quiz.domain.MemberVO;
import com.myquiz.quiz.persistence.MemberDao;

@Controller
@RequestMapping("andMember")
public class MemberRestController {
	@Inject
	MemberDao memberDao;
	
	@RequestMapping(value="loginCheck", method=RequestMethod.POST)
	public @ResponseBody String loginCheck(@ModelAttribute MemberVO memberVO) {
		int check = memberDao.loginCheck(memberVO);
		return ""+check;
	}

}
