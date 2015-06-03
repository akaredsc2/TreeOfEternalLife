package manage;

import genealogyTree.Person;

public interface PersonManager {
    Person retrieve(String name) throws ClassNotFoundException;

    boolean check(Person person);

    Person create();

    Person update(Person person);

    Person delete(Person person);
}
