package manage;

import genealogyTree.Person;

public interface EntityManager {
    Person retrieve();

    boolean check(Person person);

    Person create();

    Person update(Person person);

    Person delete(Person person);
}