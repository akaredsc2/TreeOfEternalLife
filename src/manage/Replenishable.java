package manage;

import genealogyTree.Entity;

/**
 * Created by Виталий on 4/9/2015.
 */
public interface Replenishable {
    void replenish(Entity parent, Entity child);
}
