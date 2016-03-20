package com.dummy.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * User bean for user related data.
 */
@Component
@Scope("session")
public class User {


    private Integer userId;

    private String name;

    private Integer appId;

    private String email;

    private String password;

    private String address;

    private Integer mobileNumber;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
