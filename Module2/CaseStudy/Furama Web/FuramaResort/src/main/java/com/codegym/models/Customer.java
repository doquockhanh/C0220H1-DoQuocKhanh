package com.codegym.models;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer implements Validator {
    @Id
    private Integer id;
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if(!customer.userName.matches("[a-zA-Z0-9]{5,25}")) {
            errors.rejectValue("userName", "customer.userName");
        }
        if(!customer.passWord.matches("[a-zA-Z0-9]{7,25}")) {
            errors.rejectValue("passWord", "customer.password");
        }
        if(!customer.firstName.matches("[a-zA-Z\\s]{1,20}")) {
            errors.rejectValue("firstName", "customer.firstName");
        }
        if(!customer.lastName.matches("[a-zA-Z\\s]{1,20}")) {
            errors.rejectValue("lastName", "customer.lastName");
        }
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
