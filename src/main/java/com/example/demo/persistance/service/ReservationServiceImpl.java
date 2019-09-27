package com.example.demo.persistance.service;

import com.example.demo.persistance.entity.Reservation;
import com.example.demo.persistance.repository.ReservationRepository;
import com.example.demo.persistance.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> findByReservDateAndStartTimeAndEndTime(LocalDate reservDate, LocalTime startTime, LocalTime endTime) {
        return reservationRepository.findByReservDateAndStartTimeAndEndTime(reservDate, startTime, endTime);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }


}


