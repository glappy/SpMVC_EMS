<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		$(function() {
			$("#write").click(function() {
				location.href = "mail"
			})

			$(".email_row").click(function() {
				let id = $(this).attr("data-id")
				location.href = "view?id=" + id
			})

		})
	</script>
</head>
<body>
	<header>
		<h3>이메일 보내기</h3>
	</header>
	<section>
		<article>
			<table>
				<tr>
					<th>보내는 사람</th>
					<th>받는 사람</th>
					<th>제목</th>
					<th>내용</th>
					<th>파일</th>
				</tr>
				<c:choose>
					<c:when test="${empty MAILS}">
						<tr>
							<td colspan=5>메일함이 비었습니다</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${MAILS}" var="mail">
							<tr class="email_row" data-id="${mail.id}">
								<td>${mail.from_email}</td>
								<td>${mail.to_email}</td>
								<td>${mail.s_subject}</td>
								<td>${mail.s_content}</td>
								<td>${mail.s_file1}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			<hr />
			<button id="write">작성하기</button>
		</article>
	</section>
</body>


</html>