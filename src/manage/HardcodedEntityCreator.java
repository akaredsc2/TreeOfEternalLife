package manage;

import genealogyTree.*;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public class HardcodedEntityCreator {


    public Entity create1() {
        //retrieve info from web form

        FullName fullName = new FullName("Vitaly","Sharapov");

        LifeTime lifeTime = new LifeTime(new Date(1081995));

        Collection<Entity> parents = new LinkedList<>();
        Collection<Entity> children = new LinkedList<>();

        AdditionalInfo info = new AdditionalInfo("myPhoto", "I already told you, get lost!", Sex.MALE);

        return new Entity(fullName, lifeTime, parents, children, info);
    }
    public Entity create2() {
        //retrieve info from web form

        FullName fullName = new FullName("Alice","Sharapova");

        LifeTime lifeTime = new LifeTime(new Date(23042013));

        Collection<Entity> parents = new LinkedList<>();
        Collection<Entity> children = new LinkedList<>();

        AdditionalInfo info = new AdditionalInfo("Instastop crying after looking on her uncle", "almost two years old child", Sex.FEMALE);

        return new Entity(fullName, lifeTime, parents, children, info);
    }
    public Entity create3() {
        //retrieve info from web form

        FullName fullName = new FullName("Victor","Sharapov");

        LifeTime lifeTime = new LifeTime(new Date(24021964));

        Collection<Entity> parents = new LinkedList<>();
        Collection<Entity> children = new LinkedList<>();

        AdditionalInfo info = new AdditionalInfo("photoFrom50YearsCelebration", "50 years old ex-military man", Sex.MALE);


        return new Entity(fullName, lifeTime, parents, children, info);
    }
    public Entity create4() {
        //retrieve info from web form

        FullName fullName = new FullName("Denis","Sharapov");

        LifeTime lifeTime = new LifeTime(new Date(19051983));

        Collection<Entity> parents = new LinkedList<>();
        Collection<Entity> children = new LinkedList<>();

        AdditionalInfo info = new AdditionalInfo("HappyDad", "Not really", Sex.MALE);


        return new Entity(fullName, lifeTime, parents, children, info);
    }
    public Entity create5() {
        //retrieve info from web form

        FullName fullName = new FullName("Tatajna","Sharapova");

        LifeTime lifeTime = new LifeTime(new Date(24021964));

        Collection<Entity> parents = new LinkedList<>();
        Collection<Entity> children = new LinkedList<>();

        AdditionalInfo info = new AdditionalInfo("Complaining about her son being to smart in IT", "Nurse", Sex.FEMALE);


        return new Entity(fullName, lifeTime, parents, children, info);
    }
}
