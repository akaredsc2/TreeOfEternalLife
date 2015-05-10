package genealogyTree;

import java.util.Collection;

public class GenealogyTree {
    private Collection<Entity> leafs;

    public void add(Entity e) {
        this.leafs.add(e);
    }
}
