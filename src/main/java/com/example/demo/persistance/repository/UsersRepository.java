package com.example.demo.persistance.repository;


import com.example.demo.persistance.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
//    Users findByUsername(String username);

}
