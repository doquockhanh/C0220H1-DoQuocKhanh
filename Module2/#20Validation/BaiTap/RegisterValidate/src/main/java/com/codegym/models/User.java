package com.codegym.models;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Validator {
    private String firstName;

    private String lastName;

    private String email;

    private Integer old;

    private String phoneNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;


        if (user.firstName.isEmpty()) {
            errors.rejectValue("firstName", "user.firstName");
        }

        if (user.lastName.isEmpty()) {
            errors.rejectValue("lastName", "user.lastName");
        }

        if (!user.email.matches("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")){
            errors.rejectValue("email", "user.email");
        }

        if (user.old < 18) {
            errors.rejectValue("old", "user.old");
        }
    }
}
