package com.codegym.models.contract;

import com.codegym.models.customer.Customer;
import com.codegym.models.rentalService.House;
import com.codegym.models.rentalService.Room;
import com.codegym.models.rentalService.Villa;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Contract implements Validator {

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
    @JoinColumn(name = "contractdetail_id")
    private ContractDetail contractdetail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Contract() {
    }

    private Boolean checkDayRentService(String dateStartRent, String dateEndRent) {
        String[] dateStartElement = dateStartRent.split("-");
        LocalDate dateStart =
                LocalDate.of(Integer.parseInt(dateStartElement[0]),
                        Integer.parseInt(dateStartElement[1]),
                        Integer.parseInt(dateStartElement[2]));
        String[] dateEndElement = dateEndRent.split("-");
        LocalDate dateEnd =
                LocalDate.of(Integer.parseInt(dateEndElement[0]),
                        Integer.parseInt(dateEndElement[1]),
                        Integer.parseInt(dateEndElement[2]));

        if (dateStart.compareTo(dateEnd) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;

        if (contract.dateStartRent.isEmpty()) {
            errors.rejectValue("dateStartRent", "date");
        }

        if (contract.dateEndRent.isEmpty()) {
            errors.rejectValue("dateEndRent", "date");
        } else if (checkDayRentService(contract.dateStartRent, contract.dateEndRent)) {
            errors.rejectValue("dateEndRent", "contract.dateEndRent");
        }
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

    public Villa getVilla() {
        return villa;
    }

    public void setVilla(Villa villa) {
        this.villa = villa;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ContractDetail getContractdetail() {
        return contractdetail;
    }

    public void setContractdetail(ContractDetail contractdetail) {
        this.contractdetail = contractdetail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}

