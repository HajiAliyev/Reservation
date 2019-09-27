package com.example.demo.persistance.repository;

import com.example.demo.persistance.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>  {

    public Person findByName(String name);

//    public Person findByNameAndSurname(String name,String surname);

//    @Transactional
//    @Modifying

    @Query(value = "select p from Person p where p.name =:name and p.surname =:surname and p.pin =:pin")
    public Person find(@Param("name") String in_name, @Param("surname") String in_surname, @Param("pin") String in_pin);

}
