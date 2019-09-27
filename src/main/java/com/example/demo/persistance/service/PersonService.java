package com.example.demo.persistance.service;

import com.example.demo.persistance.entity.Person;

import java.util.List;

public interface PersonService {



    public Person findOne(Long id);

    public List<Person> findAll();

    public void remove(Long id);

    public Person save(Person person);

    Person findByName(String seymur);


//    Person findByNameAndSurname(String seymur,String hhh);

    public Person find(String name,String surname,String pin);


}
