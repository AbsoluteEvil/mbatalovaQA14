package com.tl.example.model;

public class ContactData {
    private String name;
    private String lastname;
    private String mobile;
    private String email;

    public ContactData setName(String name) {
        this.name = name;
        return this;
    }

    public ContactData setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
}
