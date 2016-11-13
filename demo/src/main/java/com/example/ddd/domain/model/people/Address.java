package com.example.ddd.domain.model.people;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by robson on 20/10/16.
 */
@Entity
@Table(name="TB_ADDRESS")
public class Address {

    @Id
    @Column(name = "ID_ADDRESS")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;


    @Column(name = "CITY_NAME")
    @Getter
    @Setter
    private String city;


    @ManyToOne
    @Getter
    @Setter
    private People people;


}
