package manage;

import genealogyTree.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Queue;

public class HardcodedPersonCreator implements PersonManager {
    private Queue<Person> entities;

    //TODO make it access database
    //auth from servlet or something
    //java ee tutorial servlets

    public HardcodedPersonCreator() {
        this.entities = new LinkedList<>();

        entities.add(new Person(new FullName("Dons", "Kihots"), new LifeTime(new GregorianCalendar(1605, 5, 19), new GregorianCalendar(1505, 5, 19)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-3.jpg", "almost two years old child", Sex.FEMALE)));
        entities.add(new Person(new FullName("Vitaly", "Sharapov"), new LifeTime(new GregorianCalendar(1995, 8, 1)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-1.jpg", "I already told you, get lost!", Sex.MALE)));
        entities.add(new Person(new FullName("Denis", "Sharapov"), new LifeTime(new GregorianCalendar(1985, 5, 19)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-4.jpg", "Not really", Sex.MALE)));
        entities.add(new Person(new FullName("Victor", "Sharapov"), new LifeTime(new GregorianCalendar(1965, 2, 24)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-2.jpg", "50 years old ex-military man", Sex.MALE)));
        entities.add(new Person(new FullName("Tatajna", "Sharapova"), new LifeTime(new GregorianCalendar(1963, 3, 8)), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo("images/Untitled-5.jpg", "Nurse", Sex.FEMALE)));
    }

    public Queue<Person> getEntities() {
        return entities;
    }

    @Override
    public Person retrieve(String name) throws ClassNotFoundException {
        return null;
    }

    @Override
    public boolean check(Person person) {
        return person.getLifeTime().getBirthday().compareTo(person.getLifeTime().getDayOfDeath()) < 0;
    }

    @Override
    public Person create() {
        Person person = null;
        try {
            person = retrieve("random");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (check(person)) {
            return person;
        } else {
            throw new IllegalArgumentException("[STANDARD_EXCEPTION] Check failed! Birthday after his own death! Kill him with holy water!");
        }
    }

    @Override
    public Person update(Person person) {
        return person;
    }

    @Override
    public Person delete(Person person) {
        return null;
    }
}