<%@page import="vo.MemberBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
// 세션값 가져오기
String id = request.getParameter("id");
// 세션값이 없으면  login | join
// 세션값이 있으면  ..님 | logout | 회원정보 수정

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/default.css" rel="stylesheet" type="text/css">
<link href="./css/front.css" rel="stylesheet" type="text/css">

</head>
<body>
<div id="wrap">
<!-- 헤더파일들어가는 곳 -->
<header>
<%
if(id==null){
	%><div id="login"><a href="MemberLoginForm.me">로그인</a> | <a href="MemberJoinForm.me">회원가입</a></div><%
}else{
	%><div id="login"><%=id %>님 | <a href="LogoutPro.me">logout</a> | <a href="../member/updateForm.jsp">회원정보수정</a> | <a href="../member/deleteForm.jsp">회원탈퇴</a></div><%
}
%>
<!-- <div id="login"><a href="MemberLoginForm.me">login</a> | <a href="MemberJoinForm.me">join</a></div> -->
<div class="clear"></div>
<!-- 로고들어가는 곳 -->
<div id="logo"><img src="./images/logo.gif" width="265" height="62" alt="Fun Web"></div>
<!-- 로고들어가는 곳 -->
<nav id="top_menu">
<ul>
	<li><a href="main.me">HOME</a></li>
	<li><a href="../company/welcome.html">COMPANY</a></li>
	<li><a href="#">SOLUTIONS</a></li>
	<li><a href="BoardList.bo">CUSTOMER CENTER</a></li>
	<li><a href="#">CONTACT US</a></li>
</ul>
</nav>
</header>
<!-- 헤더파일들어가는 곳 -->
<!-- 메인이미지 들어가는곳 -->
<div class="clear"></div>
<div id="main_img"><img src="./images/main_img.jpg"
 width="971" height="282"></div>
<!-- 메인이미지 들어가는곳 -->
<!-- 메인 콘텐츠 들어가는 곳 -->
<article id="front">
<div id="solution">
<div id="hosting">
<h3>Web Hosting Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
<div id="security">
<h3>Web Security Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
<div id="payment">
<h3>Web Payment Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
</div>
<div class="clear"></div>
<div id="sec_news">
<h3><span class="orange">Security</span> News</h3>
<dl>
<dt>Vivamus id ligula....</dt>
<dd>Proin quis ante Proin quis anteProin 
quis anteProin quis anteProin quis anteProin 
quis ante......</dd>
</dl>
<dl>
<dt>Vivamus id ligula....</dt>
<dd>Proin quis ante Proin quis anteProin 
quis anteProin quis anteProin quis anteProin 
quis ante......</dd>
</dl>
</div>
<div id="news_notice">
<h3 class="brown">News &amp; Notice</h3>
<table>
<tr><td class="contxt"><a href="#">Vivans....</a></td>
    <td>2012.11.02</td></tr>
<tr><td class="contxt"><a href="#">Vivans....</a></td>
    <td>2012.11.02</td></tr>
<tr><td class="contxt"><a href="#">Vivans....</a></td>
    <td>2012.11.02</td></tr>
<tr><td class="contxt"><a href="#">Vivans....</a></td>
    <td>2012.11.02</td></tr>
<tr><td class="contxt"><a href="#">Vivans....</a></td>
    <td>2012.11.02</td></tr>
</table>
</div>
</article>
<!-- 메인 콘텐츠 들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터 들어가는 곳 -->
<footer>
<hr>
<div id="copy">All contents Copyright 2011 FunWeb 2011 FunWeb 
Inc. all rights reserved<br>
Contact mail:funweb@funwebbiz.com Tel +82 64 123 4315
Fax +82 64 123 4321</div>
<div id="social"><img src="./images/facebook.gif" width="33" 
height="33" alt="Facebook">
<img src="./images/twitter.gif" width="34" height="34"
alt="Twitter">
</div>
</footer>
<!-- 푸터 들어가는 곳 -->
</div>
</body>
</html>