package genealogyTree;

public class AdditionalInfo {
    private String photoURL;
    private String about;
    private Sex sex;

    @Override
    public String toString() {
        return "AdditionalInfo{" +
                "photoURL='" + photoURL + '\'' +
                ", about='" + about + '\'' +
                ", sex=" + sex +
                '}';
    }

    public AdditionalInfo(String photoURL, String about, Sex sex) {
        this.photoURL = photoURL;
        this.about = about;
        this.sex = sex;
    }

    public Sex getSex() {
        return sex;
    }
}
