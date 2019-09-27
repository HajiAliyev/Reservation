package com.example.demo.persistance.service;

import com.example.demo.persistance.entity.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface ReservationService {
     public List<Reservation>  findAll();

     public List<Reservation> findByReservDateAndStartTimeAndEndTime(LocalDate reservDate, LocalTime startTime, LocalTime endTime);

     public Reservation save(Reservation reservation);

}
