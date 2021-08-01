<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="로그인" />

<%@ include file="../part/head.jspf"%>

<section class="section section-login container mx-auto shadwo">
  <div class="section-top flex justify-center font h-full mt-2">
    <span class="h-full flex justify-center items-center"><i class="fas fa-sign-in-alt"></i></span>
    <span class="h-full flex-grow flex justify-center items-center">로그인</span>
    <span class="w-5"></span>
  </div>
  <div class="section-body mb-2">
    <div class="write-article py-2">
      <form action="./doLogin" method="GET">
        <div class="form-control">
          <label class="label">
            <span class="label-text">아이디</span>
          </label>
          <input type="text" name="loginId" placeholder="아이디를 입력해주세요" class="input input-bordered">
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">비밀번호</span>
          </label>
          <input type="text" name="loginPw" placeholder="비밀번호를를 입력해주세요" class="input input-bordered">
        </div>
        <button class="btn btn-link">로그인</button>
        <button type="button" class="btn btn-link" onclick="history.back()">뒤로가기</button>
      </form>
    </div>
  </div>
</section>

<%@ include file="../part/foot.jspf"%>