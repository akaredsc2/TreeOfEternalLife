package genealogyTree;

public class AdditionalInfo {
    private String photoURL;
    private String shortInfo;
    private Sex sex;

    @Override
    public String toString() {
        return "AdditionalInfo{" +
                "photoURL='" + photoURL + '\'' +
                ", shortInfo='" + shortInfo + '\'' +
                ", sex=" + sex +
                '}';
    }

    public AdditionalInfo(String photoURL, String shortInfo, Sex sex) {
        this.photoURL = photoURL;
        this.shortInfo = shortInfo;
        this.sex = sex;
    }

    public Sex getSex() {
        return sex;
    }
}
