package Model;

public class Employee {
    //: Họ tên Employee ,tuổi , địa chỉ và phương thức toString().
    private String nameEmployee;
    private String oldEmployee;
    private String addressEmployee;

    public Employee(String nameEmployee, String oldEmployee, String addressEmployee) {
        this.nameEmployee = nameEmployee;
        this.oldEmployee = oldEmployee;
        this.addressEmployee = addressEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public String getOldEmployee() {
        return oldEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nameEmployee='" + nameEmployee + '\'' +
                ", oldEmployee='" + oldEmployee + '\'' +
                ", addressEmployee='" + addressEmployee + '\'' +
                '}';
    }
}
