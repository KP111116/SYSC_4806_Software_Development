package com.kathan4806.sysc_4806_lab3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressBookRepo extends CrudRepository<AddressBook, Long> {
    AddressBook findByName(String name);
    Optional<AddressBook> findById(Long id);
    Iterable<AddressBook> findAll();
    void deleteById(Long id);
    void deleteByName(String name);
    void delete(AddressBook addressBook);
    AddressBook save(AddressBook addressBook);
}
