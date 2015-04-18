package genealogyTree;

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

    public Entity(FullName fullName, LifeTime lifeTime, Collection<Entity> parents, Collection<Entity> children, AdditionalInfo info) {
        this();
        this.fullName = fullName;
        this.lifeTime = lifeTime;
        this.parents = parents;
        this.children = children;
        this.info = info;
    }

    public Collection<Entity> getParents() {
        return parents;
    }

    public Collection<Entity> getChildren() {
        return children;
    }

    public void addChild(Entity child) {
        this.children.add(child);
    }

    //Some warning here while commiting.
    public int compareTo(Entity other) {
        return 0;
    }

    public void addParent(Entity parent) {
        this.parents.add(parent);
    }

    public boolean hasParent(Entity parent) {
        return getParents().contains(parent);
    }

    public boolean hasChild(Entity child) {
        return getChildren().contains(child);
    }
}
