<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
	.detail-box {
	padding: 5px 20px;
		margin:10px auto;
		border: 1px solid blue;
		font-size:20px;
		
	}

</style>
<script>
$(function(){
	$("#btn_update").click(function(){
		let id = ${mail.id}
		location.href = "<c:url value='/update' />" + "?id=" + id
	})
	
	$("#btn_delete").click(function(){
		let id = ${mail.id}
		location.replace("<c:url value='/delete' />" + "?id=" + id)
	})

})
</script>
<body>
<header>
	<h3>Email 관리 시스템</h3>
</header>
<section>
	<article class="detail-box">
		<p>작성일자 : ${mail.s_date}
		<p>작성시각 : ${mail.s_time}<br/><br/>
		<p>보내는 Email : ${mail.from_email }
		<p>받는 Email : ${mail.to_email }<br/><br/>	
		<p>제목 : ${mail.s_subject}
		<p>내용 : ${mail.s_content}<br/><br/>
		<p>첨부파일</p>
		<p><img src="<c:url value='/files/' />${mail.s_file1}" >
		<p><img src="<c:url value='/files/' />${mail.s_file2}" >
		<p><button type="button" id="btn_update">편집</button>
		<button type="button" id="btn_delete">삭제</button>			
	</article>
</section>
</body>
</html>