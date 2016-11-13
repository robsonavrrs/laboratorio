package com.example.ddd.application;

import com.example.ddd.domain.model.people.Address;
import com.example.ddd.domain.model.people.People;
import com.example.ddd.domain.model.people.PeopleRepository;
import com.example.ddd.infrastruct.OrikaBeanMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by robson on 08/10/16.
 */
@Service
@Transactional(readOnly =  true)
public class PeopleManager {

    @Autowired
    private PeopleRepository repository;

    @Autowired
    private OrikaBeanMapper mapper;



    @Transactional
    public People insertPeople(PeopleDTO dto){
        People newPeople = mapper.map(dto, People.class);
        return repository.save(newPeople);
    }


    public List<People> findAllPeople(){
        List<People> peoples = repository.findAll();

        return peoples;
    }

    public static class PeopleDTO implements Serializable {

        private static final long serialVersionUID = -8617208437762389040L;

        @Getter
        @Setter
        private Long id;

        @NotNull
        @Getter
        @Setter
        private String name;

        @Getter
        @Setter
        private List<AddressDTO> addressList;


    }
}
