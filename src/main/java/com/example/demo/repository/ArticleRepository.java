package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.Article;

@Mapper
public interface ArticleRepository {
	@Select("SELECT * FROM article ORDER BY id DESC ")
	public List<Article> getArticles();
	
	@Insert("INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = #{title}, `body` = #{body}")
	public void writeArticle(@Param("title") String title, @Param("body") String body);
	
	@Delete("DELETE FROM article WHERE id = #{id}")
	public void deleteArticle(Article article);
	
	@Update("UPDATE article SET updateDate = NOW(), title = #{title}, `body` = #{body} WHERE id = #{id}")
	public void modiftArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);
	
	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticleById(@Param("id") int id);

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();	
}
