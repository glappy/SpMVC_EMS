<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		$(function() {
			$("#mail_list").click(function() {
				location.replace("<c:url value='/' />")
			})

		})
	</script>
<body>
	<header>
	<h3>이메일 보내기</h3>
</header>	
<section>
	<article>
		<form:form action="save" enctype="multipart/form-data"
				modelAttribute="evo" id="mail_form">
			<fieldset>
				<legend>Email 작성</legend>
				<div>
					<label for="from_email">보내느 사람</label>
					<form:input type="text" id="from_email" path="from_email" />
				</div>
				<div>
					<label for="to_email">받는 사람</label>
					<form:input type="text" id="to_email" path="to_email" />
				</div>
				<div>
					<label for="s_subject">제목</label>
					<form:input type="text" id="s_subject" path="s_subject" />
				</div>
				<div>
					<label for="s_content"></label>
					<form:textarea rows="10" id="s_content" path="s_content" />
				</div>
				
				
				<div>
					<label for="files"></label>
					<input type="file" name="files" id="files" multiple="multiple">
				</div>
			<div>
				<label for="mail_save"></label>
				<button type="submit" id="mail_save" class="btn blue">메일 보내기</button>
				<button type="button" id="mail_list" class="btn orange">메일 보기</button>
			</div>

			</fieldset>

		</form:form>	
	</article>
</section>
</body>


</html>