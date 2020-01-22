<%@page import="vo.CommentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	// page, BoardBean 객체 파라미터 가져오기
	String nowPage = (String)request.getAttribute("page");
	BoardBean article = (BoardBean)request.getAttribute("article");
	ArrayList<CommentBean> comment = (ArrayList<CommentBean>)request.getAttribute("comment");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판_view</title>
<style type="text/css">
	#articleForm {
		width: 500px;
		height: 500px;
		border: 1p solid red;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	#basicInfoArea {
		height: 40px;
		text-align: center;
	}
	
	#articleContentArea {
		background: orange;
		margin-top: 20px;
		height: 350px;
		text-align: center;
		overflow: auto;
		white-space: pre-line;
	}
	
	#commandList {
		margin: auto;
		width: 500px;
		text-align: center;
	}
</style>
</head>
<body>
<!--게시판 상세내용 보기 -->
	<section id = "articleForm">
		<h2>글 상세내용 보기</h2>
		<section id = "basicInfoArea">
			제목 : <%= article.getboard_subject() %><br>
			첨부파일 : 
			<%
				if(article.getboard_file() != null){
					%><a href='file_down?downFile=<%=article.getboard_file() %>'></a>
				<%}
			%>
		</section>
		<section id = "articleContentArea">
			<%= article.getboard_content() %>
		</section>
	</section>
	<section id = "conmmandList">
		<input type = "button" value = "답변" onclick="location.href='BoardReplyForm.bo?board_num<%=article.getboard_num() %>&page=<%=nowPage %>'">
		<input type = "button" value = "수정" onclick="location.href='BoardModifyForm.bo?board_num<%=article.getboard_num() %>&page=<%=nowPage %>'">
		<input type = "button" value = "삭제" onclick="location.href='BoardDeleteForm.bo?board_num<%=article.getboard_num() %>&page=<%=nowPage %>'">
		<input type = "button" value = "목록" onclick="location.href='BoardList.bo?page=<%=nowPage %>'">
	</section>
	<section id = "commandList">
		<ul>
			<%for(CommentBean com : comment){ %>
			<li>ID : <%=com.getMember_id() %>댓글 : <%=com.getComment() %>
			<%} %>
		</ul>
	</section>
	<section id = "commandList">
		<form action = "/Funweb_Model2/InsertComment.bo" method = "post">
			별점 : 
			1점<input type = "radio" name = "star" value = "1">
			2점<input type = "radio" name = "star" value = "2">
			3점<input type = "radio" name = "star" value = "3">
			4점<input type = "radio" name = "star" value = "4">
			5점<input type = "radio" name = "star" value = "5">
		
			<textarea rows = "5" cols = "30" name = "comment"></textarea>
			<input type = "hidden" name = "board_num" value = <%=article.getboard_num() %>>
			아이디 : <input type = "text" name = "member_id">
			<input type = "hidden" name = "page" value = <%=nowPage %>>
			<input type = "submit" value = "댓글등록">
		</form>
	</section>
</body>
</html>