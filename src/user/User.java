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

    public GenealogyTree getTree() {
        return tree;
    }
}
