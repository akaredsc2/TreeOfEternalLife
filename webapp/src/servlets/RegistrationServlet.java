package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        final String username = request.getParameter("username");
        final String password1 = request.getParameter("password1");
        final String password2 = request.getParameter("password2");

        if (!password1.equals(password2)) {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        } else {
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tree", "root", "1234")) {
                if (connection != null) {
                    Statement statement = connection.createStatement();

                    try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "';")) {
                        if (!resultSet.next()) {
                            statement.executeUpdate("INSERT INTO users VALUES ('" + username + "', '" + password1 + "');");

                            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        } else {
                            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
                        }
                    }
                } else {
                    getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}