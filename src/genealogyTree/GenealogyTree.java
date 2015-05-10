package genealogyTree;

import java.util.LinkedList;

public class GenealogyTree {
    private LinkedList<Entity> leafs;

    public GenealogyTree() {
        this.leafs = new LinkedList<>();
    }

    public void add(Entity e) {
        this.leafs.add(e);
    }
}
