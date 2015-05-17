package user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HardcodedUserListTest {
    private HardcodedUserList userList;

    @Before
    public void setUp() {
        userList = new HardcodedUserList();
    }

    @Test
    public void testIsReal() throws Exception {
        assertTrue(userList.isReal("user1"));
        assertTrue(userList.isReal("user2"));
        assertTrue(userList.isReal("admin"));

        assertFalse(userList.isReal("fake"));
    }

    @Test
    public void testAuthenticate() throws Exception {
        assertTrue(userList.authenticate("user1", "123"));
        assertTrue(userList.authenticate("user2", "abc"));
        assertTrue(userList.authenticate("admin", "admin"));

        assertFalse(userList.authenticate("user1", "234"));
    }
}