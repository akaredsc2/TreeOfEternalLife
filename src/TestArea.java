import genealogyTree.Entity;
import manage.HardcodedEntityCreator;

public class TestArea {
    public static void main(String[] args) {
        HardcodedEntityCreator creator = new HardcodedEntityCreator();

        Entity vitaly = creator.create1();
        Entity alice = creator.create2();
        Entity victor = creator.create3();
        Entity denis = creator.create4();
        Entity tatjana = creator.create5();

        //Some weird stuff here!
    }
}
