<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원가입" />

<%@ include file="../part/head.jspf"%>

<section class="section section-join container mx-auto shadwo">
  <div class="section-top flex justify-center font h-full mt-2">
    <span class="h-full flex justify-center items-center"><i class="fas fa-sign-in-alt"></i></span>
    <span class="h-full flex-grow flex justify-center items-center">회원가입</span>
    <span class="w-5"></span>
  </div>
  <div class="section-body mb-2">
    <div class="write-article py-2">
      <form action="./doJoin" method="GET">
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
          <input type="text" name="loginPw" placeholder="비밀번호를 입력해주세요" class="input input-bordered">
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">이름</span>
          </label>
          <input type="text" name="name" placeholder="이름을 입력해주세요" class="input input-bordered">
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">닉네임</span>
          </label>
          <input type="text" name="nickname" placeholder="닉네임을 입력해주세요" class="input input-bordered">
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">이메일</span>
          </label>
          <input type="text" name="email" placeholder="이메일을 입력해주세요" class="input input-bordered">
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">전화번호</span>
          </label>
          <input type="text" name="cellphoneNo" placeholder="전화번호를 입력해주세요" class="input input-bordered">
        </div>
        <button class="btn btn-link">회원가입</button>
        <button type="button" class="btn btn-link" onclick="history.back()">뒤로가기</button>
      </form>
    </div>
  </div>
</section>

<%@ include file="../part/foot.jspf"%>