package com.codegym.models.rentalService;

import javax.persistence.Entity;

@Entity
public class Villa extends Service {
    private Integer numberOfFloor;
    private Integer pollArea;

    public Villa() {
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public Integer getPollArea() {
        return pollArea;
    }

    public void setPollArea(Integer pollArea) {
        this.pollArea = pollArea;
    }
}
