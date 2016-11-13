package com.example.ddd.interfaces.rest;


import com.example.ddd.application.PeopleManager;
import com.example.ddd.domain.model.people.People;
import com.example.ddd.domain.model.people.PeopleRepository;
import com.example.ddd.infrastruct.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/peoples")
public class PeopleResource {

    @Autowired
    private PeopleManager peopleManager;

    @Autowired
    private OrikaBeanMapper mapper;

    @Autowired
    private PeopleRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PeopleManager.PeopleDTO>> getAllPeoples(Pageable pageable){
        Page<People> allPeople = repository.findAll(pageable);

        return new ResponseEntity<>(mapper.mapAsList(allPeople.getContent(), PeopleManager.PeopleDTO.class), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public void postPeople(@RequestBody PeopleManager.PeopleDTO peopleDTO){
        peopleManager.insertPeople(peopleDTO);

    }
}
