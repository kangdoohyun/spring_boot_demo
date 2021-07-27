package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.Article;

@Repository
public class ArticleRepository {

	private List<Article> articles;
	private int lastId;
	
	public ArticleRepository() {
		articles = new ArrayList<>();
		lastId = 0;
	}
	public List<Article> getArticles() {
		return articles;
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
