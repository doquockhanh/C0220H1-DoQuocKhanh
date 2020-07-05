package com.codegym.models.employee;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
public class Employee implements Validator {

    @Id
    private String id;
    private String name;
    private String birthday;
    private String idCard;
    private String phoneNumber;
    private String email;

    @ManyToOne
    @JoinColumn(name="literacy_id", nullable=false)
    private Literacy literacy;//trinh do

    @ManyToOne
    @JoinColumn(name="position_id", nullable=false)
    private Position position;//vi tri

    @ManyToOne
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

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) errors;
        if(!employee.birthday.matches("[0-9]{2}[/|-][0-9]{2}[/|-][0-9]{4}")) {
            errors.rejectValue("birthday", "date");
        }
        if(!employee.email.matches("[a-zA-Z0-9\\.\\_]{1,100}[@][a-zA-Z]{1,10}[.][a-zA-Z]{1,10}")) {
            errors.rejectValue("email", "email");
        }
        if(!employee.idCard.matches("[0-9]{8}")) {
            errors.rejectValue("idCard", "id");
        }
        if(!employee.phoneNumber.matches("[0-9]{10}")) {
            errors.rejectValue("phoneNumber", "phoneNumber");
        }
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

}
