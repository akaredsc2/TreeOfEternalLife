package genealogyTree;

import exceptions.RelativesException;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Entity implements Comparable<Entity> {
    private FullName fullName;

    private LifeTime lifeTime;

    private Collection<Entity> parents;
    private Collection<Entity> children;

    private AdditionalInfo info;

    public Entity() {
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
    }

    public Entity(FullName fullName, LifeTime lifeTime, Collection<Entity> parents, Collection<Entity> children, AdditionalInfo info) {
        this();
        this.fullName = fullName;
        this.lifeTime = lifeTime;
        this.parents = parents;
        this.children = children;
        this.info = info;
    }

    public Collection<Entity> getChildren() {
        return children;
    }

    public Collection<Entity> getParents() {
        return parents;
    }

    public LifeTime getLifeTime() {
        return lifeTime;
    }

    //TODO Advanced comparing e.g. different families can't have same children
    public void addChild(Entity child) throws RelativesException {
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

    public void addParent(Entity parent) throws RelativesException {
        if (this.equals(parent)) {
            throw new RelativesException("A person can't be parent to itself!");
        }
        if (this.parents.size() >= 2) {
            throw new RelativesException("This person already has 2 parents!");
        } else if (!this.parents.isEmpty() && this.parents.iterator().next().info.getSex() == parent.info.getSex()) {
            throw new RelativesException("WE ARE NOT TOLERANT!");
        } else if (this.compareTo(parent) <= 0 ) {
            throw new RelativesException("Parent is younger than child!");
        }
        this.parents.add(parent);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (this.getClass() != otherObject.getClass()) return false;

        Entity other = (Entity) otherObject;

        return this.fullName.equals(other.fullName)
                && this.lifeTime.equals(other.lifeTime)
                && this.parents.equals(other.parents)
                && this.children.equals(other.children);
    }

    @Override
    public int compareTo(Entity other) {
        return this.lifeTime.getBirthday().compareTo(other.lifeTime.getBirthday());
    }
}