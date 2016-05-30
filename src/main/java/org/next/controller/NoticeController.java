package org.next.controller;

import org.next.dao.NoticeDao;
import org.next.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	NoticeDao noticeDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView home() throws Exception {
		ModelAndView mav = new ModelAndView("community");
		mav.addObject("notices", noticeDao.findAll());
		return mav;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(Model model) throws Exception {
		model.addAttribute("notices", new Notice());
		return "/notice/form";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Notice notice) throws Exception {
		noticeDao.addNotice(notice);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/{noticePost_id}", method = RequestMethod.GET)
	public String show(@PathVariable int noticePost_id, Model model) throws Exception {
		model.addAttribute("question", noticeDao.findNoticeById(noticePost_id));
		return "notice/show";
	}
}
