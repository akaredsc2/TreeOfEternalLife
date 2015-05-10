package manage;

import exceptions.RelativesException;
import genealogyTree.Entity;

public class ParentCreator extends EntityCreator implements Replenishable {
    @Override
    public void replenish(final Entity parent, Entity child) {
        try {
            child.addParent(parent);
            parent.addChild(child);
        } catch (RelativesException e) {
            e.printStackTrace();
        }
    }
}
