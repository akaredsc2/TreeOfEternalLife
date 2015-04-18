package genealogyTree;

import java.util.Date;

/**
 * Created by Виталий on 4/18/2015.
 */
public class LifeTime {
    private boolean isAlive;
    private Date birthday;
    private Date deathday;

    public LifeTime(Date birthday) {
        isAlive = true;
        this.birthday = birthday;
    }

    public LifeTime(Date birthday, Date deathday) {
        isAlive = false;
        this.birthday = birthday;
        this.deathday = deathday;
    }
}
