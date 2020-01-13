<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	document.joinForm.email2.value = domain.value;
}
function CheckSubmit() {
	if (document.joinForm.email1.value == ""
			&& document.joinForm.email2.value == "") {
		document.joinForm.email1.focus();
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
		<header>
			<div id="login">
				<a href="MemberLoginForm.me">login</a> | <a href="MemberJoinForm.me">join</a>
			</div>
			<div class="clear"></div>
			<!-- 로고들어가는 곳 -->
			<div id="logo">
				<img src="./images/logo.gif" width="265" height="62" alt="Fun Web">
			</div>
			<!-- 로고들어가는 곳 -->
			<nav id="top_menu">
				<ul>
					<li><a href="main.me">HOME</a></li>
					<li><a href="../company/welcome.html">COMPANY</a></li>
					<li><a href="#">SOLUTIONS</a></li>
					<li><a href="../center/notice.html">CUSTOMER CENTER</a></li>
					<li><a href="#">CONTACT US</a></li>
				</ul>
			</nav>
		</header>
		<!-- 헤더들어가는 곳 -->

		<!-- 본문들어가는 곳 -->
		<!-- 본문메인이미지 -->
		<div id="sub_img_member"></div>
		<!-- 본문메인이미지 -->
		<!-- 왼쪽메뉴 -->
		<nav id="sub_menu">
			<ul>
				<li><a href="#">Join us</a></li>
				<li><a href="#">Privacy policy</a></li>
			</ul>
		</nav>
		<!-- 왼쪽메뉴 -->
		<!-- 본문내용 -->
		<article>
			<h1>Join Us</h1>
			<form action="MemberJoinPro.me" id="join" method="post" name="joinForm">
				<fieldset>
					<legend>Basic Info</legend>
					<label>User ID</label> <input type="text" name="id" class="id"
						required="required" size="20" placeholder="4-16자리 영문자,숫자 조합"
						onkeyup="checkId(this)"><br> <span id="checkIdResult">
						<!-- 자바스크립트에 의해 메세지가 표시될 공간 -->
					</span> <label>Password</label> <input type="password" name="pass"
						required="required" size="20" placeholder="8-20자리 영문자,숫자,특수문자 조합"
						onkeyup="checkPasswd(this)"><br> <span
						id="checkPasswdResult">
						<!-- 자바스크립트에 의해 메세지가 표시될 공간 -->
					</span> <label>Name</label> <input type="text" name="name"
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
					<label>Gender</label>
					<input type="radio" name="gender" value="남">남 <input
						type="radio" name="gender" value="여">여<br>
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