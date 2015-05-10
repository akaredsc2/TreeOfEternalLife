package manage;

import genealogyTree.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class HardcodedEntityCreator extends EntityCreator {
    private Queue<Entity> entities  ;

    public HardcodedEntityCreator() {
        this.entities = new LinkedList<>();
        entities.add(new Entity(new FullName("Vitaly", "Sharapov"), new LifeTime(new Date(1995)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-1.jpg", "I already told you, get lost!", Sex.MALE)));
        entities.add(new Entity(new FullName("Denis", "Sharapov"), new LifeTime(new Date(1983)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-4.jpg", "Not really", Sex.MALE)));
        entities.add(new Entity(new FullName("Victor", "Sharapov"), new LifeTime(new Date(1964)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-2.jpg", "50 years old ex-military man", Sex.MALE)));
        entities.add(new Entity(new FullName("Dons", "Kihots"), new LifeTime(new Date(1605), new Date(1505)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-3.jpg", "almost two years old child", Sex.FEMALE)));
        entities.add(new Entity(new FullName("Tatajna", "Sharapova"), new LifeTime(new Date(1965)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-5.jpg", "Nurse", Sex.FEMALE)));
    }

    public Queue<Entity> getEntities() {
        return entities;
    }

    @Override
    public Entity retrieve() {
        if (entities.isEmpty()) {
            System.out.println("No entities left!");
            return null;
        } else {
            System.out.println("Retrieved new entity");
            return entities.poll();
        }
    }
}