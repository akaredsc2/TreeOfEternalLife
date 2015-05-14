package manage;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HardcodedEntityCreatorTest {
    private final HardcodedEntityCreator hard = new HardcodedEntityCreator();
    private int cap;

    @Before
    public void setUp() throws Exception {
        cap = hard.getEntities().size();
    }

    @Test
    public void testRetrieve() throws Exception {
        System.out.println("testRetrieve");
        for (int i = 0; i < cap; i++) {
            assertNotNull(hard.retrieve());
        }
        System.out.println("---");
    }

    // Does every method need to have some kind of assert in it?
    @Test
    public void testCheck() {
        System.out.println("testCheck");
        for (int i = 0; i < cap; i++) {
            try {
                hard.check(hard.retrieve());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("---");
    }

    @Test
    public void testCreate() {
        System.out.println("testCreate");
        for (int i = 0; i < cap; i++) {
            assertNotNull(hard.create());
        }
        System.out.println("---");
    }
}