<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile Page</title>
</head>
<body>
<img src="hanzla.jpg" style= width:50px; height:50px;>
<%
    
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedDate = dateFormat.format(currentDate);

    // Your information
    String yourName = "Your Name";
    String studentId = "Your Student ID";
%>

<h1>Profile Page</h1>
<p>
    <strong>Date and Time:</strong> <%= formattedDate %><br>
    <strong>Name:</strong> <%= yourName %><br>
    <strong>Student ID:</strong> <%= studentId %>
</p>

</body>
</html>