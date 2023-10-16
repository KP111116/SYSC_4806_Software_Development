package com.kathan4806.sysc_4806_lab3;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    //auto generate id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.MERGE)
    private List<BuddyInfo> buddies;

    public AddressBook() {
        this.buddies = new ArrayList<>();
    }
    public AddressBook(String name){
        this.name = name;
        this.buddies = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId(){
        return id;
    }

    public void addBuddy(BuddyInfo buddy){
        if(buddy != null) {
            this.buddies.add(buddy);
            System.out.println(buddy.getName() + " added to address book");
        }
    }

    public void removeBuddy(int index){
        if(index >= 0 && index < buddies.size()){
            this.buddies.remove(index);
            System.out.println(buddies.get(index).getName() + " removed from the address book");
        }
    }

    public boolean isBuddy(String name) {
        for (BuddyInfo buddyPointer : buddies) {
            if (name.equals(buddyPointer.getName())) {
                return true;
            }
        }
        return false;
    }
    public String getBuddy(){
        return buddies.toString();
    }

    @Override
    public String toString() {
        return "AddressBook \n" +
                 id +
                 name +
                ": buddies=" + buddies;
    }
}
