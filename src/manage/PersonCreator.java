package manage;

import genealogyTree.*;

import java.sql.*;
import java.util.*;

public class PersonCreator implements PersonManager {
    private Map<String, String[]> rawPerson;
    private String currentUser;

    public PersonCreator(Map<String, String[]> rawPerson, String currentUser) {
        this.rawPerson = rawPerson;
        this.currentUser = currentUser;
    }

    @Override
    public Person retrieve(String name) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tree", "root", "1234")) {
            if (connection != null) {
                Statement statement = connection.createStatement();

                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM persons WHERE person_name = '" + name + "';")) {
                    if (resultSet.next()) {
                        String personName = resultSet.getString("person_name");
                        String personSurname = resultSet.getString("person_surname");

                        String photoURL = resultSet.getString("person_photo");
                        String about = resultSet.getString("person_about");
                        Sex sex = Sex.valueOf(resultSet.getString("person_sex"));

                        GregorianCalendar birth = parseDate(resultSet.getString("person_birth"));
                        if(resultSet.getString("person_death") != null) {
                            GregorianCalendar death = parseDate(resultSet.getString("person_death"));
                            return new Person(new FullName(personName, personSurname), new LifeTime(birth, death), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo(photoURL, about, sex));
                        } else {
                            return new Person(new FullName(personName, personSurname), new LifeTime(birth), new LinkedList<>(), new LinkedList<>(), new AdditionalInfo(photoURL, about, sex));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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

    public Person parsePerson() throws ClassNotFoundException {
        if (isPerson(rawPerson)) {
            FullName name = new FullName(rawPerson.get("name")[0], rawPerson.get("surname")[0]);

            LifeTime lifeTime;
            GregorianCalendar birthday = parseDate(rawPerson.get("birthday")[0]);

            if (rawPerson.get("is-alive")[0].equals("alive")) {
                lifeTime = new LifeTime(birthday);
            } else {
                String dummyDeathDate = new String("3000-01-01");

                GregorianCalendar dayOfDeath = parseDate(dummyDeathDate);

                lifeTime = new LifeTime(birthday, dayOfDeath);
            }

            AdditionalInfo additionalInfo = new AdditionalInfo(rawPerson.get("photo-url")[0], rawPerson.get("about")[0], Sex.valueOf(rawPerson.get("sex")[0].toUpperCase()));

            Person person = new Person(name, lifeTime, new LinkedList<>(), new LinkedList<>(), additionalInfo);

            person.addToUser(currentUser);

            return person;
        } else {
            return null;
        }
    }

    public boolean isPerson(Map<String, String[]> suspect) {
        return !(suspect.get("name")[0].equals("")
                || suspect.get("surname")[0].equals("")
                || suspect.get("birthday")[0].equals("")
        );
    }

    public GregorianCalendar parseDate(String string) {
        if (string.length() < 10) throw new Error(); //Regexp in from won't allow that to happen

        int[] intDate = new int[3];

        intDate[0] = Integer.parseInt(string.subSequence(0, 4).toString());
        intDate[1] = Integer.parseInt(string.subSequence(5, 7).toString());
        intDate[2] = Integer.parseInt(string.subSequence(8, 10).toString());

        return new GregorianCalendar(intDate[0], intDate[1], intDate[2]);
    }
}