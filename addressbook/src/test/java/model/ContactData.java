package model;

import java.io.File;
import java.util.Objects;

public class ContactData {


    private int id;
    private String name;
    private String lastname;
    private String group;
    private File photo;
    private String mobile;
    private String email;



    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, lastname);
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
    public int getId() { return id; }
}
