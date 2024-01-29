<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><form action="regform" method="post">
Name: <input type="text" name="name1"><br><br>
Email: <input type="text" name="email1"><br><br>
Password: <input type="password" name="pass1"><br><br>
Gender: <input type="radio" name="gender1">Male <input type="radio" name="gender1">Female<br><br>
City : <select name="city1">
  <option>Lahore</option>
   <option>Karachi</option>
    <option>Islamabad</option>
</select><br><br>
<input type="submit" value="Register">
</form>
</body>
</html>