package org.next.controller;

import org.next.dao.PostDao;
import org.next.dao.ReplyDao;
import org.next.dao.UserDao;
import org.next.model.Notice;
import org.next.model.Post;
import org.next.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/qna")
public class PostController {

	@Autowired
	PostDao postDao;

	@Autowired
	UserDao userDao;

	@Autowired
	ReplyDao replyDao;

	@RequestMapping(value = "/{par_teamNum}", method = RequestMethod.GET)
	public ModelAndView home(@PathVariable int par_teamNum) throws Exception {
		ModelAndView mav = new ModelAndView("qna/board");
		mav.addObject("post", postDao.findPostByTeamId(par_teamNum));
		System.out.println(par_teamNum);
		// System.out.println(session.getAttribute("user"));
		// mav.addObject("user", userDao.findUserById(par_id));
		return mav;
	}

	@RequestMapping(value = "/{parTeam_num}/new", method = RequestMethod.GET)
	public String createForm(@PathVariable int parTeam_num, Model model) throws Exception {
		model.addAttribute("notices", new Notice());
		return "/qna/form";
	}

	@RequestMapping(value = "/{parTeam_num}/create", method = RequestMethod.POST)
	public String create(@PathVariable int parTeam_num, Post post) throws Exception {
		postDao.addPost(post);
		return "redirect:/qna/{parTeam_num}";
	}

	@RequestMapping(value = "/{parTeam_num}/{id_post}/create", method = RequestMethod.POST)
	public String createReply(@PathVariable int parTeam_num, @PathVariable int id_post, Reply reply) throws Exception {
		replyDao.insert(reply);
		return "redirect:/qna/{parTeam_num}/{id_post}";
	}

	@RequestMapping(value = "/{parTeam_num}/{id_post}", method = RequestMethod.GET)
	public String show(@PathVariable int parTeam_num, @PathVariable int id_post, Model model) throws Exception {
		model.addAttribute("post", postDao.findPostById(id_post));
		model.addAttribute("reply", replyDao.findAllByPostId(id_post));
		return "/qna/show";
	}

	@RequestMapping(value = "/{parTeam_num}/{id_post}/edit", method = RequestMethod.GET)
	public String editForm(@PathVariable int parTeam_num, @PathVariable int id_post, Model model) throws Exception {
		model.addAttribute("post", postDao.findPostById(id_post));
		return "/qna/update";
	}

	@RequestMapping(value = "/{parTeam_num}/{id_post}/update", method = RequestMethod.POST)
	public String edit(@PathVariable int parTeam_num, @PathVariable int id_post, Post newPost) throws Exception {
		Post post = postDao.findPostById(id_post);
		post.update(newPost);
		postDao.update(newPost);

		return "redirect:/qna/{parTeam_num}";
	}

	@RequestMapping(value = "/{parTeam_num}/{id_post}/delete", method = RequestMethod.DELETE)
	public String delete(@PathVariable int parTeam_num, @PathVariable int id_post) throws Exception {
		postDao.delete(id_post);
		return "redirect:/qna/{parTeam_num}";
	}

	@RequestMapping(value = "/{parTeam_num}/{id_post}/{id_reply}/delete", method = RequestMethod.DELETE)
	public String deleteAnswer(@PathVariable int parTeam_num, @PathVariable int id_post,@PathVariable int id_reply) throws Exception {
		replyDao.delete(id_reply);
		return "redirect:/qna/{parTeam_num}/{id_post}";
	}
}
