package user;

import java.util.TreeMap;

public class HardcodedUserList {
    private TreeMap<String, String> allUsers;

    public HardcodedUserList() {
        allUsers.put("user1", "123");
        allUsers.put("user2", "abc");
        allUsers.put("admin", "admin");
    }

    public boolean isReal(String user) {
        return allUsers.containsKey(user);
    }

    public boolean authentiticate(String user, String password) {
        return isReal(user) && allUsers.get(user).equals(password);
    }
}