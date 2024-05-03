<%@ page import="java.sql.*" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
</head>
<body>
<h1>Worker List</h1>
<table border="1">
    <tr>
        <th>id_worker</th>
        <th>firstname</th>
        <th>lastname</th>
        <th>id_dep</th>
    </tr>
    <% try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise", "root", "1111");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM worker");
        while(rs.next()){%>
    <tr>
        <td>
            <%=rs.getInt("id_worker")%>
        </td>
        <td>
            <%=rs.getString("firstname")%>
        </td>
        <td>
            <%=rs.getString("lastname")%>
        </td>
        <td>
            <%=rs.getInt("id_dep")%>
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
