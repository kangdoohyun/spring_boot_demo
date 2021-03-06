<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="글 작성 페이지" />

<%@ include file="../part/head.jspf"%>

<section class="section section-detail container mx-auto shadwo">
  <div class="section-top flex justify-center font h-full mt-2">
    <span class="h-full flex justify-center items-center"><i class="fas fa-pen"></i></span>
    <span class="h-full flex-grow flex justify-center items-center">글 작성</span>
    <span class="w-5"></span>
  </div>
  <div class="section-body mb-2">
    <div class="write-article py-2">
      <form action="./doWrite" method="POST">
        <div class="form-control">
          <label class="label">
            <span class="label-text">제목</span>
          </label>
          <input type="text" name="title" placeholder="제목을 입력해주세요" class="input input-bordered">
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">내용</span>
          </label>
          <textarea name="body" class="textarea h-24 textarea-bordered" placeholder="내용을 입력해주세요."></textarea>
        </div>
        <button class="btn btn-link">완료</button>
        <button type="button" class="btn btn-link" onclick="history.back()">뒤로가기</button>
      </form>
    </div>
  </div>
</section>

<%@ include file="../part/foot.jspf"%>