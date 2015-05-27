package genealogyTree;

import java.util.Collection;

public class GenealogyTree {
    private Collection<Person> leafs;

    public void add(Person e) {
        this.leafs.add(e);
    }
}
