package Model;

public class Customer {
    private String name;
    private String birthDay;
    private String gender;
    private String IDNumber;
    private String phoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private String useService;

    public Customer(
            String name, String birthDay, String gender, String IDNumber, String phoneNumber,
            String email, String typeCustomer, String address, String useService
    ) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.IDNumber = IDNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.useService = useService;
    }

    public String getName() {
        return name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getGender() {
        return gender;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public String getUseService() {
        return useService;
    }

    public String showInfor() {
        return "ten khach hang : " + name +
                "\nngay sinh : " + birthDay +
                "\ngioi tinh : " + gender +
                "\nCmnd : " + IDNumber +
                "\nso dien thoai : " + phoneNumber +
                "\nemail : " + email +
                "\nloai khach hang : " + typeCustomer +
                "\ndia chi : " + address +
                "\ndich vu su dung : " + useService;
    }
}
