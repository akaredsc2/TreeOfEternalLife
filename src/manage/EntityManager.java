package manage;

import genealogyTree.Entity;

public interface EntityManager {
    Entity retrieve();

    boolean check(Entity entity);

    Entity create();

    Entity update(Entity entity);

    Entity delete(Entity entity);
}
