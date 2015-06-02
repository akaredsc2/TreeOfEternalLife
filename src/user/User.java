package user;

import genealogyTree.GenealogyTree;

public class User {
    private String username;
    private String password;

    private GenealogyTree tree;

    public User() {
        this.tree = new GenealogyTree();
    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public GenealogyTree getTree() {
        return tree;
    }

    //todo clean up!
    public boolean comparePassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tree=" + tree +
                '}';
    }
}
