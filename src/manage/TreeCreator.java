package manage;

import genealogyTree.GenealogyTree;

public class TreeCreator {
    private EntityCreator entityMaker;
    private ChildCreator childMaker;
    private Replenishable parentMaker;
    private EntityRemover grimReaper;

    public GenealogyTree create() {
        return new GenealogyTree();
    }
}
