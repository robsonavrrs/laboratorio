package com.example.ddd.domain.model.people;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by robson on 08/10/16.
 */
public interface PeopleRepository extends JpaRepository<People, Long> {

    @Query("select p from People p join fetch p.addressList ")
    public List<People> searchAll();
}
