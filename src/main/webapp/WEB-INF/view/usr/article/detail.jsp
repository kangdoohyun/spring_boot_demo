<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="상세 페이지" />

<%@ include file="../part/head.jspf"%>

<section class="section section-detail container mx-auto">
  <div class="section-top flex items-center justify-center font">
    <span>${article.title} 상세페이지</span>
  </div>
  <div class="section-body">
    <div class="detail-article py-2">
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
      <span> ${article.title}</span>
      <br>
      <span>${article.body}</span>
    </div>
  </div>
</section>

<%@ include file="../part/foot.jspf"%>