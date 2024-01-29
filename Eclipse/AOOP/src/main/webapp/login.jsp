<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align=center><h1>Welcome!</h1></div>
<form action=LoginServlet method=post>
<table>
<tr> <td>  Name:</td><td><input type=text name =txtName></td></tr>
<tr> <td>  Password:</td><td><input type=password name =txtpwd></td></tr>
<tr> <td> <input type=submit value =Login></td></tr>
</table>
</form>
</body>
</html>