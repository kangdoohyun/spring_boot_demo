package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.Article;

@Mapper
public interface ArticleRepository {
	public List<Article> getArticles();
	
	public Article writeArticle(String title);
	
	public void deleteArticle(Article article);
	
	public void modiftArticle(Article article, String title);
	
	@Select("select * from article where id = #{id}")
	public Article getArticleById(@Param("id") int id);	
}
