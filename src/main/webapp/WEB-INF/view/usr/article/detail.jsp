<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div>
    <div>
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
    </div>
    <hr>
  </div>
</body>
</html>