package manage;

import genealogyTree.Entity;

public class EntityCreator {
    //TODO Interface
    public Entity create() {
        try {
            //retrieve data from web form
            Entity entity = retrieve();

            //check data for being correct
            check(entity);

            //if everything is ok then return this entity
            return entity;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // if something bad happened
        return new Entity();
    }

    public Entity retrieve() {
        // Substitute received data from form to entity
        // For right now it looks like this
        return new Entity();
    }

    public void check(Entity entity) throws IllegalArgumentException {
        //something went wrong e.g. birthday is later then dayOfDeath, if person is dead
        if(entity.getBirthday() > entity.getDayOfDeath()) {
            throw new IllegalArgumentException("[STANDARDEXCEPTION] Check failed! Birthday after his own death! Kill him with holy water!");
        } else {
            System.out.println("Check succeed!");
        }
    }
}