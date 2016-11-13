package com.example.ddd.application;

import com.example.ddd.domain.model.people.People;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

/**
 * Created by robson on 22/10/16.
 */
public class AddressDTO {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String city;


}
