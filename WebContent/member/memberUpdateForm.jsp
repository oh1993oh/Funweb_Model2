<%@page import="vo.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/default.css" rel="stylesheet" type="text/css">
<link href="./css/subpage.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">

var idcheckResult = false, passcheckResult = false;
var passcheckResult2 = false, namecheckResult = false;
var emailcheckResult = false, numbercheckResult = false;

function changeDomain(domain) {
	// SELECT-OPTION 태그에서 선택된 항목을 email2 필드에 표시
	document.updateForm.email2.value = domain.value;
}
function CheckSubmit() {
	if (document.joinForm.email1.value == ""
			&& document.joinForm.email2.value == "") {
		document.updateForm.email1.focus();
		return;
	} else {
		emailcheckResult = true;
	}
}
</script>
</head>
<body>
	<div id="wrap">
		<!-- 헤더들어가는 곳 -->
		<jsp:include page="../inc/header.jsp"/>
		<!-- 헤더들어가는 곳 -->

		<!-- 본문들어가는 곳 -->
		<!-- 본문메인이미지 -->
		<div id="sub_img_member"></div>
		<!-- 본문메인이미지 -->
		<!-- 왼쪽메뉴 -->
		<nav id="sub_menu">
			<ul>
				<li><a href="#">Update us</a></li>
				<li><a href="#">Privacy policy</a></li>
			</ul>
		</nav>
		<!-- 왼쪽메뉴 -->
		<!-- 본문내용 -->
		<article>
			<h1>Update Us</h1>
			<form action="MemberUpdatePro.me" id="join" method="post" name="updateForm">
				<fieldset>
					<legend>Basic Info</legend>
					<label>User ID</label> <input type="text" name="id" class="id"
						value=<%=id %>><br> <span id="checkIdResult">
						<!-- 자바스크립트에 의해 메세지가 표시될 공간 -->
					</span> <label>Password</label> <input type="password" name="pass"
						required="required" size="20"><br> 
						<label>Name</label> <input type="text" name="name"
						required="required" size="20"><br> 
					 <label>Age</label> <input type="text" name="age"
						required="required" size="10"><br> <label>E-mail</label>
					<input type="text" name="email1" required="required" size="10">@
					<input type="text" name="email2" required="required" size="10">
					<select name="selectDomain" onchange="changeDomain(this)">
						<option value="">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="nate.com">nate.com</option>
					</select><br>
					<br>

				</fieldset>
				<div class="clear"></div>
				<div id="buttons">
					<input type="submit" value="Submit" class="submit"> <input
						type="button" value="Cancel" class="cancel">
				</div>
			</form>
		</article>
		<!-- 본문내용 -->
		<!-- 본문들어가는 곳 -->

		<div class="clear"></div>
		<!-- 푸터들어가는 곳 -->
		<footer>
			<hr>
			<div id="copy">
				All contents Copyright 2011 FunWeb 2011 FunWeb Inc. all rights
				reserved<br> Contact mail:funweb@funwebbiz.com Tel +82 64 123
				4315 Fax +82 64 123 4321
			</div>
			<div id="social">
				<img src="./images/facebook.gif" width="33" height="33"
					alt="Facebook"> <img src="./images/twitter.gif" width="34"
					height="34" alt="Twitter">
			</div>
		</footer>
		<!-- 푸터들어가는 곳 -->
	</div>
</body>
</html>