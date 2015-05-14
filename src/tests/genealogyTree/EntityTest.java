package genealogyTree;

import exceptions.RelativesException;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class EntityTest {
    private TreeMap<String, Entity> entities;

    @Before
    public void setUp() throws Exception {
        entities = new TreeMap<>();

        entities.put("Vitaly1", new Entity(new FullName("Vitaly", "Sharapov"), new LifeTime(new GregorianCalendar(1995, 8, 1)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-1.jpg", "I already told you, get lost!", Sex.MALE)));
        entities.put("Denis", new Entity(new FullName("Denis", "Sharapov"), new LifeTime(new GregorianCalendar(1983, 5, 19)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-4.jpg", "Not really", Sex.MALE)));
        entities.put("Vitaly2", new Entity(new FullName("Vitaly", "Sharapov"), new LifeTime(new GregorianCalendar(1995, 8, 1)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-1.jpg", "I already told you, get lost!", Sex.MALE)));
        entities.put("Vitaly3", new Entity(new FullName("Vitaly", "Sharapoff"), new LifeTime(new GregorianCalendar(1995, 8, 1)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-1.jpg", "I already told you, get lost!", Sex.MALE)));
        entities.put("Tatjana", new Entity(new FullName("Tatjana", "Sharapova"), new LifeTime(new GregorianCalendar(1963, 3, 8)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-5.jpg", "Nurse", Sex.FEMALE)));
        entities.put("Victor", new Entity(new FullName("Victor", "Sharapov"), new LifeTime(new GregorianCalendar(1965, 2, 24)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-2.jpg", "50 years old ex-military man", Sex.MALE)));
    }

    @Test
    public void testCompareTo() throws Exception {
        assertEquals(1, entities.get("Vitaly1").compareTo(entities.get("Denis")));
        assertEquals(-1, entities.get("Denis").compareTo(entities.get("Vitaly1")));
    }

    @Test
    public void testEquals() throws Exception {
        assertFalse(entities.get("Vitaly1").equals(entities.get("Denis")));
        assertFalse(entities.get("Denis").equals(entities.get("Vitaly1")));

        assertTrue(entities.get("Vitaly1").equals(entities.get("Vitaly2")));
        assertTrue(entities.get("Vitaly2").equals(entities.get("Vitaly1")));

        assertFalse(entities.get("Vitaly2").equals(entities.get("Vitaly3")));
        assertFalse(entities.get("Vitaly3").equals(entities.get("Vitaly2")));
    }

    @Test
    public void testAddChildNormal() throws Exception {
        addChildToParent(entities.get("Vitaly1"), entities.get("Denis"));
        addChildToParent(entities.get("Vitaly3"), entities.get("Denis"));
    }

    @Test(expected = RelativesException.class)
    public void testAddChildException() throws RelativesException {
        addChildToParent(entities.get("Vitaly1"), entities.get("Denis"));
        addChildToParent(entities.get("Vitaly2"), entities.get("Denis"));
    }

    @Test
    public void testAddParentNormal() throws Exception {
        addParentToChild(entities.get("Victor"), entities.get("Vitaly1"));
        addParentToChild(entities.get("Tatjana"), entities.get("Vitaly1"));

        addParentToChild(entities.get("Victor"), entities.get("Denis"));
        addParentToChild(entities.get("Tatjana"), entities.get("Denis"));
    }

    @Test(expected = RelativesException.class)
    public void testAddParentException() throws RelativesException{
        addParentToChild(entities.get("Victor"), entities.get("Vitaly1"));
        addParentToChild(entities.get("Denis"), entities.get("Vitaly1"));
    }

    public void addParentToChild(Entity parent, Entity child) throws RelativesException {
        child.addParent(parent);
        assertTrue(child.getParents().contains(parent));
    }

    public void addChildToParent(Entity child, Entity parent) throws RelativesException {
        parent.addChild(child);
        assertTrue(parent.getChildren().contains(child));
    }
}