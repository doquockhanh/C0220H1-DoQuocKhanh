package com.codegym.models.rentalService;

import com.codegym.models.contract.Contract;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class House extends FuramaService{

    @Id
    protected String id;
    private Integer numberOfFloor;
    private String roomStandard;
    private String imageSource;

    @OneToOne(mappedBy = "house")
    private Contract contract;

    public House() {
    }

    public House(String name, String rentPrice, Integer maxPeople, String rentType, String id, Integer numberOfFloor, String roomStandard, String imageSource) {
        super(name, rentPrice, maxPeople, rentType);
        this.id = id;
        this.numberOfFloor = numberOfFloor;
        this.roomStandard = roomStandard;
        this.imageSource = imageSource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
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
