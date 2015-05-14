package genealogyTree;

import java.util.GregorianCalendar;

public class LifeTime {
    private boolean isAlive;
    private GregorianCalendar birthday;
    private GregorianCalendar dayOfDeath;

    public LifeTime(GregorianCalendar birthday) {
        isAlive = true;
        this.birthday = birthday;

        //For comparing alive entities. Definitely going to be dead by that time.
        this.dayOfDeath = new GregorianCalendar(3000, 1, 1);
    }

    public LifeTime(GregorianCalendar birthday, GregorianCalendar dayOfDeath) {
        isAlive = false;
        this.birthday = birthday;
        this.dayOfDeath = dayOfDeath;
    }

    public GregorianCalendar getDayOfDeath() {
        return dayOfDeath;
    }

    public GregorianCalendar getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (this.getClass() != otherObject.getClass()) return false;

        LifeTime other = (LifeTime) otherObject;

        return (this.isAlive == other.isAlive) && this.birthday.equals(other.birthday) && this.dayOfDeath.equals(other.dayOfDeath);
    }
}