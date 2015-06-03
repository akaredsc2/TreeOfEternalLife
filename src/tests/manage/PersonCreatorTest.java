package manage;

import genealogyTree.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class PersonCreatorTest {
    private PersonCreator personCreator;

    @Before
    public void setUp() throws Exception {
        personCreator = new PersonCreator(new TreeMap<>(), "admin");
    }

    @Test
    public void testRetrieve() throws Exception {
        Person person = new Person(new FullName("Vitaly", "Sharapov"), new LifeTime(new GregorianCalendar(1995, 8, 1)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("http:/img34", "about me", Sex.MALE));
        assertTrue(person.equals(personCreator.retrieve("Vitaly")));
    }
}