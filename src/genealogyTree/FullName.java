package genealogyTree;

/**
 * Created by Виталий on 4/3/2015.
 */
public class FullName {
    private String name;
    private String surname;
    private String secondName;

    public FullName(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public FullName(String name, String surname, String secondName) {
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {

        return name;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
