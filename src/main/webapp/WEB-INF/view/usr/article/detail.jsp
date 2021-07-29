<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="상세 페이지" />

<%@ include file="../part/head.jspf"%>

<section class="section section-detail container mx-auto shadow">
  <div class="section-top flex justify-center font h-full border-b-2 mt-2">
    <span class="h-full flex justify-center items-center"><i class="far fa-window-maximize"></i></span>
    <span class="h-full flex-grow flex justify-center items-center">${article.title} 상세페이지</span>
    <span class="w-5"></span>
  </div>
  <div class="section-body mb-2">
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