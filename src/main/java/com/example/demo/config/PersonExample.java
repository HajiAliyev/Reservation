package com.example.demo.config;

import com.example.demo.persistance.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Date;

@Configuration
public class PersonExample {

//    @Profile("dev")
    @Bean
    public Person person () {
        return new Person(Long.valueOf(1),"dev","dev-surname","dev-pin",new Date(), 15.6);

    }

    @Profile("prod")
    @Bean
    public Person personProd () {
        return new Person(Long.valueOf(2),"prod","prod-surname","prod-pin",new Date(), 9.2);

    }
}
