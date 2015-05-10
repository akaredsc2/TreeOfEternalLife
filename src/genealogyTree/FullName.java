package genealogyTree;

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
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (this.getClass() != otherObject.getClass()) return false;

        FullName other = (FullName) otherObject;

        return this.name.equals(other.name) && this.surname.equals(other.surname) && this.surname.equals(other.surname);
    }
}
