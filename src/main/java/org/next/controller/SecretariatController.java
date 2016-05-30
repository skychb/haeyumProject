package org.next.controller;

import javax.servlet.http.HttpServletRequest;

import org.next.dao.UserDao;
import org.next.model.Secretariat;
import org.next.model.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/secretariat")
public class SecretariatController {

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String sec_id, @RequestParam String sec_pw, HttpServletRequest request) {
		try {
			Secretariat user = userDao.findSecretariatById(sec_id);
			request.getSession().setAttribute("user", user);
			return "redirect:/notice/form";
		} catch (UserNotFoundException e) {
			return "redirect:/";
		}
	}
}