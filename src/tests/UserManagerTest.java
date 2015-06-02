import org.junit.Before;
import org.junit.Test;
import user.User;
import user.UserManager;

import static org.junit.Assert.*;

public class UserManagerTest {
    private UserManager userManager;

    @Before
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testAuthenticate() throws Exception {
        assertTrue(userManager.authenticate(new User("user1", "123")));
        assertTrue(userManager.authenticate(new User("AnnaKravchenko", "1111")));

        assertFalse(userManager.authenticate(new User("user1", "124")));
    }
}