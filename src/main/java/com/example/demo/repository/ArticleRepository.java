package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.Article;

@Mapper
public interface ArticleRepository {
	public List<Article> getArticles();
	
	public void writeArticle(@Param("title") String title, @Param("body") String body);
	
	public void deleteArticle(Article article);
	
	public void modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);
	
	public Article getArticleById(@Param("id") int id);

	public int getLastInsertId();	
}
