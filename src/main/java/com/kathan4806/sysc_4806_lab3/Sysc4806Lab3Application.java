package com.kathan4806.sysc_4806_lab3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class Sysc4806Lab3Application {

    private static final Logger log = LoggerFactory.getLogger(Sysc4806Lab3Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Sysc4806Lab3Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepo buddyInfoRepo){
        return (args) -> {
            //save a few buddies
            buddyInfoRepo.save(new BuddyInfo("Buddy 1", "Address 1", "613-111-1111"));
            buddyInfoRepo.save(new BuddyInfo("Buddy 2", "Address 2", "613-222-2222"));
            buddyInfoRepo.save(new BuddyInfo("Buddy 3", "Address 3", "613-333-3333"));
            buddyInfoRepo.save(new BuddyInfo("Buddy 4", "Address 4", "613-444-4444"));
            buddyInfoRepo.save(new BuddyInfo("Buddy 5", "Address 5", "613-555-5555"));

            //fetch all buddies
            log.info("Buddies found with findAll():");
            log.info("-------------------------------");
            for(BuddyInfo buddyInfo : buddyInfoRepo.findAll()){
                log.info(buddyInfo.toString());
            }
            log.info("");

            //fetch an individual buddy by ID
            Optional<BuddyInfo> buddyInfo = buddyInfoRepo.findById(1L);
            log.info("Buddy found with findById(1L):");
            log.info("--------------------------------");
            log.info(buddyInfo.toString());
            log.info("");

        };
    }
    @Bean
    public CommandLineRunner demo(AddressBookRepo addressBookRepo){
        return (args) -> {
            //save a few address books
            AddressBook addressBook1 = new AddressBook("Address Book 1");
            AddressBook addressBook2 = new AddressBook("Address Book 2");

            //add buddies to address book 1
            BuddyInfo buddy1 = new BuddyInfo("Buddy 1", "Address 1", "613-111-1111");
            BuddyInfo buddy2 = new BuddyInfo("Buddy 2", "Address 2", "613-222-2222");
            BuddyInfo buddy3 = new BuddyInfo("Buddy 3", "Address 3", "613-333-3333");
            addressBook1.addBuddy(buddy1);
            addressBook1.addBuddy(buddy2);
            addressBook1.addBuddy(buddy3);
            addressBookRepo.save(addressBook1);
            System.out.println(addressBook1);

            //add buddies to address book 2
            BuddyInfo buddy4 = new BuddyInfo("Buddy 4", "Address 4", "613-444-4444");
            BuddyInfo buddy5 = new BuddyInfo("Buddy 5", "Address 5", "613-555-5555");
            addressBook2.addBuddy(buddy4);
            addressBook2.addBuddy(buddy5);
            addressBookRepo.save(addressBook2);

        };
    }


}
