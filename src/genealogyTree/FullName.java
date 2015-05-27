package genealogyTree;

public class FullName {
    private String name;
    private String surname;

    public FullName(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FullName)) return false;

        FullName fullName = (FullName) o;

        if (name != null ? !name.equals(fullName.name) : fullName.name != null) return false;
        return !(surname != null ? !surname.equals(fullName.surname) : fullName.surname != null);

    }

    @Override
    public String toString() {
        return "FullName{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }
}
