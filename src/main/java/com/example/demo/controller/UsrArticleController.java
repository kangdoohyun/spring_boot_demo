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
		
		makeTestDate();
	}

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title) {
		Article article = writeArticle(title);
		
		return article;
	}
	
	@RequestMapping("/usr/article/list")
	@ResponseBody
	public List<Article> getArticles() {
		return articles;
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = getArticleById(id);
		
		if(article == null) {
			return "존재하지 않는 게시물입니다.";
		}
		
		deleteArticle(article);
		
		return id +  "번 게시물을 삭제하였습니다.";
	}

	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title) {
		Article article = getArticleById(id);

		if(article == null) {
			return "존재하지 않는 게시물입니다.";
		}
		
		modiftArticle(article, title);
		
		return id + "번 게시물이 수정되었습니다.";
	}
	
	@RequestMapping("/usr/article/detail")
	@ResponseBody
	public Object showDetail(int id) {
		Article article = getArticleById(id);
		
		if(article == null) {
			return "존재하지 않는 게시물입니다.";
		}
		
		return article;
	}
	
	private void makeTestDate() {
		for(int i = 0; i < 10; i++) {
			writeArticle("제목" + (i + 1));
		}
	}
	
	public Article writeArticle(String title) {
		int id = ++lastId;
		Article article = new Article(id , title);
		articles.add(article);
		lastId = id;
		
		return article;
	}
	
	public void deleteArticle(Article article) {
		articles.remove(article);
	}
	
	public void modiftArticle(Article article, String title) {
		article.setTitle(title);
	}
		
	private Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}
}
