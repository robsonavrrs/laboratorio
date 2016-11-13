package com.example.ddd.domain.model.people;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by robson on 08/10/16.
 */

@Configurable("people")
@Entity
@Table(name="TB_PEOPLE")
public class People implements Serializable{


    private static final long serialVersionUID = -7853905372985460440L;

    @javax.persistence.Transient
    @Autowired
    private PeopleRepository repository;

    @Id
    @Column(name = "ID_PEOPLE")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "NOME", nullable = false)
    @Getter
    @Setter
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PEOPLE")
    @OrderBy
    @Getter
    //@Setter
    private List<Address> addressList;

    public void setAddressList(List<Address> addresses){

        addresses.forEach(a->a.setPeople(this));
        this.addressList = addresses;

    }

    public People save(){
        return repository.save(this);
    }

    public void delete(){
        repository.delete(this);
    }

}
