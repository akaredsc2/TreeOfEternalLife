package user;

import java.sql.*;

public class UserManager {
    public boolean authenticate(User user) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tree", "root", "1234")) {
            if (connection != null) {
                Statement statement = connection.createStatement();

                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM tree.users WHERE username='" + user.getUsername() + "';")) {
                    if (resultSet.next() && resultSet.getString("password").equals(user.getPassword())) {
                        return true;
                    }
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
