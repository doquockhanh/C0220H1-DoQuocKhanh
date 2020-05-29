public class Employer {
    private String name;
    private String address;
    private String birthDay;
    private String linkImage;

    public Employer(String name, String address, String birthDay, String linkImage) {
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.linkImage = linkImage;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getLinkImage() {
        return linkImage;
    }
}
