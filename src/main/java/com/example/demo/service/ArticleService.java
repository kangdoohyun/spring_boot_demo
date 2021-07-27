package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Article;
import com.example.demo.repository.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;
		
	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}
		
	public int writeArticle(String title, String body) {		
		articleRepository.writeArticle(title, body);
		int id = articleRepository.getLastInsertId();
		
		return id;
	}
	
	public void deleteArticle(Article article) {
		articleRepository.deleteArticle(article);
	}
	
	public void modiftArticle(int id, String title, String body) {
		articleRepository.modiftArticle(id, title, body);
	}
	
	public Article getArticleById(int id) {
		return articleRepository.getArticleById(id);
	}
}
