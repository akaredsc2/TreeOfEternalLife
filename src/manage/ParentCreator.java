package manage;

import genealogyTree.Entity;

public class ParentCreator extends EntityCreator implements Replenishable {
    @Override
    public void replenish(final Entity parent, Entity child) {
        child.addParent(parent);
        parent.addChild(child);
    }
}
