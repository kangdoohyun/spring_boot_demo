package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;
import com.example.demo.service.ArticleService;
import com.example.demo.util.ScriptUtil;

@Controller
public class UsrArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/usr/article/doWrite")
	public void doWrite(String title, String body, HttpServletResponse response) {		
		if(title == null || title.isEmpty()) {
			ScriptUtil.alertAndHistoryBack(response, "제목을 입력해주세요.");
		}
		
		if(body == null || body.isEmpty()) {
			ScriptUtil.alertAndHistoryBack(response, "내용을 입력해주세요.");
		}
		
		int id = articleService.writeArticle(title, body);
		
		ScriptUtil.alertAndLocationReplace(response, "게시물을 작성하였습니다..", "./detail?id=" + id);
	}
	
	@RequestMapping("/usr/article/list")
	public String showList(Model model) {
		model.addAttribute("articles", articleService.getArticles());
		return "usr/article/list";
	}
	
	@RequestMapping("/usr/article/doDelete")
	public void doDelete(Integer id, HttpServletResponse response) {
		if(id == null || id == 0) {
			ScriptUtil.alertAndHistoryBack(response, "번호를 입력해주세요.");
		}
		
		Article article = articleService.getArticleById(id);
		
		if(article == null) {
			ScriptUtil.alertAndHistoryBack(response, "존재하지 않는 게시물입니다.");
		}
		
		articleService.deleteArticle(article);
		
		ScriptUtil.alertAndLocationReplace(response, id + "번 게시물을 삭제하였습니다.", "./list");
	}

	@RequestMapping(value = "/usr/article/doModify", method = RequestMethod.GET)
	public void doModify(Integer id, String title, String body, HttpServletResponse response) {
		if(id == null || id == 0) {
			ScriptUtil.alertAndHistoryBack(response, "번호를 입력해주세요.");
		}
		
		Article article = articleService.getArticleById(id);

		if(article == null) {
			ScriptUtil.alertAndHistoryBack(response, "존재하지 않는 게시물입니다.");
		}
		
		articleService.modifyArticle(id, title, body);
		
		ScriptUtil.alertAndLocationReplace(response, id + "번 게시물이 수정되었습니다.", "./detail?id=" + id);
	}
	
	@RequestMapping("/usr/article/detail")
	public String showDetail(Integer id, Model model, HttpServletResponse response) {
		if(id == null || id == 0) {
			ScriptUtil.alertAndHistoryBack(response, "번호를 입력해주세요.");
		}
		
		Article article = articleService.getArticleById(id);
		
		if(article == null) {
			ScriptUtil.alertAndHistoryBack(response, "존재하지 않는 게시물입니다.");
		}
		
		model.addAttribute("article", article);
		
		return "usr/article/detail";
	}
	
}
