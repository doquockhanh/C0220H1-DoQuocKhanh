package com.codegym.models.employee;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    private String id;
    private String name;
    private String birthday;
    private String idCard;
    private String phoneNumber;
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="literacy_id", nullable=false)
    private Literacy literacy;//trinh do

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="position_id", nullable=false)
    private Position position;//vi tri

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="department_id", nullable=false)
    private Department department;//bo phan

    public Employee() {
    }

    public Employee(String id, String name, String birthday,
                    String idCard, String phoneNumber, String email,
                    Literacy literacy, Position position, Department department) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.literacy = literacy;
        this.position = position;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Literacy getLiteracy() {
        return literacy;
    }

    public void setLiteracy(Literacy literacy) {
        this.literacy = literacy;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
