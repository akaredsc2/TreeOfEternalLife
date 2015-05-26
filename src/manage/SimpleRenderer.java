package manage;

import genealogyTree.GenealogyTree;
import genealogyTree.Person;

public class SimpleRenderer {
    GenealogyTree tree;
    Person root;

    public void renderFromLeaf(Person person) {
        draw(person);
        for (Person child : person.getChildren())
            renderFromLeaf(child);
        for (Person parent : person.getParents())
            renderFromLeaf(parent);
    }

    public void draw(Person person) {
//draw
    }

    public void setRoot() {
//        find farthest child
    }

    public void renderTree() {
        setRoot();
        renderFromLeaf(root);
    }
}

//TODO Person class: isDrawn indicator
//TODO Advanced authorization with sessions
//TODO Creation factory
//TODO Dropdown menus in creation
