<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 리스트" />

<%@ include file="../part/head.jspf"%>
<section class="container mx-auto">
  <div class="list-article">
    <c:forEach var="article" items="${articles}">
      <div>
        <span>번호 : ${article.id}</span>
        <br>
        <span>작성 날짜 : ${article.regDate}</span>
        <br>
        <span>수정 날짜 : ${article.updateDate}</span>
        <br>
        <a href="./detail?id=${article.id}">제목 : ${article.title}</a>
        <hr>
      </div>
    </c:forEach>
  </div>
</section>
<%@ include file="../part/foot.jspf"%>