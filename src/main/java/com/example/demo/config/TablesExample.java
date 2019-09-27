package com.example.demo.config;

import com.example.demo.persistance.entity.Person;
import com.example.demo.persistance.entity.Tables;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Date;
@Profile("dev")
@Configuration
public class TablesExample {

    @Bean
    public Tables tables () {
        return new Tables(Long.valueOf(1),Long.valueOf(6),"dev 6 neferlik");

    }

//    @Profile("prod")
//    @Bean
//    public Tables tablesProd () {
//        return new Tables(Long.valueOf(2),Long.valueOf(6),"prod 6 neferlik");
//
//    }
}
