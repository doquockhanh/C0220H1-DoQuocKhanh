package MineSweeper;

public class Box {
    private Boolean boxStatus;
    private String boxValue;

    public Box(Boolean boxStatus, String boxValue) {
        this.boxStatus = boxStatus;
        this.boxValue = boxValue;
    }

    public Boolean getBoxStatus() {
        return boxStatus;
    }

    public void setBoxStatus(Boolean boxStatus) {
        this.boxStatus = boxStatus;
    }

    public String getBoxValue() {
        return boxValue;
    }

    public void setBoxValue(String boxValue) {
        this.boxValue = boxValue;
    }
}
