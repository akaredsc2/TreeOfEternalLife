package genealogyTree;

import com.sun.istack.internal.NotNull;

import java.awt.*;
import java.util.Collection;
import java.util.Date;

public class Entity implements Comparable<Entity> {
    private FullName fullName;
    
    private Date birthDay;
    private boolean isAlive;
    private Date deathDay;
    
    private Collection<Entity> parents;
    private Collection<Entity> children;
    
    private Image photo;
    private String shortInfo;

    private Boolean sex;

    public Entity() {
        super();
    }

    public Entity(FullName fullName, Date birthDay, boolean isAlive, Date deathDay, Collection<Entity> parents, Collection<Entity> children, Image photo, String shortInfo, boolean sex) {}

    public FullName getFullName() {
        return fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Date getDeathDay() {
        return deathDay;
    }

    public Collection<Entity> getParents() {
        return parents;
    }

    public Collection<Entity> getChildren() {
        return children;
    }

    public Image getPhoto() {
        return photo;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public Boolean getSex() {
        return sex;
    }

    public void changeName(FullName newName) {
    }

    public void endLife(Date deathDay) {
    }

    public void addChild(Entity child) {
    }

    //Some warning here while commiting.
    public int compareTo(Entity other) {
        return 0;
    }
}
