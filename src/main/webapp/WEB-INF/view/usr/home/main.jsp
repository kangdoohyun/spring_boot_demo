<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="메인 페이지" />

<%@ include file="../part/head.jspf"%>

<section class="section section-detail container mx-auto shadow">
  <div class="section-top flex justify-center font h-full mt-2">
    <span class="h-full flex justify-center items-center"><i class="fas fa-home"></i></span>
    <span class="h-full flex-grow flex justify-center items-center">메인 페이지</span>
    <span class="w-5"></span>
  </div>
  <div class="section-body mb-2">
    <div class="write-article py-2">
      메인 페이지 입니다.
    </div>
  </div>
</section>

<%@ include file="../part/foot.jspf"%>