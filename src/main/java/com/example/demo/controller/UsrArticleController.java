package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;

@Controller
public class UsrArticleController {
	private List<Article> articles;
	private int lastId;
	
	public UsrArticleController() {
		articles = new ArrayList<>();
		lastId = 0;
	}
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title) {
		int id = ++lastId;
		Article article = new Article(id, title);
		
		articles.add(article);
		
		return article;
	}
	
	@RequestMapping("/usr/article/list")
	@ResponseBody
	public List<Article> getArticles() {
		return articles;
	}
}
