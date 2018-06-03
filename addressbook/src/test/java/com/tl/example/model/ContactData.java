package com.tl.example.model;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class ContactData {
    private String name;
    private String lastname;
    private String group;
    private File photo;
    private String mobile;
    private String email;

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }
    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }
    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "name='" + name + '\'' +
                '}';
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
    public File getPhoto() {
        return photo;
    }
    public String getGroup() {
        return group;
    }
}
