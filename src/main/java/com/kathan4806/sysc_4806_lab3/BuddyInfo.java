package com.kathan4806.sysc_4806_lab3;

import jakarta.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "addressBookId")
    private AddressBook addressBook;
    public BuddyInfo(){
        this.name = "John Doe";
        this.address = "1234 Main St";
        this.phoneNumber = "613-555-5555";
    }
    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return  name +
                " " + address +
                " " + phoneNumber;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
