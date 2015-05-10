package genealogyTree;

import exceptions.RelativesException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class EntityTest {
    private ArrayList<Entity> entities;

    @Before
    public void setUp() throws Exception {
        entities = new ArrayList<>();

        entities.add(new Entity(new FullName("Vitaly", "Sharapov"), new LifeTime(new Date(1995)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-1.jpg", "I already told you, get lost!", Sex.MALE)));
        entities.add(new Entity(new FullName("Denis", "Sharapov"), new LifeTime(new Date(1983)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-4.jpg", "Not really", Sex.MALE)));
        entities.add(new Entity(new FullName("Vitaly", "Sharapov"), new LifeTime(new Date(1995)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-1.jpg", "I already told you, get lost!", Sex.MALE)));
        entities.add(new Entity(new FullName("Vitaly", "Sharapoff"), new LifeTime(new Date(1995)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-1.jpg", "I already told you, get lost!", Sex.MALE)));
        entities.add(new Entity(new FullName("Tatajna", "Sharapova"), new LifeTime(new Date(1965)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-5.jpg", "Nurse", Sex.FEMALE)));
        entities.add(new Entity(new FullName("Victor", "Sharapov"), new LifeTime(new Date(1964)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-2.jpg", "50 years old ex-military man", Sex.MALE)));
    }

    @Test
    public void testCompareTo() throws Exception {
        assertEquals(-1, entities.get(0).compareTo(entities.get(1)));
        assertEquals(1, entities.get(1).compareTo(entities.get(0)));
    }

    @Test
    public void testEquals() throws Exception {
        assertFalse(entities.get(0).equals(entities.get(1)));
        assertFalse(entities.get(1).equals(entities.get(0)));

        assertTrue(entities.get(0).equals(entities.get(2)));
        assertTrue(entities.get(2).equals(entities.get(0)));

        assertFalse(entities.get(2).equals(entities.get(3)));
        assertFalse(entities.get(3).equals(entities.get(2)));
    }

    @Test
    public void testAddChild() throws Exception {
        addChildToParent(entities.get(0), entities.get(1));
        addChildToParent(entities.get(2), entities.get(1));
        addChildToParent(entities.get(3), entities.get(1));
    }

    @Test
    public void testAddParent() throws Exception {
        for (int i = 1; i < entities.size(); i++) {
            addParentToChild(entities.get(i), entities.get(0));
        }
    }

    public void addParentToChild(Entity parent, Entity child) {
        try {
            child.addParent(parent);
            assertTrue(child.getParents().contains(parent));
        } catch (RelativesException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addChildToParent(Entity child, Entity parent) {
        try {
            parent.addChild(child);
            assertTrue(parent.getChildren().contains(child));
        } catch (RelativesException e) {
            System.out.println(e.getMessage());
        }
    }
}