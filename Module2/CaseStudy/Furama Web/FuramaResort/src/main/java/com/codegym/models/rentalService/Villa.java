package com.codegym.models.rentalService;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Villa extends FuramaService {

    @Id
    protected String id;
    private Integer numberOfFloor;
    private Integer pollArea;
    private String roomStandard;
    private String imageSource;

    public Villa() {
    }

    public Villa(String name, String rentPrice, Integer maxPeople, String rentType, String id,
                 Integer numberOfFloor, Integer pollArea, String roomStandard, String imageSource) {
        super(name, rentPrice, maxPeople, rentType);
        this.id = id;
        this.numberOfFloor = numberOfFloor;
        this.pollArea = pollArea;
        this.roomStandard = roomStandard;
        this.imageSource = imageSource;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPollArea() {
        return pollArea;
    }

    public void setPollArea(Integer pollArea) {
        this.pollArea = pollArea;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }
}
