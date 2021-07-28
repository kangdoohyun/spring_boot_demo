<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="상세 페이지" />

<%@ include file="../part/head.jspf"%>

<section class="container mx-auto">
  <span>번호 : ${article.id}</span>
  <br>
  <span>작성 날짜 : ${article.regDate}</span>
  <br>
  <span>수정 날짜 : ${article.updateDate}</span>
  <br>
  <span>제목 : ${article.title}</span>
  <br>
  <span>내용 : ${article.body}</span>
  <br>
</section>

<%@ include file="../part/foot.jspf"%>