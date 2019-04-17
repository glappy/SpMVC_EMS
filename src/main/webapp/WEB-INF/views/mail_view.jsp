<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		$(function() {
			$("#update").click(function() {
				let id = ${mail.id}
				location.href = "<c:url value='/update' />" + "?id=" + id
			})

			$("#delete").click(function() {
				let id = ${mail.id}
				location.replace("<c:url value='/delete' />" + "?id=" + id)
			})
		})
	</script>
<body>
	<header>
		<h3>이메일 보내기</h3>
	</header>
	<section>
		<article class="detail-box">
			<p>보내는 사람: ${mail.from_email }
			<p>받는 사람: ${mail.to_email }
			<p>제목 : ${mail.s_subject}
			<p>내용 : ${mail.s_content}
			<p>첨부파일</p>

			<p><img src="<c:url value='/files/' />${mail.s_file1}">
			<p><img src="<c:url value='/files/' />${mail.s_file2}">
			<p><button type="button" id="update">편집</button>
				<button type="button" id="delete">삭제</button></article>

	</section>
</body>

</html>