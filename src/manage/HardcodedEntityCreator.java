package manage;

import genealogyTree.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class HardcodedEntityCreator {
    private Queue<Entity> entities  ;

    public HardcodedEntityCreator() {
        this.entities = new PriorityQueue<>();
        entities.add(new Entity(new FullName("Vitaly", "Sharapov"), new LifeTime(new Date(1995)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-1.jpg", "I already told you, get lost!", Sex.MALE)));
        entities.add(new Entity(new FullName("Denis", "Sharapov"), new LifeTime(new Date(1983)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-4.jpg", "Not really", Sex.MALE)));
        entities.add(new Entity(new FullName("Victor", "Sharapov"), new LifeTime(new Date(1964)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-2.jpg", "50 years old ex-military man", Sex.MALE)));
        entities.add(new Entity(new FullName("Alice", "Sharapova"), new LifeTime(new Date(2013)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-3.jpg", "almost two years old child", Sex.FEMALE)));
        entities.add(new Entity(new FullName("Tatajna", "Sharapova"), new LifeTime(new Date(1965)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-5.jpg", "Nurse", Sex.FEMALE)));
    }

    public Entity create() {
        if (this.entities.isEmpty()) {
            System.out.println("No relatives left");
            return new Entity();
        } else {
            System.out.println("Added new relative.");
            System.out.println("Relatives left:" + (entities.size() - 1));
            return entities.poll();
        }
    }

    public boolean hasNext() {
        return !entities.isEmpty();
    }
}