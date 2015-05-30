package genealogyTree;

import java.util.TreeMap;

public class GenealogyTree {
    private TreeMap<String, Person> leafs;

    public GenealogyTree() {
        leafs = new TreeMap<>();
    }

    public TreeMap<String, Person> getLeafs() {
        return leafs;
    }

    public void add(Person e) {

        this.leafs.put(e.getFullName().getName(), e);
    }

    @Override
    public String toString() {
        return "GenealogyTree{" +
                "leafs=" + leafs +
                '}';
    }
}
