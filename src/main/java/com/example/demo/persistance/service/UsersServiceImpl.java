package com.example.demo.persistance.service;

import com.example.demo.persistance.entity.Users;
import com.example.demo.persistance.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> findAll() {
        System.out.println("user service  = " + usersRepository.findAll());
        return usersRepository.findAll();
    }
}
