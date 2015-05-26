package genealogyTree;

import java.util.Calendar;
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
    public String toString() {
        return "LifeTime{" +
                "isAlive=" + isAlive +
                ", birthday=" + birthday.get(Calendar.YEAR) + " " + birthday.get(Calendar.MONTH) + " " + birthday.get(Calendar.DAY_OF_MONTH) +
                ", dayOfDeath=" + dayOfDeath.get(Calendar.YEAR) + " " + dayOfDeath.get(Calendar.MONTH) + " " + birthday.get(Calendar.DAY_OF_WEEK) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LifeTime)) return false;

        LifeTime lifeTime = (LifeTime) o;

        if (isAlive != lifeTime.isAlive) return false;
        if (birthday != null ? !birthday.equals(lifeTime.birthday) : lifeTime.birthday != null) return false;
        return !(dayOfDeath != null ? !dayOfDeath.equals(lifeTime.dayOfDeath) : lifeTime.dayOfDeath != null);

    }

    @Override
    public int hashCode() {
        int result = (isAlive ? 1 : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (dayOfDeath != null ? dayOfDeath.hashCode() : 0);
        return result;
    }
}