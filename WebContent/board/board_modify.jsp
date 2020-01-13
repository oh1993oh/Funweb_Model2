<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String nowPage = request.getParameter("page");
	BoardBean article = (BoardBean)request.getAttribute("article");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
	modifyForm {
		width: 500px;
		height: 610px;
		border: 1p solid red;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		margin: auto;
		width: 450px;
	}
	
	.td_left {
		width: 150px;
		background: orange;
	}
	
	.td_right {
		width: 300px;
		background: skyblue;
	}
	
	#commandCell {
		text-align: center;
	}
	
	#board_content {
		resize: none;
	}
	
</style>
</head>
<body>
	<!-- 게시판 수정하기 -->
	<section id="modifyForm">
		<h2>글 수정하기<%=nowPage %></h2>
		<form action="BoardModifyPro.bo" method="post" name="modifyForm">
			<input type="hidden" name="board_num" value="<%=article.getBoard_num() %>" />
			<input type="hidden" name="page" value="<%=nowPage %>" />
			<table>
				<tr>
					<td class="td_left"><label for="board_name">글쓴이</label></td>
					<td class="td_right">
						<input type="text" name="board_name" required="required" value=<%=article.getBoard_name() %> />
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_pass">비밀번호</label></td>
					<td class="td_right">
						<input type="password" name="board_pass" required="required" />
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_subject">제목</label></td>
					<td class="td_right">
						<input type="text" name="board_subject" required="required" value=<%=article.getBoard_subject() %> />
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_content">내용</label></td>
					<td class="td_right">
						<textarea id="board_content" name="board_content" cols="40" rows="15" 
									required="required"><%=article.getBoard_content() %></textarea>
					</td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="수정">&nbsp;&nbsp;
				<input type="button" value="뒤로" onclick="history.back()">
			</section>
		</form>
	</section>
</body>
</html>















