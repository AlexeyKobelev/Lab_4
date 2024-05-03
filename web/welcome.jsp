<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>Departments List</h1>
<table border="1">
    <tr>
        <th>id</th>
        <th>dep_name</th>
    </tr>
    <% try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise", "root", "1111");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM departments");
        while(rs.next()){%>
    <tr>
        <td>
            <%=rs.getInt("id")%>
        </td>
        <td>
            <%=rs.getString("dep_name")%>
        </td>
    </tr>
    <%
            }rs.close();
            stmt.close();
            conn.close();}
        catch (SQLException e) {
            e.printStackTrace();
        }
    %>

</table>
</body>
</html>
