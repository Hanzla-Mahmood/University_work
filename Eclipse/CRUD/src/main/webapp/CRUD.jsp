<%@ page import="java.sql.,java.util.,com.example.beans.CrudBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String jdbcURL = "jdbc:mysql://localhost:8080/crud";
    String dbUser = "";
    String dbPassword = "";

    Connection conn = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    } catch (SQLException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }

    String action = request.getParameter("action");
    if (action != null) {
        if (action.equals("create")) {
            
            CrudBean bean = new CrudBean();
            bean.setName(request.getParameter("name"));
            bean.setDescription(request.getParameter("description"));

            String insertQuery = "INSERT INTO crud (name, description) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, bean.getName());
            preparedStatement.setString(2, bean.getDescription());
            preparedStatement.executeUpdate();
        } else if (action.equals("delete")) {
           
            int id = Integer.parseInt(request.getParameter("id"));
            String deleteQuery = "DELETE FROM crud WHERE id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    String selectQuery = "SELECT * FROM crud";
    Statement statement = conn.createStatement();
    ResultSet resultSet = statement.executeQuery(selectQuery);
    List<CrudBean> records = new ArrayList<>();
    while (resultSet.next()) {
        CrudBean record = new CrudBean();
        record.setId(resultSet.getInt("id"));
        record.setName(resultSet.getString("name"));
        record.setDescription(resultSet.getString("description"));
        records.add(record);
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>CRUD Example</title>
</head>
<body>

<h2>CRUD Example</h2>


<form method="post" action="crud.jsp?action=create">
    Name: <input type="text" name="name">
    Description: <input type="text" name="description">
    <input type="submit" value="Create">
</form>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    <% for (CrudBean record : records) { %>
    <tr>
        <td><%= record.getId() %></td>
        <td><%= record.getName() %></td>
        <td><%= record.getDescription() %></td>
        <td>
            <a href="crud.jsp?action=delete&id=<%= record.getId() %>">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>

<%
    if (resultSet != null) {
        resultSet.close();
    }
    if (statement != null) {
        statement.close();
    }
    if (conn != null) {
        conn.close();
    }
%>