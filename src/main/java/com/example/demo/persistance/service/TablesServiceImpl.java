package com.example.demo.persistance.service;


import com.example.demo.model.TablesUtilDto;
import com.example.demo.persistance.entity.Person;
import com.example.demo.persistance.entity.Tables;
import com.example.demo.persistance.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class TablesServiceImpl implements TablesService {

    @Autowired
    private TablesRepository tablesRepository;

    @Override
    public List<TablesUtilDto> findByParameter2(LocalTime startTime, LocalTime endTime, LocalDate date) {
        return null;
    }
     @Override
    public List<TablesUtilDto> findByParameter6(LocalTime startTime, LocalTime endTime, LocalDate date) {
        return null;
    }

    @Override
    public List<Tables> findAll() {
        return tablesRepository.findAll();
    }

    @Override
    public List<Tables> findByType(Long type) {
        return tablesRepository.findByType(type);
    }

    @Override
    public Tables findById(Long id) {
        return tablesRepository.findById(id).orElse(null);
    }

//    @Override
//    public Optional<Tables> findById(Long id) {
//        return tablesRepository.findById(id);
//    }


}

