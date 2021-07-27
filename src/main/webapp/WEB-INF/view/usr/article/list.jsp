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
    <h2>게시물 리스트</h2>
    <hr>
  </div>
  <section>
    <c:forEach var="article" items="${articles}">
      <div>
        <span>번호 : ${article.id}</span>
        <br>
        <span>작성 날짜 : ${article.regDate}</span>
        <br>
        <span>수정 날짜 : ${article.updateDate}</span>
        <br>
        <a href="./detail?id=${article.id}">제목 : ${article.title}</a>
      </div>
      <hr>
    </c:forEach>
  </section>
</body>
</html>