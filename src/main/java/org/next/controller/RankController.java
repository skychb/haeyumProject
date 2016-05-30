package org.next.controller;

import org.next.dao.RankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rank")
public class RankController {
	@Autowired
	RankDao rankDao;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String rankOpen(Model model) throws Exception {
		model.addAttribute("rank", rankDao.find2016());
		model.addAttribute("teamRank", rankDao.findAll());
		return "rank";
	}
	
}
