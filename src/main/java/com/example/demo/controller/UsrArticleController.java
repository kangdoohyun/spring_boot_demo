package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.Article;
import com.example.demo.service.ArticleService;
import com.example.demo.util.ScriptUtil;

@Controller
public class UsrArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/usr/article/write", method = RequestMethod.GET)
	public String showWrite(Model model) {
		return "usr/article/write";
	}

	@RequestMapping(value = "/usr/article/doWrite", method = RequestMethod.POST)
	public void doWrite(String title, String body, HttpServletResponse response, RedirectAttributes redirect) {
		if (title == null || title.isEmpty()) {
			ScriptUtil.historyBack(response, "제목을 입력해주세요.");
			return;
		}

		if (body == null || body.isEmpty()) {
			ScriptUtil.historyBack(response, "내용을 입력해주세요.");
			return;
		}

		int id = articleService.writeArticle(title, body);
		
		String redirectUrl ="./detail?id=" + id; 
		
		ScriptUtil.locationReplace(response, "게시물을 작성하였습니다.", redirectUrl);
	}

	@RequestMapping(value = "/usr/article/list", method = RequestMethod.GET)
	public String showList(Model model) {
		model.addAttribute("articles", articleService.getArticles());
		return "usr/article/list";
	}

	@RequestMapping(value = "/usr/article/doDelete", method = RequestMethod.POST)
	public void doDelete(Integer id, HttpServletResponse response) {
		if (id == null || id == 0) {
			ScriptUtil.historyBack(response, "번호를 입력해주세요.");
			return;
		}

		Article article = articleService.getArticleById(id);

		if (article == null) {
			ScriptUtil.historyBack(response, "존재하지 않는 게시물입니다.");
			return;
		}

		articleService.deleteArticle(article);

		ScriptUtil.locationReplace(response, id + "번 게시물을 삭제하였습니다.", "./list");
	}

	@RequestMapping(value = "/usr/article/modify", method = RequestMethod.GET)
	public String showModify(Integer id, String title, String body, HttpServletResponse response, RedirectAttributes redirect) {
		if (id == null || id == 0) {
			ScriptUtil.historyBack(response, "번호를 입력해주세요.");
		}

		Article article = articleService.getArticleById(id);

		if (article == null) {
			ScriptUtil.historyBack(response, "존재하지 않는 게시물입니다.");
		}

		articleService.modifyArticle(id, title, body);
		
		redirect.addAttribute("id", id);
		redirect.addAttribute("title", title);
		redirect.addAttribute("body", body);
		
		return "usr/article/modify";
	}
	
	@RequestMapping(value = "/usr/article/doModify", method = RequestMethod.POST)
	public void doModify(Integer id, String title, String body, HttpServletResponse response) {
		if (id == null || id == 0) {
			ScriptUtil.historyBack(response, "번호를 입력해주세요.");
			return;
		}

		Article article = articleService.getArticleById(id);

		if (article == null) {
			ScriptUtil.historyBack(response, "존재하지 않는 게시물입니다.");
			return;
		}
		
		if (title == null || title.isEmpty()) {
			ScriptUtil.historyBack(response, "제목을 입력해주세요.");
			return;
		}
		
		if (body == null || body.isEmpty()) {
			ScriptUtil.historyBack(response, "내용을 입력해주세요.");
			return;
		}

		articleService.modifyArticle(id, title, body);

		ScriptUtil.locationReplace(response, id + "번 게시물이 수정되었습니다.", "./detail?id=" + id);
	}

	@RequestMapping(value = "/usr/article/detail", method = RequestMethod.GET)
	public String showDetail(Integer id, Model model, HttpServletResponse response) {
		if (id == null || id == 0) {
			ScriptUtil.historyBack(response, "번호를 입력해주세요.");
		}

		Article article = articleService.getArticleById(id);

		if (article == null) {
			ScriptUtil.historyBack(response, "존재하지 않는 게시물입니다.");
		}

		model.addAttribute("article", article);

		return "usr/article/detail";
	}

}
