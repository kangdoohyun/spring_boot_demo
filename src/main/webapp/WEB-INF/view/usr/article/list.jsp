<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 리스트" />

<%@ include file="../part/head.jspf"%>
<section class="section section-list container mx-auto">
  <div class="section-top flex items-center justify-center font">
    <span>게시물 리스트</span>
  </div>
  <div class="section-body">
    <div class="list-article">
      <c:forEach var="article" items="${articles}">
        <div class="py-2">
          <div class="badge badge-outline badge-md font">번호</div>
          <span> ${article.id}</span>
          <br>
          <div class="badge badge-outline badge-md font">작성 날짜</div>
          <span> ${article.regDate}</span>
          <br>
          <div class="badge badge-outline badge-md font">수정 날짜</div>
          <span> ${article.updateDate}</span>
          <br>
          <div class="badge badge-outline badge-md font">제목</div>
          <a href="./detail?id=${article.id}"> ${article.title}</a>
        </div>
        <div>
          <hr>
        </div>
      </c:forEach>
    </div>
  </div>
</section>
<%@ include file="../part/foot.jspf"%>