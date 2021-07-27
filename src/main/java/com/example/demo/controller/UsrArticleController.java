package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;
import com.example.demo.service.ArticleService;

@Controller
public class UsrArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/usr/article/doWrite")
	@ResponseBody
	public Article doWrite(String title, String body) {
		int id = articleService.writeArticle(title, body);
		
		Article article = articleService.getArticleById(id);
		return article;
	}
	
	@RequestMapping("/usr/article/list")
	public String showList(Model model) {
		model.addAttribute("articles", articleService.getArticles());
		return "usr/article/list";
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getArticleById(id);
		
		if(article == null) {
			return "존재하지 않는 게시물입니다.";
		}
		
		articleService.deleteArticle(article);
		
		return id +  "번 게시물을 삭제하였습니다.";
	}

	@RequestMapping(value = "/usr/article/doModify", method = RequestMethod.GET)
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = articleService.getArticleById(id);

		if(article == null) {
			return "존재하지 않는 게시물입니다.";
		}
		
		articleService.modifyArticle(id, title, body);
		
		return id + "번 게시물이 수정되었습니다.";
	}
	
	@RequestMapping("/usr/article/detail")
	public String showDetail(int id, Model model) {
		Article article = articleService.getArticleById(id);
		
		if(article == null) {
			return "존재하지 않는 게시물입니다.";
		}
		
		model.addAttribute("article", article);
		
		return "usr/article/detail";
	}
	
	
}
