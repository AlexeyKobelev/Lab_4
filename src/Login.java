import model.UserEntity;
import model.Worker;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(name = "/Login", urlPatterns = "/Login")
public class Login extends HttpServlet {

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");


    }*/

    public UserEntity checkUser(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "1111");
            try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE name = ? AND password = ?");) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet res = stmt.executeQuery();
                if (res.next()) {
                    UserEntity user = new UserEntity();
                    user.setId(res.getInt("id"));
                    user.setName(res.getString("name"));
                    user.setPassword(res.getString("password"));
                    user.setRole(res.getString("role"));
                    return user;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");


        UserEntity user = checkUser(name, pass);
        if(user != null){
            if(user.getRole().equals("admin")){
                response.sendRedirect("adminPage.jsp");
            } else {
                response.sendRedirect("welcome.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
