package genealogyTree;

import java.util.Date;

public class LifeTime {
    private boolean isAlive;
    private Date birthday;
    private Date dayOfDeath;

    public LifeTime(Date birthday) {
        isAlive = true;
        this.birthday = birthday;
        this.dayOfDeath = new Date(0);
    }

    public LifeTime(Date birthday, Date dayOfDeath) {
        isAlive = false;
        this.birthday = birthday;
        this.dayOfDeath = dayOfDeath;
    }

    @Override
    public String toString() {
        return "LifeTime{" +
                "isAlive=" + isAlive +
                ", birthday=" + birthday +
                ", dayOfDeath=" + dayOfDeath +
                '}';
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (this.getClass() != otherObject.getClass()) return false;

        LifeTime other = (LifeTime) otherObject;

        return (this.isAlive == other.isAlive) && this.birthday.equals(other.birthday) && this.dayOfDeath.equals(other.dayOfDeath);
    }

    public long getBirthday() {
        return birthday.getTime();
    }
}