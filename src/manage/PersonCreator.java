package manage;

import genealogyTree.*;

import java.util.*;

public class PersonCreator implements PersonManager {
    private Map<String, String[]> rawPerson;

    public PersonCreator(Map<String, String[]> rawPerson) {
        this.rawPerson = rawPerson;
    }

    @Override
    public Person retrieve() {
        if (isPerson(rawPerson)) {
            FullName name = new FullName(rawPerson.get("name")[0], rawPerson.get("surname")[0]);

            LifeTime lifeTime;
            GregorianCalendar birthday = parseDate(rawPerson.get("birthday")[0]);

            if (rawPerson.get("is-alive")[0].equals("alive")) {
                lifeTime = new LifeTime(birthday);
            } else {
                GregorianCalendar dayOfDeath = parseDate(rawPerson.get("day-of-death")[0]);
                lifeTime = new LifeTime(birthday, dayOfDeath);
            }

            AdditionalInfo additionalInfo = new AdditionalInfo(rawPerson.get("photo-url")[0], rawPerson.get("about")[0], Sex.valueOf(rawPerson.get("sex")[0].toUpperCase()));

            return new Person(name, lifeTime, new LinkedList<>(), new LinkedList<>(), additionalInfo);
        } else {
            return null;
        }
    }

    @Override
    public boolean check(Person person) {
        return false;
    }

    @Override
    public Person create() {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public Person delete(Person person) {
        return null;
    }

    public boolean isPerson(Map<String, String[]> suspect) {
        return !(suspect.get("name")[0].equals("")
                || suspect.get("surname")[0].equals("")
                || suspect.get("birthday")[0].equals("")
        );
    }

    public GregorianCalendar parseDate(String string) {
        if(string.length() < 10) throw new Error(); //Regexp in from won't allow that to happen

        int[] intDate = new int[3];

        intDate[0] = Integer.parseInt(string.subSequence(0, 4).toString());
        intDate[1] = Integer.parseInt(string.subSequence(5, 7).toString());
        intDate[2] = Integer.parseInt(string.subSequence(8, 10).toString());

        return new GregorianCalendar(intDate[0], intDate[1], intDate[2]);
    }
}