package genealogyTree;

import exceptions.RelativesException;

import java.util.Collection;
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

    @Override
    public String toString() {
        return "Entity{" +
                "fullName=" + fullName +
                ", lifeTime=" + lifeTime +
                ", parents=" + parents +
                ", children=" + children +
                ", info=" + info +
                '}';
    }

    public Entity(FullName fullName, LifeTime lifeTime, Collection<Entity> parents, Collection<Entity> children, AdditionalInfo info) {
        this();
        this.fullName = fullName;
        this.lifeTime = lifeTime;
        this.parents = parents;
        this.children = children;
        this.info = info;
    }

    public void addChild(Entity child) throws RelativesException {
        if(child.lifeTime.getBirthday() > this.lifeTime.getBirthday()) {
            throw new RelativesException("[CUSTOMEXCEPTION]Child is older than parent!");
        }
        this.children.add(child);
    }

    public int compareTo(Entity other) {
        return 0;
    }

    public void addParent(Entity parent) throws RelativesException {
        if(this.parents.size() >= 2) {
            throw new RelativesException("[CUSTOMEXCEPTION]Current entity already has 2 parents!");
        } else if(!this.parents.isEmpty() && this.parents.iterator().next().info.getSex() == parent.info.getSex()) {
            throw new RelativesException("[CUSTOMEXCEPTION]WE ARE NOT TOLERANT!");
        } else if(this.lifeTime.getBirthday() > parent.lifeTime.getBirthday()) {
            throw new RelativesException("[CUSTOMEXCEPTION]Parent is younger than child!");
        }
        this.parents.add(parent);
    }
}