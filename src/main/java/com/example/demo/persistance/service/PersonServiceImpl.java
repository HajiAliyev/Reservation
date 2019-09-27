package com.example.demo.persistance.service;


import com.example.demo.persistance.entity.Person;
import com.example.demo.persistance.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findOne(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findByName(String seymur) {
        return personRepository.findByName(seymur); //findBy - bir standartdir Name olan hisse ise person icindeki toString-de olan name dir
    }

    @Override
    public Person find(String name, String surname, String pin) {
        return personRepository.find(name,surname,pin);
    }

    //    @Override
//    public Person findByNameAndSurname(String seymur, String hhh) {
//        return personRepository.findByNameAndSurname(seymur,hhh); //findBy - bir standartdir Name olan hisse ise person icindeki toString-de olan name dir
//    }


}
