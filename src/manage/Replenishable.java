package manage;

import genealogyTree.Entity;

public interface Replenishable {
    void replenish(Entity current, Entity to);
}
