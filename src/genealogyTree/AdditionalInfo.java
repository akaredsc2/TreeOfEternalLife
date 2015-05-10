package genealogyTree;

public class AdditionalInfo {
    private String photoURL;
    private String shortInfo;
    private Sex sex;

    public AdditionalInfo(String photoURL, String shortInfo, Sex sex) {
        this.photoURL = photoURL;
        this.shortInfo = shortInfo;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "AdditionalInfo{\n" +
                "\tphotoURL='\n" + photoURL + '\'' +
                "\t, shortInfo='\n" + shortInfo + '\'' +
                "\t, sex=\n" + sex +
                '}';
    }

    public Sex getSex() {
        return sex;
    }
}
