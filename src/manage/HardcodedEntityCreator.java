package manage;

import genealogyTree.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Queue;

public class HardcodedEntityCreator implements EntityManager {
    private Queue<Entity> entities;

    //TODO make it access database
    //auth from servlet or something
    //java ee tutorial servlets

    public HardcodedEntityCreator() {
        this.entities = new LinkedList<>();
<<<<<<< HEAD
        entities.add(new Entity(new FullName("Dons", "Kihots"), new LifeTime(new GregorianCalendar(1605, 5, 19), new GregorianCalendar(1505, 5, 19)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-3.jpg", "almost two years old child", Sex.FEMALE)));
        entities.add(new Entity(new FullName("Vitaly", "Sharapov"), new LifeTime(new GregorianCalendar(1995, 8, 1)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-1.jpg", "I already told you, get lost!", Sex.MALE)));
        entities.add(new Entity(new FullName("Denis", "Sharapov"), new LifeTime(new GregorianCalendar(1985, 5, 19)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-4.jpg", "Not really", Sex.MALE)));
        entities.add(new Entity(new FullName("Victor", "Sharapov"), new LifeTime(new GregorianCalendar(1965, 2, 24)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-2.jpg", "50 years old ex-military man", Sex.MALE)));
        entities.add(new Entity(new FullName("Tatajna", "Sharapova"), new LifeTime(new GregorianCalendar(1963, 3, 8)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-5.jpg", "Nurse", Sex.FEMALE)));
=======

        entities.add(new Entity(new FullName("Vitaly", "Sharapov"), new LifeTime(new Date(1995)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-1.jpg", "I already told you, get lost!", Sex.MALE)));
        entities.add(new Entity(new FullName("Denis", "Sharapov"), new LifeTime(new Date(1983)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-4.jpg", "Not really", Sex.MALE)));
        entities.add(new Entity(new FullName("Victor", "Sharapov"), new LifeTime(new Date(1964)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-2.jpg", "50 years old ex-military man", Sex.MALE)));
        entities.add(new Entity(new FullName("Dons", "Kihots"), new LifeTime(new Date(1605), new Date(1505)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-3.jpg", "almost two years old child", Sex.FEMALE)));
        entities.add(new Entity(new FullName("Tatajna", "Sharapova"), new LifeTime(new Date(1965)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-5.jpg", "Nurse", Sex.FEMALE)));
>>>>>>> origin/master
    }

    public Queue<Entity> getEntities() {
        return entities;
    }

    //TODO Get data from web app
    @Override
    public Entity retrieve() {
        if (entities.isEmpty()) {
            return null;
        } else {
            return entities.poll();
        }
    }

    @Override
    public boolean check(Entity entity) {
        return entity.getLifeTime().getBirthday().compareTo(entity.getLifeTime().getDayOfDeath()) < 0;
    }

    @Override
    public Entity create() {
        Entity entity = retrieve();

        if (check(entity)) {
            return entity;
        } else {
            throw new IllegalArgumentException("[STANDARD_EXCEPTION] Check failed! Birthday after his own death! Kill him with holy water!");
        }
    }

    @Override
    public Entity update(Entity entity) {
        return entity;
    }

    @Override
    public Entity delete(Entity entity) {
        return null;
    }
}