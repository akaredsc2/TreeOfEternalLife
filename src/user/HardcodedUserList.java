package user;

import java.util.TreeMap;

public class HardcodedUserList {
    private TreeMap<String, User> allUsers;

    public HardcodedUserList() {
        allUsers = new TreeMap<>();

        allUsers.put("user1", new User("user1", "123"));
        allUsers.put("user2", new User("user2", "abc"));
        allUsers.put("admin", new User("admin", "admin"));
    }

    public boolean isReal(String user) {
        return allUsers.containsKey(user);
    }

    public boolean authenticate(String user, String password) {
        return isReal(user) && allUsers.get(user).comparePassword(password);
    }
}