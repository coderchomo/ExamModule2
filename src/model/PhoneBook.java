package model;

import java.io.Serializable;

public class PhoneBook implements Serializable {
    private String id;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String yearOfBirth;
    private String email;
    private String numberPhone;

    public PhoneBook() {
    }

    public PhoneBook(String id, String group, String name, String gender, String address, String yearOfBirth, String email, String numberPhone) {
        this.id = id;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "id='" + id + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                '}';
    }
}
