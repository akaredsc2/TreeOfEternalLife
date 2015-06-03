package genealogyTree;

public class AdditionalInfo {
    private String photoURL;
    private String about;
    private Sex sex;

    public String getPhotoURL() {
        return photoURL;
    }

    public String getAbout() {
        return about;
    }

    public Sex getSex() {
        return sex;
    }

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
}
