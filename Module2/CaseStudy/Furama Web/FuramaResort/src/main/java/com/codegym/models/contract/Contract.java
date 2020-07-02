package com.codegym.models.contract;

import com.codegym.models.rentalService.House;
import com.codegym.models.rentalService.Room;
import com.codegym.models.rentalService.Villa;

import javax.persistence.*;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String dateStartRent;
    private String dateEndRent;

    private String deposits;
    private String totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "villa_id", referencedColumnName = "id")
    private Villa villa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private House house;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contractdetail_id")
    private ContractDetail contractdetail;

    public Contract() {
    }

    public Contract(Integer id, String dateStartRent, String dateEndRent, String deposits, String totalPrice) {
        this.id = id;
        this.dateStartRent = dateStartRent;
        this.dateEndRent = dateEndRent;
        this.deposits = deposits;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateStartRent() {
        return dateStartRent;
    }

    public void setDateStartRent(String dateStartRent) {
        this.dateStartRent = dateStartRent;
    }

    public String getDateEndRent() {
        return dateEndRent;
    }

    public void setDateEndRent(String dateEndRent) {
        this.dateEndRent = dateEndRent;
    }

    public String getDeposits() {
        return deposits;
    }

    public void setDeposits(String deposits) {
        this.deposits = deposits;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}

