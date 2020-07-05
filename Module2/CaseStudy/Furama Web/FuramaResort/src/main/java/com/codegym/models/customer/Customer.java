package com.codegym.models.customer;

import com.codegym.models.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer implements Validator {

    @Id
    private String id;
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name="typeCustomer_id")
    private TypeCustomer typeCustomer;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contract = new HashSet<>();

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if(!customer.userName.matches("[a-zA-Z0-9]{5,25}")) {
            errors.rejectValue("userName", "userName");
        }
        if(!customer.passWord.matches("[a-zA-Z0-9]{7,25}")) {
            errors.rejectValue("passWord", "password");
        }
        if(!customer.firstName.matches("[a-zA-Z\\s]{1,20}")) {
            errors.rejectValue("firstName", "firstName");
        }
        if(!customer.lastName.matches("[a-zA-Z\\s]{1,20}")) {
            errors.rejectValue("lastName", "lastName");
        }
    }

    public Customer() {
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
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
