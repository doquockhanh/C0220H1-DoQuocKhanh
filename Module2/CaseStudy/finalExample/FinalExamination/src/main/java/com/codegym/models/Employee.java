package com.codegym.models;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Employee implements Validator {

    @Id
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String groupEmployee;
    @NotEmpty
    private String birthDay;
    private String gender;
    private String phoneNumber;
    private String idCard;
    private String email;
    @NotEmpty
    private String address;

    private Boolean dateFormat(String date){
        LocalDate today = LocalDate.now();
        String[] dateElement = date.split("-");
        LocalDate birthday =
                LocalDate.of(Integer.parseInt(dateElement[0]),
                Integer.parseInt(dateElement[1]),
                Integer.parseInt(dateElement[2]));
        Period p = Period.between(birthday, today);
        if(p.getYears() >= 18){
            return true;
        }else {
            return false;
        }
    }

    public Employee() {
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;

        if(!employee.email.matches("^[a-zA-z]{1,25}[@][a-zA-z]{1,25}[.][a-zA-z]{1,25}$")){
            errors.rejectValue("email", "email");
        }

        if(employee.birthDay.isEmpty()){
            errors.rejectValue("birthDay", "outValue");
        }else if(!dateFormat(employee.birthDay)){
            errors.rejectValue("birthDay", "birthDay");
        }

        if(!(employee.gender.equals("male") || employee.gender.equals("female"))){
            errors.rejectValue("gender", "gender");
        }

        if(!employee.idCard.matches("^[0-9]{10}$")){
            errors.rejectValue("idCard", "idCard");
        }

        if(!employee.phoneNumber.matches("^[0-9]{10}$")){
            errors.rejectValue("phoneNumber", "phoneNumber");
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupEmployee() {
        return groupEmployee;
    }

    public void setGroupEmployee(String groupEmployee) {
        this.groupEmployee = groupEmployee;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}

