package com.kathan4806.sysc_4806_lab3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuddyInfoRepo extends CrudRepository<BuddyInfo, Long> {
    BuddyInfo findByName(String name);
    Optional<BuddyInfo> findById(Long id);
    Iterable<BuddyInfo> findAll();
    void deleteById(Long id);
    void deleteByName(String name);
    void delete(BuddyInfo buddy);
    BuddyInfo save(BuddyInfo buddy);

}
