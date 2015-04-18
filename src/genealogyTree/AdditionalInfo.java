package genealogyTree;

/**
 * Created by Виталий on 4/18/2015.
 */
public class AdditionalInfo {
    private String photo; // just for easy hardcoding. Will be remade in lab 3, i assure you!
    private String shortInfo;
    private Sex sex;

    public AdditionalInfo(String photo, String shortInfo, Sex sex) {
        this.photo = photo;
        this.shortInfo = shortInfo;
        this.sex = sex;
    }
}
