package com.example.demo.persistance.service;

import com.example.demo.model.TablesUtilDto;
import com.example.demo.persistance.entity.Person;
import com.example.demo.persistance.entity.Tables;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface TablesService {

    public List<TablesUtilDto> findByParameter2( LocalTime startTime, LocalTime endTime, LocalDate date);
    public List<TablesUtilDto> findByParameter6( LocalTime startTime, LocalTime endTime, LocalDate date);
    public List<Tables> findAll();

    public List<Tables> findByType(Long type);

    public Tables findById(Long id);

}
