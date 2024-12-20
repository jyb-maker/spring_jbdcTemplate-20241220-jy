<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<h2>게시판 글쓰기</h2>
	<hr>
	<form action="writeOk">
		이름 : <input type="text" name="bname"><br><br>
		제목 : <input type="text" name="btitle" size="60"><br><br>
		내용 : <textarea rows="10" cols="50" name="bcontent"></textarea><br><br>
		<input type="submit" value="입력">
	</form>
</body>
</html>