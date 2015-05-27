import static org.junit.Assert.*;

import manage.HardcodedPersonCreator;
import org.junit.Before;
import org.junit.Test;

public class HardcodedPersonCreatorTest {
    private final HardcodedPersonCreator hard = new HardcodedPersonCreator();
    private int cap;

    @Before
    public void setUp() {
        cap = hard.getEntities().size();
    }

    @Test
    public void testRetrieve() throws Exception {
        for (int i = 0; i < cap; i++) {
            assertNotNull(hard.retrieve());
        }
    }

    @Test
    public void testCheck() {
        assertFalse(hard.check(hard.retrieve()));
        for (int i = 0; i < cap - 1; i++) {
            assertTrue(hard.check(hard.retrieve()));
        }
    }

    @Test
    public void testCreateNormal() {
        hard.retrieve();
        for (int i = 0; i < cap - 1; i++) {
            assertNotNull(hard.create());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateException() {
        hard.create();
    }
}