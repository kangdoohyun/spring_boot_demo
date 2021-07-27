package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;
import com.example.demo.service.ArticleService;

@Controller
public class UsrArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title) {
		Article article = articleService.writeArticle(title);
		
		return article;
	}
	
	@RequestMapping("/usr/article/list")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticles();
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

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title) {
		Article article = articleService.getArticleById(id);

		if(article == null) {
			return "존재하지 않는 게시물입니다.";
		}
		
		articleService.modiftArticle(article, title);
		
		return id + "번 게시물이 수정되었습니다.";
	}
	
	@RequestMapping("/usr/article/detail")
	@ResponseBody
	public Object showDetail(int id) {
		Article article = articleService.getArticleById(id);
		
		if(article == null) {
			return "존재하지 않는 게시물입니다.";
		}
		
		return article;
	}
	
	
}
