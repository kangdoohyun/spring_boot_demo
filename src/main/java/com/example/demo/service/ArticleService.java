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
		
	public Article writeArticle(String title) {		
		return articleRepository.writeArticle(title);
	}
	
	public void deleteArticle(Article article) {
		articleRepository.deleteArticle(article);
	}
	
	public void modiftArticle(Article article, String title) {
		articleRepository.modiftArticle(article, title);
	}
	
	public Article getArticleById(int id) {
		return articleRepository.getArticleById(id);
	}
}
