package genealogyTree;

import java.awt.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Виталий on 4/3/2015.
 */
public class Entity {
    private FullName fullName;
    private java.util.Date birthDay;
    private boolean isAlive;
    private java.util.Date deathDay;
    private java.util.Collection<Entity> parents;
    private java.util.Collection<Entity> children;

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

    public Boolean isSex() {
        return sex;
    }

    private java.awt.Image photo;
    private String shortInfo;
    private Boolean sex;

    public Entity(FullName fullName, Date birthDay, boolean isAlive, Date deathDay, Collection<Entity> parents, Collection<Entity> children, Image photo, String shortInfo, boolean sex) {
    }

    public void changeName(FullName newName) {
    }

    public void endLife(Date deathDay) {
    }

    public void addChild(Entity child) {
    }
}
