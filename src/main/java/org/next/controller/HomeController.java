package org.next.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home() throws Exception {
		return "index";
	}
	
	@RequestMapping(value = "/secretariat", method = RequestMethod.GET)
	public String secHome() throws Exception {
		return "notice/admin";
	}
	
	@RequestMapping(value = "/qna", method = RequestMethod.GET)
	public String qnaHome() throws Exception {
		return "qna/board";
	}
}
