package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Article;

@Service
public class ArticleService {

	private List<Article> articles;
	private int lastId;
	
	public ArticleService() {
		articles = new ArrayList<>();
		lastId = 0;
		
		makeTestDate();
	}
	public List<Article> getArticles() {
		return articles;
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
		
	public Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}
}
