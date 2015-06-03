package genealogyTree;

import exceptions.RelativesException;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

public class Person implements Comparable<Person> {
    private FullName fullName;

    private LifeTime lifeTime;

    private Collection<Person> parents;

    private Collection<Person> children;
    private AdditionalInfo info;

    public Person() {
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
    }

    public Person(FullName fullName, LifeTime lifeTime, Collection<Person> parents, Collection<Person> children, AdditionalInfo info) {
        this();
        this.fullName = fullName;
        this.lifeTime = lifeTime;
        this.parents = parents;
        this.children = children;
        this.info = info;
    }

    public FullName getFullName() {
        return fullName;
    }

    public LifeTime getLifeTime() {
        return lifeTime;
    }

    public Collection<Person> getParents() {
        return parents;
    }

    public Collection<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) throws RelativesException {
        if (this.equals(child)) {
            throw new RelativesException("A person can't be child to itself!");
        }
        if (this.compareTo(child) > 0) {
            throw new RelativesException("Child is older or same age as parent!");
        }
        if (this.children.contains(child)) {
            throw new RelativesException("Already in children list!");
        }
        this.children.add(child);
    }

    public void addParent(Person parent) throws RelativesException {
        if (this.equals(parent)) {
            throw new RelativesException("A person can't be parent to itself!");
        }
        if (this.parents.size() >= 2) {
            throw new RelativesException("This person already has 2 parents!");
        } else if (!this.parents.isEmpty() && this.parents.iterator().next().info.getSex() == parent.info.getSex()) {
            throw new RelativesException("WE ARE NOT TOLERANT!");
        } else if (this.compareTo(parent) <= 0) {
            throw new RelativesException("Parent is younger than child!");
        }
        this.parents.add(parent);
    }

    public void addToUser(String username) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tree", "root", "1234")) {
            if (connection != null) {
                Statement statement = connection.createStatement();

                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "';")) {
                    if (resultSet.next()) {
                        int userID = resultSet.getInt("user_id");

                        if (lifeTime.isAlive()) {
                            statement.executeUpdate("INSERT INTO tree.persons (person_name, person_surname, user_id, person_birth, person_photo, person_about, person_sex) VALUES ('"
                                    + fullName.getName() + "', '" + fullName.getSurname() + "', '"
                                    + userID + "', '"
                                    + lifeTime.getBirthdayString() + "', '"
                                    + info.getPhotoURL() + "', '" + info.getAbout() + "', '" + info.getSex().name() + "'   )");
                        } else {
                            statement.executeUpdate("INSERT INTO tree.persons (person_name, person_surname, user_id, person_birth, person_death, person_photo, person_about, person_sex) VALUES ('"
                                    + fullName.getName() + "', '" + fullName.getSurname() + "', '"
                                    + userID + "', '"
                                    + lifeTime.getBirthdayString() + "', '" + lifeTime.getDayOfDeathString() + "', '"
                                    + info.getPhotoURL() + "', '" + info.getAbout() + "', '" + info.getSex().name() + "'   )");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Person other) {
        return this.lifeTime.getBirthday().compareTo(other.lifeTime.getBirthday());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (fullName != null ? !fullName.equals(person.fullName) : person.fullName != null) return false;
        if (lifeTime != null ? !lifeTime.equals(person.lifeTime) : person.lifeTime != null) return false;
        if (parents != null ? !parents.equals(person.parents) : person.parents != null) return false;
        return !(children != null ? !children.equals(person.children) : person.children != null);

    }

    @Override
    public int hashCode() {
        int result = fullName != null ? fullName.hashCode() : 0;
        result = 31 * result + (lifeTime != null ? lifeTime.hashCode() : 0);
        result = 31 * result + (parents != null ? parents.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName=" + fullName +
                ", lifeTime=" + lifeTime +
                ", parents=" + parents +
                ", children=" + children +
                ", info=" + info +
                '}';
    }
}