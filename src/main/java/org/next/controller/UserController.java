package org.next.controller;

import javax.servlet.http.HttpServletRequest;
import org.next.dao.UserDao;
import org.next.model.Participant;
import org.next.model.Secretariat;
import org.next.model.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String par_id, @RequestParam String par_pw, HttpServletRequest request) {
		try {
			Participant user = userDao.findUserById(par_id);
			request.getSession().setAttribute("user", user);
			System.out.println(user.getPar_id()+user.getPar_pw());
			return "redirect:/notice";
		} catch (UserNotFoundException e) {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/secretariat/login", method = RequestMethod.POST)
	public String Seclogin(@RequestParam String sec_id, @RequestParam String sec_pw, HttpServletRequest request) {
		try {
			Secretariat user = userDao.findSecretariatById(sec_id);
			request.getSession().setAttribute("user", user);
			return "redirect:/notice/new";
		} catch (UserNotFoundException e) {
			return "redirect:/secretariat";
		}
	}

}