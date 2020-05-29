package Model;

public class Service {
    private String serviceID;
    private String nameService;
    private String maxPeople;
    private String rentType;
    private String rentPrice;

    public Service(String serviceID, String nameService, String maxPeople, String rentType, String rentPrice) {
        this.serviceID = serviceID;
        this.nameService = nameService;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.rentPrice = rentPrice;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String showInfor(){
        return "ten dich vu : " + this.nameService +
                "\nso nguoi toi da : " + this.maxPeople +
                "\nkieu thue : " + rentType +
                "\ngia thue : " + rentPrice + "\n";
    }
}