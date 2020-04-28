package Model;

public class Room extends Service {
    private String freeService;

    public Room(String serviceID, String nameService, String maxPeople, String rentType, String rentPrice, String freeService) {
        super(serviceID, nameService, maxPeople, rentType, rentPrice);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String showInfor(){
        return "dich vu mien phi di kem : " + freeService;
    }
}
