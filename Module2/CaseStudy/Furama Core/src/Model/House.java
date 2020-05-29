package Model;

public class House extends Service {
    private String roomStandard;
    private String moreStandard;
    private String poolArea;

    public House(String serviceID, String nameService, String maxPeople, String rentType, String rentPrice, String roomStandard, String moreStandard, String poolArea) {
        super(serviceID, nameService, maxPeople, rentType, rentPrice);
        this.roomStandard = roomStandard;
        this.moreStandard = moreStandard;
        this.poolArea = poolArea;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getMoreStandard() {
        return moreStandard;
    }

    public void setMoreStandard(String moreStandard) {
        this.moreStandard = moreStandard;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String showInfor(){
        return "chat luong phong : " + roomStandard +
                "\ntien nghi khac : " + moreStandard +
                "\ndien tich ho boi : " + poolArea;
    }
}