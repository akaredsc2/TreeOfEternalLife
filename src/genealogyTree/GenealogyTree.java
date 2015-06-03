package genealogyTree;

import manage.PersonCreator;

import java.sql.*;
import java.util.TreeMap;

public class GenealogyTree {
    private TreeMap<String, Person> leafs;

    public GenealogyTree() {
        leafs = new TreeMap<>();
    }

    public TreeMap<String, Person> getLeafs() {
        return leafs;
    }

    public void add(Person e) {
        this.leafs.put(e.getFullName().getName(), e);
    }

    public void retrieveTree(String username) throws ClassNotFoundException {
        PersonCreator personCreator = new PersonCreator(new TreeMap<>(), username);

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tree", "root", "1234")) {
            if (connection != null) {
                Statement statement = connection.createStatement();

                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM tree.users NATURAL JOIN tree.persons WHERE username = '" + username + "';")) {
                    leafs = new TreeMap<>();

                    while (resultSet.next()) {
                        String name = resultSet.getString("person_name");
                        leafs.put(name, personCreator.retrieve(name));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "GenealogyTree{" +
                "leafs=" + leafs +
                '}';
    }
}
