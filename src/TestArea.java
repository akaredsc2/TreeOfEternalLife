import exceptions.RelativesException;
import genealogyTree.Entity;
import manage.HardcodedEntityCreator;

public class TestArea {
    public static void main(String[] args) {
        HardcodedEntityCreator hard = new HardcodedEntityCreator();
        Entity subject = hard.create();

        //TODO Handle standard exception
        //TODO Refactor THA FUC out of it
        //TODO Unit-tests may be?

        for (int i = 0; i < 10; i++) {
            try {
                if (hard.hasNext()) {
                    subject.addChild(hard.create());
                } else {
                    System.out.println("[FAILED] No new entities");
                }
            } catch (RelativesException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}